package com.xworkz.registraition.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_information")
@NamedQuery(name = "acceptLogin",query = "select a from UserEntity a where a.email=:email ")
@NamedQuery(name = "getByEmail",query = "select a.email from UserEntity a where a.email = :email")
@NamedQuery(name = "getByMobile",query = "select a.mobile from UserEntity a where a.mobile = :mobile")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Column(name = "user_name")
    private String name;


    @Column(name = "user_email")
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

    @Column(name = "user_confirmPassword")
    private String confirmPassword;

    private boolean isPresent;
}
