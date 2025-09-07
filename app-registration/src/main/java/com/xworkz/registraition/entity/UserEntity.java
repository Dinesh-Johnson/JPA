package com.xworkz.registraition.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_information")
@NamedQuery(name = "acceptLogin",query = "select a from UserEntity a where a.email=:email and a.isPresent=true")
@NamedQuery(name = "getByEmail",query = "select a.email from UserEntity a where a.email = :email and a.isPresent=true")
@NamedQuery(name = "getByMobile",query = "select a.mobile from UserEntity a where a.mobile = :mobile and a.isPresent=true")
@NamedQuery(name = "getPassword",query = "select a.password from UserEntity a where a.email=:email and a.isPresent=true")
@NamedQuery(name = "updateById",query = "update UserEntity a set a.name=:name,a.mobile=:mobile,a.dob=:dob," +
        "a.state=:state,a.address=:address,a.filePath=:filePath,a.district=:district,a.pincode=:pincode where a.id=:id and a.isPresent=true")
@NamedQuery(name = "setOtpByMail",query = "update UserEntity a set a.password=:otp where a.email=:email and a.isPresent=true")
@NamedQuery(name = "updatePassword",query = "update UserEntity a set a.password=:password, a.loginCount=0 where" +
        " a.email=:email and a.isPresent=true")
@NamedQuery(name = "getAllEmails",query = "select e.email from UserEntity e")
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

    @Column(name = "user_district")
    private String district;


    @Column(name = "user_pincode")
    private String pincode;

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

    @Column(name = "file_path")
    private String filePath;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "userEntity")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AuditEntity audit;

    @PrePersist
    public void preSave() {
        if (audit == null) {
            audit = new AuditEntity();
            audit.setUserEntity(this);
        }
        audit.setCreatedBy(this.name);
        audit.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preEdit() {
        if (audit == null) {
            audit = new AuditEntity();
            audit.setUserEntity(this);
        }
        audit.setModifiedBy(this.name);
        audit.setModifiedAt(LocalDateTime.now());
    }


}
