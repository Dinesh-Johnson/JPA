package com.xworkz.gadget.service;

import com.xworkz.gadget.entity.GadgetEntity;
import com.xworkz.gadget.repository.GadgetRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class GadgetServiceImpl implements GadgetService {

    private GadgetRepository repository;

    public GadgetServiceImpl(GadgetRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean validateAndSave(GadgetEntity entity) {
        if (entity != null && entity.getBrand() != null && entity.getPrice() != null && entity.getPrice() > 0) {
            repository.save(entity);
            return true;
        }
        System.out.println("Validation failed.");
        return false;

    }

    @Override
    public void findAndPrintByBrand(String brand) {
        repository.findByBrand(brand).ifPresent(System.out::println);
    }

    @Override
    public void findAndPrintByType(String type) {
        repository.findByGadgetType(type).ifPresent(System.out::println);
    }

    @Override
    public void findAndPrintByLaunchDate(LocalDate date) {
        repository.findByLaunchDate(date).ifPresent(System.out::println);
    }

    @Override
    public List<GadgetEntity> findAllGadget() {

        return repository.findAllGadget();
    }

    @Override
    public void findByPrice(Double price) {
        repository.findByPrice(price);
    }
}