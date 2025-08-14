package com.xworkz.pet.repo;

import com.xworkz.pet.entity.PetEntity;

import java.util.List;

public interface PetRepo {

    boolean save(PetEntity entity);

    List<PetEntity> getAllPets();

    PetEntity fetchDataByID(Integer id);

}
