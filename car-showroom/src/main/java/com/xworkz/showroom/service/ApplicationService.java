package com.xworkz.showroom.service;

import com.xworkz.showroom.entity.ApplicationEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ApplicationService {

   public void validateApplication(ApplicationEntity entity);

   Optional<ApplicationEntity> findByID(int id);

   public void deleteById(int id);

   public void updateById(int id,String company);

   public ApplicationEntity getApplicationByName(String name);

   public ApplicationEntity getApplicationSize(String size);

   public ApplicationEntity getApplicationCompany(String company);

   public ApplicationEntity getApplicationUser(Integer user);

   public ApplicationEntity getApplicationRatings(Float ratings);

   public ApplicationEntity getApplicationLaunchDate(LocalDate date);

   List<ApplicationEntity> getAllApplication();

   ApplicationEntity updateApplicationByCompany(Integer id,String companyName,String name, Integer noOfUsers);

   List<String> findAllApplicationName();

   List<String> findAllApplicationCompanyName();

   List<Float> findAllApplicationRatings();

   List<Object> findAllApplicationLaunchDate();

   List<Object[]> findAllApplicationNameAndUsers();

}
