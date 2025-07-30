package com.xworkz.shop.soap;

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
@Table(name = "soaps")
public class SoapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soap_id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "fragrance")
    private String fragrance;

    @Column(name = "weight")
    private double weight;

    @Column(name = "price")
    private double price;
}
