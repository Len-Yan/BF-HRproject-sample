package com.example.empappcompositeservice.service.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jliao
 */
@FeignClient("employee-service")
public interface RemoteEmployeeService {

//    @GetMapping("employee-service/sss")

}
