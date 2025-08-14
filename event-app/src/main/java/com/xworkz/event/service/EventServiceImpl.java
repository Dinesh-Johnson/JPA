package com.xworkz.event.service;

import com.xworkz.event.dto.EventDTO;
import com.xworkz.event.entity.EventEntity;
import com.xworkz.event.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo repo;

    @Override
    public boolean validation(EventDTO dto) {

        if (dto!=null){
            System.out.println("Dto is Not Null");
        }else {
            System.out.println("Dto is Null");
            return false;
        }
        if (dto.getName()!=null){
            System.out.println("Artist is not null");
        }else {
            System.out.println("Artist is Null");
            return false;
        }
        if (dto.getTicketPrice()>0){
            System.out.println("Price is Good..");
        }else {
            System.out.println("Price is Bad..");
            return false;
        }
        if (dto.getLocation()!=null){
            System.out.println("Genre is not Null");
        }else {
            System.out.println("Genre is NUll");
            return false;
        }
        if (dto.getOrganizer()!=null){
            System.out.println("Date is Valid.");
        }else {
            System.out.println("Date is Invalid...");
            return false;
        }
        if (dto.getDate()!=null){
            System.out.println("Rating is not Null");
        }else {
            System.out.println("Rating is null");
            return false;
        }

        EventEntity entity= new EventEntity();
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        entity.setDate(dto.getDate());
        entity.setOrganizer(dto.getOrganizer());
        entity.setTicketPrice(dto.getTicketPrice());
        return repo.save(entity);
    }

    @Override
    public List<EventDTO> getAllEvents() {
        List<EventEntity> entities = repo.getAllEvents();
        List<EventDTO> dtos = entities.stream().map(e->{
            EventDTO dto =new EventDTO();
            dto.setId(e.getId());
            dto.setDate(e.getDate());
            dto.setLocation(e.getLocation());
            dto.setName(e.getName());
            dto.setOrganizer(e.getOrganizer());
            dto.setTicketPrice(e.getTicketPrice());

            return dto;
        }).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public EventDTO fetchDataByID(Integer id) {
        EventEntity entity =repo.fetchDataByID(id);
        EventDTO dto = new EventDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setLocation(entity.getLocation());
        dto.setName(entity.getName());
        dto.setOrganizer(entity.getOrganizer());
        dto.setTicketPrice(entity.getTicketPrice());
        return dto;
    }
}
