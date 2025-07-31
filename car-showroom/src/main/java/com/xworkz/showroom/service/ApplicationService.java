package com.xworkz.showroom.service;

import com.xworkz.showroom.entity.ApplicationEntity;

import java.util.Optional;

public interface ApplicationService {

   public void validateApplication(ApplicationEntity entity);

   Optional<ApplicationEntity> findByID(int id);

   public void deleteById(int id);

   public void updateById(int id,String company);
}
