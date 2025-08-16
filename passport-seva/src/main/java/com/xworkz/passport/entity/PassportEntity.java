package com.xworkz.passport.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "passport_info")
@NamedQuery(name = "getByEmail",query = "select a.email from PassportEntity a where a.email = :email")
@NamedQuery(name = "getByMobile",query = "select a.mobile from PassportEntity a where a.mobile = :mobile")
@NamedQuery(name = "getByloginId",query = "select a.loginId from PassportEntity a where a.loginId = :loginId")
@NamedQuery(name = "updateById",query = "update PassportEntity a set a.passportOffice=:passportOffice,a.name=:name," +
        "a.surname=:surname,a.dob=:dob,a.email=:email,a.mobile=:mobile,a.loginId=:loginId,a.loginIdSameAsEmail=:loginIdSameAsEmail," +
        "a.password=:password,a.confirmPassword=:confirmPassword,a.hintQuestion=:hintQuestion,a.hintAnswer=:hintAnswer where a.passportId=:passportId")
@NamedQuery(name = "findAll",query = "select a from PassportEntity a")
@NamedQuery(name = "deleteById",query = "delete from PassportEntity a where a.passportId=:passportId")
@NamedQuery(name = "getByUserName",query = "select a from PassportEntity a where a.name=:name")
@NamedQuery(name = "fetchById",query = "select a from PassportEntity a where a.passportId=:passportId")
public class PassportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Integer passportId;

    @Column(name = "passport_office")
    private String passportOffice;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "dob")
    private String dob;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private Long mobile;

    @Column(name="login_id")
    private String loginId;

    @Column(name = "login_id_same_email")
    private String loginIdSameAsEmail;

    @Column(name = "password")
    private String password;

    @Column(name = "confirm_password")
    private String confirmPassword;

    @Column(name="hint_question")
    private String hintQuestion;

    @Column(name = "hint_answer")
    private String hintAnswer;
}

