package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;

/*
    Сущность описывающая информацию о продуте в базе
 */
@Entity
@Data
@Table(name = "base_product_info", schema = "online_manager")
public class BaseProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product; //продукт, о котором мы храним информацию

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "base_id")
    private Base base; // база - на которой продукт хранится

    private Double price; // цена

    private Long count; //кол-во
}
