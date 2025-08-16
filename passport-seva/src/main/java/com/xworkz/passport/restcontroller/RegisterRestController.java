package com.xworkz.passport.restcontroller;


import com.xworkz.passport.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RegisterRestController {

    @Autowired
    private PassportService service;

    @GetMapping(value = "/loginemail")
    public String mailValidation(@RequestParam("email") String mail){
        System.out.println("mailValidation....");
        String existing = service.getByEmail(mail);
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

    @GetMapping(value = "/loginid")
    public String loginIdValidation(@RequestParam("loginId") String loginId) {
        System.out.println("loginIdValidation....");
        String existing = service.getByLoginId(loginId); // service method you’ll add
        System.out.println(existing);
        if (existing == null) {
            return " ";
        }
        return "Login ID already taken!";
    }
}
