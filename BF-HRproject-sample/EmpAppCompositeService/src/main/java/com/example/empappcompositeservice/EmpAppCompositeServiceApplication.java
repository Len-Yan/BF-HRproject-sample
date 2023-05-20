package com.example.empappcompositeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jliao
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EmpAppCompositeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpAppCompositeServiceApplication.class, args);
    }

}
