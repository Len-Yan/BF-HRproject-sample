package com.beaconfire.springsecurityauth.controller;

import com.beaconfire.springsecurityauth.domain.RegistrationToken;
import com.beaconfire.springsecurityauth.domain.Role;
import com.beaconfire.springsecurityauth.domain.User;
import com.beaconfire.springsecurityauth.domain.message.SimpleMessage;
import com.beaconfire.springsecurityauth.domain.request.CreateAccountRequest;
import com.beaconfire.springsecurityauth.domain.request.GenerateTokenRequest;
import com.beaconfire.springsecurityauth.domain.request.LoginRequest;
import com.beaconfire.springsecurityauth.domain.request.NewMessageRequest;
import com.beaconfire.springsecurityauth.domain.response.CreateAccountResponse;
import com.beaconfire.springsecurityauth.domain.response.GenerateTokenResponse;
import com.beaconfire.springsecurityauth.domain.response.LoginResponse;
import com.beaconfire.springsecurityauth.security.AuthUserDetail;
import com.beaconfire.springsecurityauth.security.JwtProvider;
import com.beaconfire.springsecurityauth.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
public class AutheticationController {

    private AuthenticationManager authenticationManager;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    private JwtProvider jwtProvider;

    @Autowired
    public void setJwtProvider(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @PostMapping("account/login")
    public LoginResponse login(@RequestBody LoginRequest request){

        Authentication authentication;

        try{
          authentication = authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
          );
        } catch (AuthenticationException e){
            throw new BadCredentialsException("Provided credential is invalid.");
        }

        AuthUserDetail authUserDetail = (AuthUserDetail) authentication.getPrincipal();

        String token = jwtProvider.createToken(authUserDetail);

        return LoginResponse.builder()
                .message("Welcome " + authUserDetail.getUsername())
                .token(token)
                .build();

    }


    @PostMapping("account/generateToken")
    public GenerateTokenResponse generateToken(@RequestBody GenerateTokenRequest request){
        RegistrationToken registrationToken = userService.addToken(request);

        SimpleMessage newMessage = SimpleMessage.builder()
                .email(request.getEmail())
                .title("Employee Token")
                .description(registrationToken.getToken())
                .build();

        rabbitTemplate.convertAndSend("emailService", "token." + request.getEmail(),
                newMessage.getDescription().toString());

        ResponseEntity.ok("Message Sent");
        return GenerateTokenResponse.builder()
                .success(true).message("Success generate token")
                .build();
    }



    @PostMapping("account/register")
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request){
        if (userService.checkTokenByEmail(request.getEmail(), request.getToken())) {
            User newUser = User.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .create_date(new Date(System.currentTimeMillis()))
                    .activate_flag(true)
                    .build();

            Set<Role> roles = new HashSet<>();
            roles.add(
                    Role.builder()
                            .role_name("Employee")
                            .role_description("normal access")
                            .create_date(new Date(System.currentTimeMillis()))
                            .build()
            );

            newUser.setRoleSet(roles);

            userService.addUser(newUser);

            return CreateAccountResponse.builder()
                    .success(true)
                    .message("Successfully create a new account")
                    .user(newUser)
                    .build();
        } else {
            return CreateAccountResponse.builder()
                    .success(false)
                    .message("Token is mot match")
                    .build();
        }
    }




}
