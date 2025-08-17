package com.xworkz.pet.controller;

import com.xworkz.pet.dto.PetDTO;
import com.xworkz.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
            return getAllAlbum(model);
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

    @GetMapping("returnToIndex")
    public String  redirectToIndex(){
        System.out.println("Calling Index");
        return "index";
    }

    @GetMapping("view")
    public String getPackageByID(@RequestParam("id") String id, Model model) {
        System.out.println("getPackageByID :"+id);
        PetDTO dto = service.fetchDataByID(Integer.valueOf(id));
        System.out.printf("View Torurism : "+dto);
        model.addAttribute("ref",dto);

        return "view";
    }
    @GetMapping("edit")
    public String viewByID(@RequestParam("id") String id, Model model) {
        System.out.println("ID :" + id);
        PetDTO dto = service.fetchDataByID(Integer.valueOf(id));
        model.addAttribute("ref", dto);
        return "update";
    }

    @PostMapping("update")
    public String updateEdit(PetDTO dto, Model model) {
        System.out.println("updateEdit.....");
        String update = service.getUpdateByID(dto);
        System.out.println("updated" + update);
        List<PetDTO> list = service.getAllAlbum();
        model.addAttribute("listOfDto", list);
        list.forEach(System.out::println);
        return "listOfDto";
    }

    @GetMapping("delete")
    public String viewDeleteByID(@RequestParam("id") Integer id, Model model) {
        System.out.println("ID :" + id);
        String delete = service.deleteById(id);
        System.out.println(delete);
        List<PetDTO> list = service.getAllAlbum();
        model.addAttribute("listOfDto", list);
        list.forEach(System.out::println);
        return "listOfDto";
    }

    @GetMapping("search")
    public  String searchByText(@RequestParam("search")String text, Model model){
        System.out.println("Search Text :"+text);
        PetDTO search = service.searchByPetName(text);
        System.out.println("search :"+search);
        model.addAttribute("ref", search);

        return "view";
    }

}
