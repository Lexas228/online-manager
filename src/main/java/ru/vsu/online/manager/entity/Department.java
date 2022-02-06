package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


/*
    Сущность описывающая отдел в магазине
 */
@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DepartmentType departmentType;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToMany(mappedBy = "department")
    private List<DepProductInfo> depProductInfos;

    private boolean isActive; //не будем удалять из базы отдел, если его закроют, просто пометим как неактивный

}
