package com.beaconfire.springsecurityauth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="registration_token")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String token;

    @Column
    private String email;

    @Column
    private Date expiration_date;

    @Column
    private String create_by;
}
