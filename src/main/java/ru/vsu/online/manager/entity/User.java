package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/*
    Сущность описывающая информацию о пользователе
 */
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;
}
