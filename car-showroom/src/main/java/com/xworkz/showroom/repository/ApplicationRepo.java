package com.xworkz.showroom.repository;

import com.xworkz.showroom.entity.ApplicationEntity;

import java.time.LocalDate;
import java.util.Optional;

public interface ApplicationRepo {

    public void saveApplication(ApplicationEntity entity);

Optional<ApplicationEntity> findByID(int id);

    public void deleteById(int id);

    public boolean updateById(int id, String company);

    public ApplicationEntity getApplicationByName(String name);

    public ApplicationEntity getApplicationSize(String size);

    public ApplicationEntity getApplicationCompany(String company);

    public ApplicationEntity getApplicationUser(Integer user);

    public ApplicationEntity getApplicationRatings(Float ratings);

    public ApplicationEntity getApplicationLaunchDate(LocalDate date);
}
