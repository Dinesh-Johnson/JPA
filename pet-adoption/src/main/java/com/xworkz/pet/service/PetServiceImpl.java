package com.xworkz.pet.service;


import com.xworkz.pet.dto.PetDTO;
import com.xworkz.pet.entity.PetEntity;
import com.xworkz.pet.repo.PetRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
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
            dto.setId(e.getId());
            dto.setType(e.getType());
            dto.setName(e.getName());
            dto.setBreed(e.getBreed());
            dto.setAge(e.getAge());
            dto.setAdoptionFee(e.getAdoptionFee());

            return dto;
        }).collect(Collectors.toList());

        return dtos;
    }

    @Override
    public PetDTO fetchDataByID(Integer id) {
        PetEntity e = repo.fetchDataByID(id);
        PetDTO dto = new PetDTO();
        dto.setId(e.getId());
        dto.setType(e.getType());
        dto.setName(e.getName());
        dto.setBreed(e.getBreed());
        dto.setAge(e.getAge());
        dto.setAdoptionFee(e.getAdoptionFee());
        return dto;
    }

    @Override
    public String getUpdateByID(PetDTO dto) {
        PetEntity entity = new PetEntity();
        BeanUtils.copyProperties(dto, entity);
        boolean updated = repo.updateById(entity);
        if (updated) {
            return "UPDATED";
        }
        return "NOT UPDATED";
    }

    @Override
    public String deleteById(Integer id) {
        PetEntity entity = new PetEntity();
        boolean deleted = repo.deleteByID(id);
        if (deleted) {
            return "DELETED";
        }
        return "NOT DELETED";
    }

    @Override
    public PetDTO searchByPetName(String name) {
        PetEntity entity = repo.getByName(name);
        PetDTO dto = new PetDTO();
        System.out.println("SERVICE searchByPetName  e..."+entity);
        BeanUtils.copyProperties(entity,dto);

        return dto;
    }
}
