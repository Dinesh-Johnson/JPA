package com.xworkz.pet.dto;

import lombok.Data;

@Data

public class PetDTO {

    private String name;
    private String type;
    private Integer age;
    private String breed;
    private Double adoptionFee;
}