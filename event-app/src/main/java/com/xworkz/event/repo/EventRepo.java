package com.xworkz.event.repo;

import com.xworkz.event.entity.EventEntity;

import java.util.List;

public interface EventRepo {

    boolean save(EventEntity entity);

    List<EventEntity> getAllEvents();

    EventEntity fetchDataByID(Integer id);
}
