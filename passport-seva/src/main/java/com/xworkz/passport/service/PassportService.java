package com.xworkz.passport.service;

import com.xworkz.passport.dto.PassportDTO;

import java.util.List;

public interface PassportService {

    boolean validate(PassportDTO dto);

    String getByEmail(String mail);

    Long getByMobile(Long mobile);

    String getByLoginId(String loginId);

    List<PassportDTO> getAllData();

    String updateData(PassportDTO dto);

    String deleteByID(Integer id);

    PassportDTO searchByName(String name);

    PassportDTO fetchByID(Integer id);


}
