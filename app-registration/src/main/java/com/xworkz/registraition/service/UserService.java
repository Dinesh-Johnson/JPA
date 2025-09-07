package com.xworkz.registraition.service;

import com.xworkz.registraition.dto.UserDTO;

import java.util.List;

public interface UserService {

    boolean save(UserDTO dto);

    UserDTO acceptLogin(String email,String password);

    String getByEmail(String mail);

    Long getByMobile(Long mobile);

    boolean acceptLoginByOtp(String email,String userOtp);

    boolean resetPassword(String email,String password,String confirmPassword);

    UserDTO viewByEmail(String email);

    boolean updateById(String name,Long mobile,String dob,String state,String address,Integer id,String filepath,String district,String pincode);

    boolean setOTPByEmail(String email);

    UserDTO editProfile(String mail);

    List<String> getAllEmails();

}
