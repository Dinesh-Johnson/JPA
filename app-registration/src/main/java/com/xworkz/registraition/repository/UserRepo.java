package com.xworkz.registraition.repository;

import com.xworkz.registraition.entity.UserEntity;

import java.util.List;

public interface UserRepo {

    boolean save(UserEntity entity);

    UserEntity acceptLogin(String email);

    String getByMail(String mail);

    Long getByMobile(Long mobile);

    String getPassword(String mail);

    boolean resetPassword(String mail,String password);

    void lockTimeUpdate(UserEntity entity);

    boolean updateById(String name,Long mobile,String dob,String state,String address,Integer id,String filepath,String district,String pincode);

    boolean updateOTPByEmail(String email,String otp);

    List<String> getAllEmails();

    boolean deleteMethod(String email);


}
