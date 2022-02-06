package ru.vsu.online.manager.pojo;

import lombok.Data;

import java.util.List;

/*
    Объект, который будет приходит в очередь, с инофрмацией о покупке
    (для покупателей)
 */
@Data
public class Purchase {
    private Long userId;
    private Long departmentId;
    private List<Integer> productsId;
    private String description;
}
