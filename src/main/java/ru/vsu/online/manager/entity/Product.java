package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;

/*
    Сущность описывающая продукт
 */

@Entity
@Data
public class Product {

    @Id
    private Long id;

    private ProductType productType; //молочка, мясное и тд

    @Column(unique = true, name = "name")
    private String name;
}
