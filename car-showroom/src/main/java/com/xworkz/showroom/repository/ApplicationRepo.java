package com.xworkz.showroom.repository;

import com.xworkz.showroom.entity.ApplicationEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ApplicationRepo {

    void saveApplication(ApplicationEntity entity);

Optional<ApplicationEntity> findByID(int id);

    void deleteById(int id);

    boolean updateById(int id, String company);

    ApplicationEntity getApplicationByName(String name);

    ApplicationEntity getApplicationSize(String size);

    ApplicationEntity getApplicationCompany(String company);

    ApplicationEntity getApplicationUser(Integer user);

    ApplicationEntity getApplicationRatings(Float ratings);

    ApplicationEntity getApplicationLaunchDate(LocalDate date);

    List<ApplicationEntity> getAllApplication();

     ApplicationEntity updateApplicationByCompany(Integer id,String companyName,String name, Integer noOfUsers);
}
