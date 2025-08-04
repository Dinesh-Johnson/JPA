package com.xworkz.showroom.runner;

import com.xworkz.showroom.entity.ApplicationEntity;
import com.xworkz.showroom.repository.ApplicationRepo;
import com.xworkz.showroom.repository.ApplicationRepoImpl;
import com.xworkz.showroom.service.ApplicationService;
import com.xworkz.showroom.service.ApplicationServiceImpl;

import java.time.LocalDate;
import java.util.Optional;

public class ApplicationRunner {

    public static void main(String[] args) {

        ApplicationEntity application = new ApplicationEntity();
/*
        application.setApplicationName("Uber");
        application.setApplicationSize("20 MB");
        application.setNoOfUsers(142000);
        application.setRatings(4.4f);
        application.setCompany("UBER");
        application.setLaunchDate(LocalDate.of(2010,5,1));

        ApplicationService service = new ApplicationServiceImpl();

        service.validateApplication(application);

        Optional<ApplicationEntity> optionalApplicationEntity = service.findByID(1);
        optionalApplicationEntity.ifPresent(System.out::println);

        service.deleteById(2);

        service.updateById(8,"Whatsapp Business");
 */

        ApplicationService service = new ApplicationServiceImpl();
//        service.deleteById(2);
//        service.getApplicationByName("WhatsApp");
//
//        service.getApplicationRatings(4.4f);
//
        service.getApplicationCompany("META");
//
//        service.getApplicationUser(142000);
//
//        service.getApplicationLaunchDate(LocalDate.of(2010,5,1));
//
//        service.getApplicationSize("20 MB");

//        service.getAllApplication();


    }
}
