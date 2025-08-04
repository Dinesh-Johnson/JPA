package com.xworkz.gadget.service;

import com.xworkz.gadget.entity.GadgetEntity;

import java.time.LocalDate;

public interface GadgetService {

    boolean validateAndSave(GadgetEntity entity);

    void findAndPrintByBrand(String brand);

    void findAndPrintByType(String type);

    void findAndPrintByLaunchDate(LocalDate date);
}