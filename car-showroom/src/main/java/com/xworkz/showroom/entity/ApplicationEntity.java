package com.xworkz.showroom.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@Table(name = "application_info")

@NamedQuery(name = "findByApplicationName",query = "select a from ApplicationEntity a where a.applicationName = :name")
@NamedQuery(name = "findByApplicationSize",query = "select a from ApplicationEntity a where a.applicationSize = :size")
@NamedQuery(name = "findByApplicationCompany",query = "select a from ApplicationEntity a where a.company = :company")
@NamedQuery(name = "findByApplicationUsers",query = "select a from ApplicationEntity a where a.noOfUsers = :users")
@NamedQuery(name = "findByApplicationRatings",query = "select a from ApplicationEntity a where a.ratings = :ratings")
@NamedQuery(name = "findByApplicationLaunchDate",query = "select a from ApplicationEntity a where a.launchDate = :date")
@NamedQuery(name = "findAllApplication",query = "select a from ApplicationEntity a")
@NamedQuery(name = "updateUserAndNameByIdAndCompanyName", query = "update ApplicationEntity a set a.company=:company , a.noOfUsers=:noOfUsers where " +
        "a.applicationName=:applicationName and  a.applicationID=:applicationID")
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
