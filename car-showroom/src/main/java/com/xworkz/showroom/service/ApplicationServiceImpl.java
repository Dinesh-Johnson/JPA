package com.xworkz.showroom.service;

import com.xworkz.showroom.entity.ApplicationEntity;
import com.xworkz.showroom.repository.ApplicationRepo;
import com.xworkz.showroom.repository.ApplicationRepoImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ApplicationServiceImpl implements ApplicationService{


    ApplicationRepo applicationRepo = new ApplicationRepoImpl();


    public boolean validateApplicationDetails(ApplicationEntity entity) {

        if (entity!=null){
            System.out.println("Enity Not null");

        }else {
            System.out.println("Entity is Null");
        }

        if (entity.getApplicationName()!=null){
            System.out.println("Name is Not Null");
        }else {
            System.out.println("Name is NUll");
        }

        if (entity.getApplicationSize()!=null){
            System.out.println("Size is not Null");
        }else {
            System.out.println("Size is Null");
        }

        if (entity.getCompany()!=null){
            System.out.println("Company is Not Null");
        }else {
            System.out.println("Company is Null");
        }


        if (entity.getNoOfUsers()!=null){
            System.out.println("Users is Not Null");
        }else {
            System.out.println("Users is NULL");
        }

        if (entity.getRatings()!=null){
            System.out.println("ratings is not " +
                    "null");
        }else {
            System.out.println("ratings is null");
        }

        if (entity.getLaunchDate()!=null){
            System.out.println("Date is Not Null");
        }else {
            System.out.println("Date is Null");
        }


        return false;
    }

    @Override
    public void validateApplication(ApplicationEntity entity) {
        validateApplicationDetails(entity);

        applicationRepo.saveApplication(entity);
    }

    @Override
    public Optional<ApplicationEntity> findByID(int id) {

        if (id>0){
            Optional<ApplicationEntity> entityOptional = applicationRepo.findByID(id);

            if (entityOptional.isPresent()){

                ApplicationEntity application = entityOptional.get();

                if (validateApplicationDetails(application)){

                    return Optional.of(application);
                }else {
                    System.err.println("Error Check the Details");
                }
            }else {
                System.out.println("Application is Not Present");
            }

        }else {
            System.out.println("Invalid ID");
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(int id) {
        if(id>0)
        {
            System.out.println("ID is Valid");
            applicationRepo.deleteById(id);

        }else {
            System.out.println("ID is Invalid");
        }
    }

    @Override
    public void updateById(int id, String company) {

        if(id>0)
        {
            System.out.println("ID is Valid");
        }
        else {
            System.out.println("ID is Invalid");
        }
        if(company==null)
        {
            System.out.println("Company is Invalid");
        }
        else {
            System.out.println("company is valid");
            if(applicationRepo.updateById(id,company))
            {
                System.out.println("UPDATED");
            }else {
                System.out.println("updated FAILED");
            }
        }

    }

    @Override
    public ApplicationEntity getApplicationByName(String name) {

        if (name!=null){
            System.out.println("Name is Not Null");
            applicationRepo.getApplicationByName(name);
        }

        return null;
    }

    @Override
    public ApplicationEntity getApplicationSize(String size) {

        if (size!=null){
            System.out.println("Size Not Null");
            applicationRepo.getApplicationSize(size);
        }
        return null;
    }

    @Override
    public ApplicationEntity getApplicationCompany(String company) {
        if (company!=null){
            System.out.println("Company not Null");
            applicationRepo.getApplicationCompany(company);
        }
        return null;
    }

    @Override
    public ApplicationEntity getApplicationUser(Integer user) {

        if (user>0){
            System.out.println("User is Not Equal to Zero");
            applicationRepo.getApplicationUser(user);
        }
        return null;
    }

    @Override
    public ApplicationEntity getApplicationRatings(Float ratings) {
        if (ratings>0){
            System.out.println("ratings Is Not zero and it is greater than zero");
            applicationRepo.getApplicationRatings(ratings);
        }
        return null;
    }

    @Override
    public ApplicationEntity getApplicationLaunchDate(LocalDate date) {

        if (date!=null){
            System.out.println("Date is Not null");
            applicationRepo.getApplicationLaunchDate(date);
        }
        return null;
    }

    @Override
    public List<ApplicationEntity> getAllApplication() {


        return applicationRepo.getAllApplication();
    }

    @Override
    public ApplicationEntity updateApplicationByCompany(Integer id, String companyName, String name, Integer noOfUsers) {

        return applicationRepo.updateApplicationByCompany(id, companyName, name, noOfUsers);
    }


}
