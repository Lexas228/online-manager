package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/*
    Сущность описывающая привилегии какой то роли(например: мэнэджер - "смотреть кол-во продуктов", директор - "заказывать")
 */
@Entity
@Data
@Table(name = "privilege")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "name")
    private String name;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "priv_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")},
    name = "priv_role")
    private Set<Role> roles;
}
