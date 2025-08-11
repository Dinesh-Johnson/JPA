package com.xworkz.event.service;

import com.xworkz.event.dto.EventDTO;

import java.util.List;

public interface EventService {

    boolean validation(EventDTO dto);

    List<EventDTO> getAllEvents();
}
