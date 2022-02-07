package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/*
    Сущность описывающая информацию роль(директор, мэнэджер)
 */
@Entity
@Data
@Table(name = "role", schema = "online_manager")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "name")
    private String name;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")},
            name = "user_roles")
    private List<User> users;
}
