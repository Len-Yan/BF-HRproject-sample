package com.example.empappcompositeservice.domain.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jliao
 */
@Getter
@Setter
@Builder
public class ResponseStatus {
    private Boolean success;
    private String message;
}
