package com.xworkz.pet.service;


import com.xworkz.pet.dto.PetDTO;
import com.xworkz.pet.entity.PetEntity;
import com.xworkz.pet.repo.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepo repo;

    @Override
    public boolean validation(PetDTO dto) {

        if (dto!=null){
            System.out.println("Dto is Not Null");
        }else {
            System.out.println("Dto is Null");
            return false;
        }
        if (dto.getName()!=null){
            System.out.println("Name is not null");
        }else {
            System.out.println("Name is Null");
            return false;
        }
        if (dto.getAdoptionFee()>0){
            System.out.println("Price is Good..");
        }else {
            System.out.println("Price is Bad..");
            return false;
        }
        if (dto.getType()!=null){
            System.out.println("Type is not Null");
        }else {
            System.out.println("Type is NUll");
            return false;
        }

        if (dto.getBreed()!=null){
            System.out.println("Breed is not Null");
        }else {
            System.out.println("Breed is null");
            return false;
        }


        PetEntity entity= new PetEntity();
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setAdoptionFee(dto.getAdoptionFee());
        entity.setAge(dto.getAge());
        entity.setBreed(dto.getBreed());

        return repo.save(entity);
    }

    @Override
    public List<PetDTO> getAllAlbum() {
        List<PetEntity> entities = repo.getAllPets();
        List<PetDTO> dtos = entities.stream().map(e->{
            PetDTO dto = new PetDTO();
            dto.setType(e.getType());
            dto.setName(e.getName());
            dto.setBreed(e.getBreed());
            dto.setAge(e.getAge());
            dto.setAdoptionFee(e.getAdoptionFee());

            return dto;
        }).collect(Collectors.toList());

        return dtos;
    }
}
