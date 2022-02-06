package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;

/*
    Сущность описывающая информацию о продуте в базе
 */
@Entity
@Data
public class BaseProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "base_id")
    private Base base;

    private Double price;

    private Long count;
}
