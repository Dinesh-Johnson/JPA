package com.xworkz.event.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xworkz.event.dto.EventDTO;
import com.xworkz.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private EventService service;

    public AppController() {
        System.out.println("App Controller....");
    }


    @GetMapping("reDirectToEvent")
    public String  toIndex(){
        System.out.println("Calling Index");
        return "register";
    }

    @PostMapping("register")
    public String albumRegister(EventDTO dto, Model model){
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

    @GetMapping("getAllEvents")
    public String getAllEvents(Model model){
        System.out.println("Controller getAllEvents...");
        List<EventDTO> dto = service.getAllEvents();
        model.addAttribute("listOfDto",dto);
        dto.forEach(System.out::println);

        return "listOfDto";
    }
}
