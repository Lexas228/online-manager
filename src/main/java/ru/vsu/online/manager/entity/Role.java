package ru.vsu.online.manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/*
    Сущность описывающая информацию роль(директор, мэнэджер)
 */
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Privilege> privileges;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")},
            name = "user_roles")
    private Set<User> users;
}
