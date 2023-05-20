package com.example.empappcompositeservice.domain;

import com.example.empappcompositeservice.domain.ApplicationService.ApplicationSubmitSucceedResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jliao
 */
@Getter
@Setter
@Builder
public class EmployeeApplicationResponse {
    ApplicationSubmitSucceedResponse applicationResponse;
}
