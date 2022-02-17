package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/*
    Сущность описывающая информацию о пользователе
 */
@Entity
@Data
@Table(name = "user", schema = "online_manager")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "name")
    private String login;


    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
}
