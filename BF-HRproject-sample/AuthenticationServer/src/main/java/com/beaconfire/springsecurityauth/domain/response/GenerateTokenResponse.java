package com.beaconfire.springsecurityauth.domain.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class GenerateTokenResponse {
    private Boolean success;
    private String message;
}
