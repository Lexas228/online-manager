package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "purchase_part_history", schema = "online_manager")
public class PurchasePartHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "count")
    private Long count;

    @ManyToOne(optional = false)
    @JoinColumn(name = "purchase_history_id", nullable = false)
    private PurchaseHistory purchaseHistory;

}
