package com.xworkz.demo.passport;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "passport_applications")
public class PassportApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private int id;

    @Column(name = "applicant_name")
    private String name;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "dob")
    private String dob;

    @Column(name = "status")
    private String status;
}
