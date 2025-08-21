package com.xworkz.registraition.controller;


import com.xworkz.registraition.dto.UserDTO;
import com.xworkz.registraition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private UserService service;

    public AppController() {
        System.out.println("Controller Method......");
    }

    @GetMapping("register")
    public String onIndexRegister(){
        System.out.println("Opening Register Page..");
        return "register";
    }

    @GetMapping("login")
    public String onIndexLogin(){
        System.out.println("Opening Log In Page..");
        return "login";
    }


    @PostMapping("register")
    public String save(@Valid UserDTO dto, BindingResult result, Model model){

        System.out.println(dto);
        System.out.println("registeringg.......");

        if (result.hasErrors()){
            result.getFieldErrors().stream().map(fieldError -> fieldError.getField()+"--"+fieldError.getDefaultMessage())
                    .forEach(System.out::println);
            model.addAttribute("message","INVALID DETAILS");
            model.addAttribute("dto",dto);
            return "register";
        }
        if (service.save(dto)){
            model.addAttribute("message","SUBMITTED");
            return "loginwithOtp";
        }else {
            model.addAttribute("message", "Not Submitted");
            model.addAttribute("dto", dto);
            return "register";
        }
    }

    @PostMapping("/loginwithOTP")
    public String logInWithOTP(@RequestParam String email,@RequestParam String otp,Model model) {
        System.out.println("Email: " + email + " -- OTP: " + otp);
        if (service.acceptLoginByOtp(email, otp)) {
            model.addAttribute("email", email);
            return "resetpassword";
        }
        model.addAttribute("message", "OTP Not Matched");
        model.addAttribute("email", email);
        return "login";
    }

    @PostMapping("setPassword")
    public String restPassword(@RequestParam("email")String email,@RequestParam("password")String password,@RequestParam("confirmPassword")String confirmPassword,Model model){
        System.out.println("Rest Password");
        System.out.println("Email :" + email + "--- Password :" + password);
        if (service.resetPassword(email, password, confirmPassword)) {
            model.addAttribute("message", "Password Set Successfully. Please login.");
            return "login";
        } else {
            model.addAttribute("message", "Password Mismatch");
            model.addAttribute("email", email);
            return "resetpassword";
        }
    }
    @PostMapping("login")
    public String logIn(@RequestParam String email,@RequestParam String password,Model model){
        System.out.println("Controller Log In.....");
        System.out.println("Email :" + email + "--- Password :" + password);
        UserDTO dto =null;
        try{
            dto = service.acceptLogin(email, password);
        }catch (RuntimeException e){
            model.addAttribute("message",e.getMessage());
            model.addAttribute("email",email);
            return "login";
        }
        if (dto == null) {
            model.addAttribute("message", "Invalid email or password");
            return "login";
        }
        if (dto.getLoginCount()==-1){
            model.addAttribute("email",email);
            return "resetpassword";
        }
        model.addAttribute("dto", dto);
        return "view";
    }
}
