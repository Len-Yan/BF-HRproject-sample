package com.beaconfire.springsecurityauth.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequest {
    private String username;
    private String password;
    private String email;
    private String token;
    private String createBy;
}
