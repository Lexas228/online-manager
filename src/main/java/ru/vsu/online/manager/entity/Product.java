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

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType; //колбаса, курица и тд

    @Column(unique = true, name = "name", nullable = false)
    private String name; //останкино, дубравка (что то такое)
}
