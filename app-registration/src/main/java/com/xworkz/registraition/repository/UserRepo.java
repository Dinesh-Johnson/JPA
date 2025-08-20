package com.xworkz.registraition.repository;

import com.xworkz.registraition.entity.UserEntity;

public interface UserRepo {

    boolean save(UserEntity entity);

    UserEntity acceptLogin(String email);

    String getByMail(String mail);

    Long getByMobile(Long mobile);

    String getPassword(String mail);

    boolean resetPassword(String mail,String password);
}
