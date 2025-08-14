package com.xworkz.event.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "event_details")
@Data
@NamedQuery(name = "getAllEvents",query = "select a from EventEntity a")
@NamedQuery(name = "fetchDataByID",query = "select a from EventEntity a where a.id =:id")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "event_location")
    private String location;

    @Column(name = "event_date")
    private String date;

    @Column(name = "event_organizer")
    private String organizer;

    @Column(name = "ticket_price")
    private Double ticketPrice;
}
