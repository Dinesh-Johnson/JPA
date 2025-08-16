package com.xworkz.passport.controller;


import com.xworkz.passport.dto.PassportDTO;
import com.xworkz.passport.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.xml.soap.SAAJResult;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private PassportService service;

    public AppController() {

        System.out.println("App Controller...");
    }

    @GetMapping("returnToRegister")
    public String onIndex(){
        System.out.println("Opening Index Page..");
        return "passport";
    }

    @PostMapping("register")
    public String getRegister(@Valid PassportDTO dto, BindingResult result, Model model){
        System.out.println(dto);
        System.out.println("Opening Passport Page");
        if (result.hasErrors()){
            result.getFieldErrors().stream().map(fieldError ->fieldError.getField()+"--"+fieldError.getDefaultMessage())
                    .forEach(System.out::println);
            model.addAttribute("message","Ivalid Deatils");
            model.addAttribute("dto",dto);
            return "passport";
        }
        if (service.validate(dto)){
            model.addAttribute("message", "Submitted");
        } else {
            model.addAttribute("message", "Not Submitted");
            model.addAttribute("dto", dto);

        }

        return getAll(model);
    }

    @GetMapping("getAllDatas")
    public String getAll(Model model){
        System.out.println("Get ALl Controller MEthod...");
        List<PassportDTO> dtos = service.getAllData();
        model.addAttribute("list",dtos);
        dtos.forEach(System.out::println);
        return "listPage";
    }

    @GetMapping("returnToIndex")
    public String reDirectToIndex(){
        System.out.println("Index....");
        return "index";
    }

    @GetMapping("delete")
    public String deleteByID(@RequestParam("id")Integer id,Model model){
        System.out.println("Controller Get By ID .....");
        String delete = service.deleteByID(id);
        System.out.println("delete :"+delete);
        List<PassportDTO> dtos = service.getAllData();
        model.addAttribute("list",dtos);
        dtos.forEach(System.out::println);
        return "listPage";
    }

    @GetMapping("update")
    public  String updateData(PassportDTO dto,Model model){
        System.out.println("Controller Update by ID..");
        String update = service.updateData(dto);
        System.out.println("delete :"+update);
        List<PassportDTO> dtos = service.getAllData();
        model.addAttribute("list",dtos);
        model.addAttribute("message","UPDATED");
        dtos.forEach(System.out::println);
        return "listPage";
    }

    @GetMapping("search")
    public String searchByName(@RequestParam("search")String name,Model model){
        System.out.println("Controller Search By Name.....");
        PassportDTO dto = service.searchByName(name);
        System.out.println(dto);
        model.addAttribute("ref",dto);

        return "view";
    }

    @GetMapping("view")
    public String fetchByID(@RequestParam("id")String id, Model model){
        System.out.println("Controller Get By ID .....");
        PassportDTO fetch = service.fetchByID(Integer.valueOf(id));
        model.addAttribute("ref",fetch);
        return "view";
    }

    @GetMapping("edit")
    public String viewByID(@RequestParam("id") String id, Model model) {
        System.out.println("ID :" + id);
        PassportDTO dto = service.fetchByID(Integer.valueOf(id));
        model.addAttribute("ref", dto);
        return "update";
    }

}
