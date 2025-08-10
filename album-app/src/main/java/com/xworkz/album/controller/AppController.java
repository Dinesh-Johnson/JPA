package com.xworkz.album.controller;

import com.xworkz.album.dto.AlbumDTO;
import com.xworkz.album.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private AlbumService service;

    public AppController() {
        System.out.println("App Controller....");
    }


    @GetMapping("redirectToRegister")
    public String  toIndex(){
        System.out.println("Calling Index");
        return "register";
    }

    @PostMapping("register")
    public String albumRegister(AlbumDTO dto, Model model){
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
}
