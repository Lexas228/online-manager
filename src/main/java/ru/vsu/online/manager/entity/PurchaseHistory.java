package ru.vsu.online.manager.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;


/*
    Сущность описывающая конкретную покупку(для истории покупок) в конкретном отделе(можно будет строить интересные запросы)
 */
@Entity
@Data
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user; //пользователь который совершил покупку

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product; //продукт, который он купил

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department; //отдел, в котором он купил

    private Long count; //количество купленного товара

    private String description; //его описание данной покупки(для разнообразия - по типу рейтинга)

    @CreatedDate
    private LocalDate date;//дата покупки
}
