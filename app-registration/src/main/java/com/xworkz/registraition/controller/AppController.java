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
        }else {
            model.addAttribute("message", "Not Submitted");
            model.addAttribute("dto", dto);

        }
        return "register";
    }

    @PostMapping("login")
    public String logIn(@RequestParam String email,@RequestParam String password,Model model){
        System.out.println("Controller Log In.....");
        System.out.println("Email :" + email + "--- Password :" + password);
        UserDTO dto = service.acceptLogin(email, password);
        if (dto == null) {
            model.addAttribute("message", "Invalid email or password");
            return "login";
        }
        model.addAttribute("dto", dto);
        return "view";
    }
}
