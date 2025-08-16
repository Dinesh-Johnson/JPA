package com.xworkz.passport.service;

import com.xworkz.passport.dto.PassportDTO;
import com.xworkz.passport.entity.PassportEntity;
import com.xworkz.passport.repository.PassportRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassportServiceImpl implements PassportService{

    @Autowired
    private PassportRepo repo;


    @Override
    public boolean validate(PassportDTO dto) {

        PassportEntity entity = new PassportEntity();
        BeanUtils.copyProperties(dto,entity);

        return repo.save(entity);
    }

    @Override
    public String getByEmail(String mail) {
        System.out.println("GET MAIL SERVICE");
        return repo.getByEmail(mail);
    }

    @Override
    public Long getByMobile(Long mobile) {
        System.out.println("GET Mobile SERVICE");
        return repo.getByMobile(mobile);
    }

    @Override
    public String getByLoginId(String loginId) {
        return repo.getByLoginId(loginId);
    }

    @Override
    public List<PassportDTO> getAllData() {
        System.out.println("SERVICE getAllPackages....");
        List<PassportDTO> dtos = null;
        List<PassportEntity> entities = repo.getAllData();
        dtos = entities.stream().map(entity -> {
            PassportDTO dto = new PassportDTO();
            BeanUtils.copyProperties(entity,dto);
            return dto;
        }).collect(Collectors.toList());

        return dtos;
    }

    @Override
    public String updateData(PassportDTO dto) {
        PassportEntity entity = new PassportEntity();
        BeanUtils.copyProperties(dto,entity);
        boolean updated = repo.updateById(entity);

        if (updated){
            return "UPDATED";
        }
        return "NOT UPDATED";
    }

    @Override
    public String deleteByID(Integer id) {
        PassportEntity entity = new PassportEntity();
        boolean isDeleted = repo.deleteByID(id);
        if (isDeleted){
            return "DELETED";
        }
        return "NOT DELETED";
    }

    @Override
    public PassportDTO searchByName(String name) {
        PassportEntity entity = repo.searchByName(name);
        PassportDTO dto = new PassportDTO();
        System.out.println("SERVICE searchByPackageNam  e..."+entity);
        BeanUtils.copyProperties(entity,dto);

        return dto;
    }

    @Override
    public PassportDTO fetchByID(Integer id) {
        PassportEntity entity = repo.fetchByID(id);
        PassportDTO dto = new PassportDTO();
        System.out.println("SERVICE fetch by ID:"+entity);
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

}
