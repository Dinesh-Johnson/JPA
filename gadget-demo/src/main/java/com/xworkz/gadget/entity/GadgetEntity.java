package com.xworkz.gadget.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gadget_info")
@NamedQuery(name = "findByBrand", query = "select g from GadgetEntity g where g.brand = :brand")
@NamedQuery(name = "findByGadgetType", query = "select g from GadgetEntity g where g.type = :type")
@NamedQuery(name = "findByLaunchDate", query = "select g from GadgetEntity g where g.launchDate = :launchDate")
@NamedQuery(name = "findAllApplications", query = "select a from GadgetEntity a")
@NamedQuery(name = "findByPrice", query = "select a from GadgetEntity a where a.price = :price")
public class GadgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gadget_id")
    private Integer gadgetId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "type")
    private String type;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "price")
    private Double price;

    @Column(name = "warranty_years")
    private Integer warrantyYears;

    @Column(name = "launch_date")
    private LocalDate launchDate;


}
