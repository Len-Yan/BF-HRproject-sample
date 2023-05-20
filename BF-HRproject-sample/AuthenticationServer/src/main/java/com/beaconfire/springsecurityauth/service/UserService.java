package com.beaconfire.springsecurityauth.service;

import com.beaconfire.springsecurityauth.dao.UserDao;
import com.beaconfire.springsecurityauth.domain.RegistrationToken;
import com.beaconfire.springsecurityauth.domain.Role;
import com.beaconfire.springsecurityauth.domain.User;
import com.beaconfire.springsecurityauth.domain.request.CreateAccountRequest;
import com.beaconfire.springsecurityauth.domain.request.GenerateTokenRequest;
import com.beaconfire.springsecurityauth.domain.response.GenerateTokenResponse;
import com.beaconfire.springsecurityauth.security.AuthUserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userDao.loadUserByUsername(username);

        //convert to user entity
        if (!userOptional.isPresent()){
            throw new UsernameNotFoundException("Username does not exist");
        }

        User user = userOptional.get();

        return AuthUserDetail.builder()
                .username(user.getUsername())
                .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                .authorities(getAuthoritiesFromUser(user))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
    }

    private List<GrantedAuthority> getAuthoritiesFromUser(User user){
        List<GrantedAuthority> userAuthorities = new ArrayList<>();
        for (Role role :  user.getRoleSet()){
            String permission = role.toString();
            userAuthorities.add(new SimpleGrantedAuthority(permission));
        }

        return userAuthorities;
    }




    //create account
    public void addUser(User user){
        userDao.addUser(user);
    }

    public boolean checkTokenByEmail(String email, String token) {

        String dbToken = userDao.getTokenByEmail(email);
        if (dbToken.equals("NULL")) {
            return false;
        }
//        System.out.println("dbtttttttttt" + dbToken);
//        System.out.println("tokttttttttt"+token);
        return token.equals(dbToken);
    }


    //generate token
    private String createToken(String email) {
        Claims claims = Jwts.claims().setSubject(email);
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, "JavaTraining") //key is in application.properties
                .compact();
    }

    public RegistrationToken addToken(GenerateTokenRequest request) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, 24);
        Timestamp ts = new Timestamp(calendar.getTimeInMillis());

        String newToken = createToken(request.getEmail());

        RegistrationToken registrationToken = RegistrationToken.builder()
                .email(request.getEmail())
                .expiration_date(ts)
                .token(newToken)
                .build();

        userDao.addToken(registrationToken);
        return registrationToken;
    }

}
