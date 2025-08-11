package com.xworkz.gadget.repository;

import com.xworkz.gadget.entity.GadgetEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GadgetRepository {

    boolean save(GadgetEntity entity);

    Optional<GadgetEntity> findByBrand(String brand);

    Optional<GadgetEntity> findByGadgetType(String type);

    Optional<GadgetEntity> findByLaunchDate(LocalDate date);

    List<GadgetEntity> findAllGadget();

    Optional<GadgetEntity> findByPrice(Double price);

    Optional<GadgetEntity> findById(Integer gadgetId);

    int updateWarrantyByBrand(String brand, Integer warranty);

    int updatePriceByModelName(String modelName, Double price);

    int updateTypeById(Integer gadgetId, String type);

    List<Object[]> getBrandTypeAndModelName();

}