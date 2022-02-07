package ru.vsu.online.manager.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


/*
    Сущность описывающая отдел в магазине
 */
@Entity
@Data
@Table(name = "department", schema = "online_manager")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_type_id")
    private DepartmentType departmentType; //тип отдела

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id")
    private Shop shop; //магазин в котором находится

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<DepProductInfo> depProductInfos; //информация о продуктах в отделе

    @Column(nullable = false, name = "is_active")
    private boolean isActive; //не будем удалять из базы отдел, если его закроют, просто пометим как неактивный

}
