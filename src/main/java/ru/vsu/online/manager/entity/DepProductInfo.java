package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;

/*
    Сущность описывающая информацию о продуте в отделе
 */
@Entity
@Data
@Table(name = "department_product_info", schema = "online_manager")
public class DepProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    private Double percent;//процент того, на сколько продукт будет дороже цены в базе

    private Long actualCount; //сколько товара в отделе

    private Long requiredCount; //требуемое число товара в отделе

    private boolean isAutoBuying; //метка, о том, что этот товар автозакупается

    @ManyToOne
    @JoinColumn(name = "chosen_base_product_info_id")
    private BaseProductInfo chosenBaseProductInfo; //так сказать, та база, с которой мы будем заказывать конкретно этот товар
}
