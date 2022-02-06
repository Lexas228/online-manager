package ru.vsu.online.manager.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/*
    Объект, который будет приходит в очередь, с инофрмацией о покупке
    (для покупателей)
 */
@Data
public class Purchase {
    private Long userId;
    private Long departmentId;
    private Map<Long, Long> productsId; //ключ - id товара, значение - кол-во
    private String description;
}
