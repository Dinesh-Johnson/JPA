package com.xworkz.registraition.restcontroller;

import com.xworkz.registraition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RegisterRestController {

    @Autowired
    private UserService service;

    public RegisterRestController() {
        System.out.println("REST CONTROLLER");
    }

    @GetMapping("/loginemail")
    public String mailValidation(@RequestParam("regEmail") String email) {
        System.out.println("Validation Mail.....");
        String existing = service.getByEmail(email);
        System.out.println(existing);

        if (existing == null) {
            return "";  // send empty if not exists
        }
        return "Email already registered!";
    }

    @GetMapping("/loginmobile")
    public String mobileValidation(@RequestParam("regPhone") String mobile) {
        System.out.println("Mobile Validation....");
        Long existingObj = service.getByMobile(Long.valueOf(mobile));
        System.out.println(existingObj);
        if (existingObj == null) {
            return "";
        }
        return "Mobile number already registered!";
    }
}

