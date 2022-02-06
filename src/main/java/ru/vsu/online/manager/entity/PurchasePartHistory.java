package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PurchasePartHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    private Long count;

    @ManyToOne(optional = false)
    @JoinColumn(name = "purchase_history_id")
    private PurchaseHistory purchaseHistory;

}
