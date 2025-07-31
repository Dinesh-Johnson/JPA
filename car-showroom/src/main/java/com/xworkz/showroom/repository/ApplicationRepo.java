package com.xworkz.showroom.repository;

import com.xworkz.showroom.entity.ApplicationEntity;

import java.util.Optional;

public interface ApplicationRepo {

    public void saveApplication(ApplicationEntity entity);

Optional<ApplicationEntity> findByID(int id);

    public void deleteById(int id);

    public boolean updateById(int id, String company);
}
