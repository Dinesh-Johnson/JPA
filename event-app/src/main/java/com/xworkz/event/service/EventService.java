package com.xworkz.event.service;

import com.xworkz.event.dto.EventDTO;
import com.xworkz.event.entity.EventEntity;

import java.util.List;

public interface EventService {

    boolean validation(EventDTO dto);

    List<EventDTO> getAllEvents();

    EventDTO fetchDataByID(Integer id);

    String getUpdateByID(EventDTO dto);

    String deleteById(Integer id);

    EventDTO searchByPetName(String name);

}
