package com.xworkz.registraition.repository;

import com.xworkz.registraition.entity.UserEntity;

public interface UserRepo {

    boolean save(UserEntity entity);

    UserEntity acceptLogin(String email);

    String getByMail(String mail);

    Long getByMobile(Long mobile);
}
