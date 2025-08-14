package com.xworkz.pet.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pet_details")
@Data
@NamedQuery(name = "getAllPets",query = "select a from PetEntity a")
@NamedQuery(name = "fetchDataByID",query = "select a from PetEntity a where a.id =:id")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pet_name")
    private String name;

    @Column(name = "pet_type")
    private String type;

    @Column(name = "pet_age")
    private Integer age;

    @Column(name = "pet_breed")
    private String breed;

    @Column(name = "adoption_fee")
    private Double adoptionFee;
}
