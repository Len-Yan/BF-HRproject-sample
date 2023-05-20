package com.beaconfire.springsecurityauth.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;



@Entity
@Table(name="user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Date create_date;

    @Column
    private Date last_modification_date;

    @Column
    private Boolean activate_flag;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> roleSet;



}