package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;

/*
    Тип продукта
 */
@Entity
@Data
@Table(name = "product_type", schema = "online_manager")
public class ProductType {
    @Id
    private Long id;

    @Column(nullable = false, unique = true, name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_type_id", nullable = false)
    private DepartmentType departmentType;
}
