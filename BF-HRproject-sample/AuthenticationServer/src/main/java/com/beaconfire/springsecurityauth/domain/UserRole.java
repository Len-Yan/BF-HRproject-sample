package com.beaconfire.springsecurityauth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user_role")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer user_id;

    @Column
    private Integer role_id;

    @Column
    private Boolean activate_flag;

    @Column
    private Date create_date;

    @Column
    private Date last_modification_date;
}
