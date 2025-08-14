package com.xworkz.album.controller;

import com.xworkz.album.dto.AlbumDTO;
import com.xworkz.album.service.AlbumService;
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
            return getAllAlbum(model);
        }else {
            model.addAttribute("message","Invalid Details");
            model.addAttribute("dto",dto);
        }
        return "register";
    }
    @GetMapping("getAllAlbum")
    public String getAllAlbum(Model model){

        System.out.println("getAllAlbum....");
        List<AlbumDTO> dto =service.getAllAlbum();
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
        AlbumDTO dto = service.fetchDataByID(Integer.valueOf(id));
        System.out.printf("View Torurism : "+dto);
        model.addAttribute("ref",dto);

        return "view";
    }

}
