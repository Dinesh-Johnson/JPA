package com.xworkz.registraition.controller;


import com.xworkz.registraition.dto.UserDTO;
import com.xworkz.registraition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.security.mscapi.CPublicKey;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
    @GetMapping("find")
    public String onIndexView(Model model){
        System.out.println("Opening View Page..");
        List<String> emails = service.getAllEmails();
        model.addAttribute("emails", emails);
        return "find";
    }

    @GetMapping("login")
    public String onIndexLogin(Model model){
        System.out.println("Opening Log In Page..");
        List<String> emails = service.getAllEmails();
        model.addAttribute("emails", emails);
        return "login";
    }
    @GetMapping("viewProfile")
    public String onView(@RequestParam("email")String email,Model model){
        System.out.println("Opening View In Page..");
        UserDTO dto = service.viewByEmail(email);
        model.addAttribute("dto",dto);
        return "view";
    }


    @PostMapping("register")
    public String save(@Valid UserDTO dto, BindingResult result, Model model) throws IOException {

        System.out.println(dto);
        System.out.println("registeringg.......");

        if (result.hasErrors()){
            result.getFieldErrors().stream().map(fieldError -> fieldError.getField()+"--"+fieldError.getDefaultMessage())
                    .forEach(System.out::println);
            model.addAttribute("message","INVALID DETAILS");
            model.addAttribute("dto",dto);
            return "register";


        }
        try {

            // Get the file and save it somewhere
            byte[] bytes = dto.getMultipartfile().getBytes();
            Path path = Paths.get("D:\\File Folder\\"+dto.getName()+System.currentTimeMillis() + dto.getMultipartfile().getOriginalFilename());
            Files.write(path, bytes);
            String filename=path.getFileName().toString();
            dto.setFilePath(filename);
            System.out.println(filename);

        } catch (IOException e) {
            e.printStackTrace();
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
        return "loginSuccess";
    }

    @PostMapping("/resend-otp")
    @ResponseBody
    public String resendOTP(@RequestParam("email")String email)
    {
        System.out.println("resend otp in controller");
        if(service.setOTPByEmail(email))
        {
            return "Otp sent";
        }
        return "Otp not sent";
    }

    @GetMapping("editProfile")
    public String editProfile(@RequestParam("email")String email,Model model){
        System.out.println("COntroller Edit PRofile");
        UserDTO dto = service.editProfile(email);
        model.addAttribute("dto",dto);
        return "edit";
    }
    @PostMapping("edit")
    public String update(@RequestParam("name") String name,
                         @RequestParam("mobile")Long mobile,
                         @RequestParam("dob") String dob, @RequestParam("state") String state,
                         @RequestParam("address") String address, @RequestParam("id") Integer id,
                         @RequestParam("email")String email,@RequestParam("filepath")String filepath, Model model){

        System.out.println("Update Page....");
        boolean update = service.updateById(name,mobile,dob,state,address,id,filepath);

        if (!update) {
            model.addAttribute("dto.name", name);
            model.addAttribute("dto.mobile", mobile);
            model.addAttribute("dto.dob", dob);
            model.addAttribute("dto.state", state);
            model.addAttribute("dto.address", address);
            model.addAttribute("dto.id", id);
            return "edit";
        }else {
            UserDTO dto = service.viewByEmail(email);
            System.out.println("Controller "+dto);
            model.addAttribute("dto",dto);
            model.addAttribute("message", "UPDATED SUCCESSFULLY");
            return "loginSuccess";
        }

    }

    @GetMapping("/getUserByEmail")
    @ResponseBody
    public UserDTO getUserByEmail(@RequestParam("email") String email) {
        System.out.println("Fetching user for: " + email);
        return service.viewByEmail(email); // returns dto for that email
    }
}
