package com.example.empappcompositeservice.service;

import com.example.empappcompositeservice.domain.ApplicationService.ApplicationSubmitSucceedResponse;
import com.example.empappcompositeservice.service.remote.RemoteApplicationService;
import com.example.empappcompositeservice.service.remote.RemoteEmployeeService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author jliao
 */
@Service
public class CompositeService {

    private RemoteEmployeeService employeeService;
    private RemoteApplicationService applicationService;
    private RestTemplate restTemplate;

    @Autowired
    public void setEmployeeService(RemoteEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setApplicationService(RemoteApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    public ApplicationSubmitSucceedResponse getAllHousesAndUsersRest(){
//        ResponseEntity<ApplicationSubmitSucceedResponse> housingResponse = restTemplate.exchange(
//                "http://application-service/application-service/applicationWorkFlow/add/",
//                HttpMethod.PUT, null, ApplicationSubmitSucceedResponse.class
//        );
//
//        ResponseEntity<AllUsersResponse> userResponse = restTemplate.exchange(
//                "http://employee-service/user-service/user", HttpMethod.GET, null, AllUsersResponse.class
//        );
//
//        return HousingUserResponse.builder()
//                .users(userResponse.getBody().getUsers())
//                .houses(housingResponse.getBody().getHouseList())
//                .build();
//    }



}
