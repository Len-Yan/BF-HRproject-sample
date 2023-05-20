package com.example.empappcompositeservice.service.remote;


import com.example.empappcompositeservice.domain.ApplicationService.ApplicationSubmitSucceedResponse;
import com.example.empappcompositeservice.entity.ApplicationService.ApplicationStatus;
import com.example.empappcompositeservice.entity.ApplicationService.ApplicationWorkFlow;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author jliao
 */
@FeignClient("application-service")
public interface RemoteApplicationService {

    @GetMapping("applicationWorkFlow/all")
    List<ApplicationWorkFlow> getAllApplicationWorkFlow();

    @GetMapping("applicationWorkFlow/get/{eid}")
    ApplicationWorkFlow getApplicationWorkFlowById(@PathVariable String eid);

    @PostMapping("applicationWorkFlow/add/{eid}")
    ApplicationSubmitSucceedResponse submitApplicationForm(@PathVariable String eid,
                                                           @RequestParam("employee") String employee,
                                                           @RequestParam("files") MultipartFile[] files) throws IOException;

    @PutMapping("applicationWorkFlow/updateComment/{eid}")
    String updateCommentById(@PathVariable String eid, @RequestBody String comment);

    @PutMapping("applicationWorkFlow/updateStatus/{eid}")
    String updateApplicationWorkFlowStatus(@PathVariable String eid,
                                           @RequestBody ApplicationStatus status);

}
