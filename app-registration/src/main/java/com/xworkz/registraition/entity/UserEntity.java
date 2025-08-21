package com.xworkz.registraition.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_information")
@NamedQuery(name = "acceptLogin",query = "select a from UserEntity a where a.email=:email and a.isPresent=true")
@NamedQuery(name = "getByEmail",query = "select a.email from UserEntity a where a.email = :email and a.isPresent=true")
@NamedQuery(name = "getByMobile",query = "select a.mobile from UserEntity a where a.mobile = :mobile and a.isPresent=true")
@NamedQuery(name = "getPassword",query = "select a.password from UserEntity a where a.email=:email and a.isPresent=true")
@NamedQuery(name = "updatePassword",query = "update UserEntity a set a.password=:password, a.loginCount=0 where a.email=:email and a.isPresent=true")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Column(name = "user_name")
    private String name;


    @Column(name = "user_email",unique = true)
    private String email;

    @Column(name = "user_mobile")
    private Long mobile;

    @Column(name = "user_dob")
    private String dob;

    @Column(name = "user_gender")
    private String gender;

    @Column(name = "user_state")
    private String state;

    @Column(name = "user_address")
    private String address;

    @Column(name = "user_password")
    private String password;

    @Column(name = "is_present", nullable = false)
    private boolean isPresent = true;

    @Column(name = "login_count")
    private Integer loginCount;

    @Column(name = "expiry_time")
    private LocalDateTime expiryTime;

}
