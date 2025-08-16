package com.xworkz.passport.repository;

import com.xworkz.passport.entity.PassportEntity;

import java.io.StringReader;
import java.util.List;

public interface PassportRepo {

    boolean save(PassportEntity entity);

    String getByEmail(String mail);

    Long getByMobile(Long mobile);

    String getByLoginId(String loginId);

    List<PassportEntity> getAllData();

    boolean updateById(PassportEntity entity);

    boolean deleteByID(Integer id);

    PassportEntity searchByName(String name);

    PassportEntity fetchByID(Integer id);


}
