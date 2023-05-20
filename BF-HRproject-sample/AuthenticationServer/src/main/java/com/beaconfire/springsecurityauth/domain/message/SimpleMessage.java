package com.beaconfire.springsecurityauth.domain.message;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class SimpleMessage {
    private String email;
    private String title;
    private String description;
}
