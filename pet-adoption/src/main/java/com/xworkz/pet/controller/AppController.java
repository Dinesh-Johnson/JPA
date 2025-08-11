package com.xworkz.pet.controller;

import com.xworkz.pet.dto.PetDTO;
import com.xworkz.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private PetService service;

    public AppController() {
        System.out.println("App Controller....");
    }


    @GetMapping("redirectToRegister")
    public String  toIndex(){
        System.out.println("Calling Index");
        return "register";
    }

    @PostMapping("register")
    public String albumRegister(PetDTO dto, Model model){
        System.out.println("Calling Album Register page...");
        System.out.println(dto);

        if (service.validation(dto)){
            model.addAttribute("message","submitted");
        }else {
            model.addAttribute("message","Invalid Details");
            model.addAttribute("dto",dto);
        }
        return "register";
    }

    @GetMapping("getAllPets")
    public String getAllAlbum(Model model){

        System.out.println("getAllPets....");
        List<PetDTO> dto =service.getAllAlbum();
        model.addAttribute("listOfDto",dto);
        dto.forEach(System.out::println);
        return "listOfDto";
    }
}
