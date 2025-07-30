package com.xworkz.shop.chocolate;

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
@Table(name = "chocolate_ingredients")
public class ChocolateIngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private int id;

    @Column(name = "ingredient_name")
    private String name;

    @Column(name = "ingredient_type")
    private String type;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "unit")
    private String unit;
}
