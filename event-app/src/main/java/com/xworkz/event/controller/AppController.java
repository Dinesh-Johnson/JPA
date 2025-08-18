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
import org.springframework.web.bind.annotation.RequestParam;

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
            return getAllEvents(model);
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


    @GetMapping("returnToIndex")
    public String  redirectToIndex(){
        System.out.println("Calling Index");
        return "index";
    }
    @GetMapping("view")
    public String getPackageByID(@RequestParam("id") String id, Model model) {
        System.out.println("getPackageByID :"+id);
        EventDTO dto = service.fetchDataByID(Integer.valueOf(id));
        System.out.printf("View Event : "+dto);
        model.addAttribute("ref",dto);

        return "view";
    }

    @GetMapping("edit")
    public String viewByID(@RequestParam("id") String id, Model model) {
        System.out.println("ID :" + id);
        EventDTO dto = service.fetchDataByID(Integer.valueOf(id));
        model.addAttribute("ref", dto);
        return "update";
    }

    @PostMapping("update")
    public String updateEdit(EventDTO dto, Model model) {
        System.out.println("updateEdit.....");
        String update = service.getUpdateByID(dto);
        System.out.println("updated" + update);
        List<EventDTO> list = service.getAllEvents();
        model.addAttribute("listOfDto", list);
        list.forEach(System.out::println);
        return "listOfDto";
    }

    @GetMapping("delete")
    public String viewDeleteByID(@RequestParam("id") Integer id, Model model) {
        System.out.println("ID :" + id);
        String delete = service.deleteById(id);
        System.out.println(delete);
        List<EventDTO> list = service.getAllEvents();
        model.addAttribute("listOfDto", list);
        list.forEach(System.out::println);
        return "listOfDto";
    }

    @GetMapping("search")
    public  String searchByText(@RequestParam("search")String text, Model model){
        System.out.println("Search Text :"+text);
        EventDTO search = service.searchByPetName(text);
        System.out.println("search :"+search);
        model.addAttribute("ref", search);

        return "view";
    }
}
