package com.beaconfire.springsecurityauth.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String role_name;

    @Column
    private String role_description;

    @Column
    private Date create_date;

    @Column
    private Date last_modification_date;

    @ManyToMany(mappedBy = "roleSet")
    private Set<User> userSet = new HashSet<>();

}
