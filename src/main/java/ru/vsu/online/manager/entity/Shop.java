package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/*
    Сущность описывающая магазин
 */
@Entity
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "name")
    private String name;

    @OneToMany(mappedBy = "shop")
    private List<Department> departments;
}
