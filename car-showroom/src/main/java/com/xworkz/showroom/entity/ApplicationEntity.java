package com.xworkz.showroom.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@Table(name = "application_info")
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationID;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "application_size")
    private String applicationSize;

    @Column(name = "company")
    private  String company;

    @Column(name = "no_of_users")
    private Integer noOfUsers;

    @Column(name = "ratings")
    private Float ratings;

    @Column(name = "launch_date")
    private LocalDate  launchDate;
}
