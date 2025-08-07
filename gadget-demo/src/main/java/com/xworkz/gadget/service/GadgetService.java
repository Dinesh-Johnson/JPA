package com.xworkz.gadget.service;

import com.xworkz.gadget.entity.GadgetEntity;

import java.time.LocalDate;
import java.util.List;

public interface GadgetService {

    boolean validateAndSave(GadgetEntity entity);

    void findAndPrintByBrand(String brand);

    void findAndPrintByType(String type);

    void findAndPrintByLaunchDate(LocalDate date);

    List<GadgetEntity> findAllGadget();

    void findByPrice(Double price);

    void  findById(Integer gadgetId);

    int updateWarrantyByBrand(String brand, Integer warranty);

    int updatePriceByModelName(String modelName, Double price);

    int updateTypeById(Integer gadgetId, String type);

    List<Object[]> getBrandTypeAndModelName();

}