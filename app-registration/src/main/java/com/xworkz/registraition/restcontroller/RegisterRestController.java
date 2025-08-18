package com.xworkz.registraition.restcontroller;

import com.xworkz.registraition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passport-seva")
public class RegisterRestController {

    @Autowired
    private UserService service;

    public RegisterRestController() {
        System.out.println("REST CONTROLLER");
    }


    @GetMapping(value = "/loginemail")
    public String mailValidation(@RequestParam("email") String email){
        System.out.println("Validation MAil.....");
        String existing = service.getByEmail(email);
        System.out.println(existing);
        if(existing==null){
            return " ";
        }

        return "Email exist! ";
    }

    @GetMapping(value = "/loginmobile")
    public String mobileValidation(@RequestParam("mobile") String mobile) {
        System.out.println("mobileValidation....");
        Object existingObj = service.getByMobile(Long.valueOf(mobile));
        System.out.println(existingObj);

        if (existingObj == null) {
            return " ";
        }
        return "Mobile number already registered!";
    }


}
