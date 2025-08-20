package com.xworkz.registraition.service;

import com.xworkz.registraition.dto.UserDTO;

public interface UserService {

    boolean save(UserDTO dto);

    UserDTO acceptLogin(String email,String password);

    String getByEmail(String mail);

    Long getByMobile(Long mobile);

    boolean acceptLoginByOtp(String email,String userOtp);

    boolean resetPassword(String email,String password,String confirmPassword);
}
