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
}