package com.xworkz.shop.ecom;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "clothes")
public class ClothesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "cloth_id")
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "size")
    private String size;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private double price;
}
