package ru.vsu.online.manager.entity;


import liquibase.pro.packaged.E;

import javax.persistence.*;
import java.util.List;

/*
    Сущность описывающая тип отдела
 */
@Entity
@Table(name = "department_type", schema = "online_manager")
public class DepartmentType {
    @Id
    private Long id;

    @Column(nullable = false, unique = true, name = "name")
    private String name; //название

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private List<ProductType> productTypeList; //связь один ко многим(например мясной отдел будет хранить колбасу, мясо, курицу)

    @OneToMany(mappedBy = "department_type")
    private List<Department> departments; //на всякий случай свяжем с двух сторон, может быть так удобнее будет что то доставать
}
