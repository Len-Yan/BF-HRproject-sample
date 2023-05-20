package com.example.empappcompositeservice.entity.EmployeeService;

import lombok.*;

import java.util.Date;

/**
 * @author jliao
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String id;

    private String userID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String preferedName;
    private String email;
    private String cellPhone;
    private String alternatePhone;
    private String gender;
    private String SSN;
    private Date DOB;
    private Date startDate;
    private Date endDate;
    private String driverLicense;
    private Date driverLicenseExpiration;
    private Integer houseID;

}
