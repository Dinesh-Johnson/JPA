package com.xworkz.pet.service;


import com.xworkz.pet.dto.PetDTO;

import java.util.List;

public interface PetService {

    boolean validation(PetDTO dto);

    List<PetDTO> getAllAlbum();

    PetDTO fetchDataByID(Integer id);

}
