package com.beaconfire.springsecurityauth.domain.response;

import com.beaconfire.springsecurityauth.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateAccountResponse {
    private Boolean success;
    private String message;
    private User user;
}
