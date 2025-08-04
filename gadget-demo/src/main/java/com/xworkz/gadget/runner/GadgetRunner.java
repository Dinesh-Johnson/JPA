package com.xworkz.gadget.runner;

import com.xworkz.gadget.entity.GadgetEntity;
import com.xworkz.gadget.repository.GadgetRepository;
import com.xworkz.gadget.repository.GadgetRepositoryImpl;
import com.xworkz.gadget.service.GadgetService;
import com.xworkz.gadget.service.*;

import java.time.LocalDate;

public class GadgetRunner {
    public static void main(String[] args) {
        GadgetRepository repo = new GadgetRepositoryImpl();
        GadgetService service = new GadgetServiceImpl(repo);

        GadgetEntity entity = new GadgetEntity();
        entity.setBrand("Apple");
        entity.setType("Smartwatch");
        entity.setModelName("Watch Ultra 2");
        entity.setPrice(89999.0);
        entity.setWarrantyYears(2);
        entity.setLaunchDate(LocalDate.of(2023, 9, 12));

     //   service.validateAndSave(entity);

//        service.findAndPrintByBrand("Apple");
//        service.findAndPrintByType("Smartwatch");
//        service.findAndPrintByLaunchDate(LocalDate.of(2023, 9, 12));
//        service.findAllGadget();
        service.findByPrice(89999.0);
    }
}