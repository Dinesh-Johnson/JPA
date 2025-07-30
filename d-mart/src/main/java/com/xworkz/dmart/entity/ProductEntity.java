package com.xworkz.dmart.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "product_info")
@ToString
public class ProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productid;


    @Column(name = "product_name")
    private  String productName;

    @Column(name = "product_price")
    private double price;

    @Column(name = "product_mfd")
    private String mfd;

    @Column(name = "product_company")
    private String company;
}
