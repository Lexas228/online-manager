package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


/*
    Сущность базы
 */
@Entity
@Data
@Table(name = "base", schema = "online_manager")
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "base", cascade = CascadeType.ALL)
    private List<BaseProductInfo> baseProductInfos; //информация о продуктах хранящияся в базе
}
