package com.xworkz.pet.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pet_details")
@Data
@NamedQuery(name = "getAllPets",query = "select a from PetEntity a")
@NamedQuery(name = "fetchDataByID",query = "select a from PetEntity a where a.id =:id")
@NamedQuery(name = "deleteById",query = "delete PetEntity a where a.id=:id")
@NamedQuery(name = "getByPetName",query = "select a from PetEntity a where a.name=:name")
@NamedQuery(name = "getUpdateByID", query = "update PetEntity a set a.name=:name, a.type=:type," +
        "a.age=:age, a.breed=:breed,a.adoptionFee=:adoptionFee where a.id=:id")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
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
