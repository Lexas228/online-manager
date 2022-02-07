package ru.vsu.online.manager.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


/*
    Сущность описывающая конкретную покупку(для истории покупок) в конкретном отделе(можно будет строить интересные запросы)
 */
@Entity
@Data
@Table(name = "purchase_history", schema = "online_manager")
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user; //пользователь который совершил покупку

    @OneToMany(mappedBy = "purchaseHistory")
    private List<PurchasePartHistory> purchasePartHistoryList; //разобьем все покупку на несколько частей

    @OneToOne(optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department; //отдел, в котором он купил

    @Column(name = "total_cost")
    private Double totalCost; //общая цена

    @Column(name = "description")
    private String description; //его описание данной покупки(для разнообразия - по типу рейтинга)

    @CreatedDate
    @Column(name = "date")
    private LocalDate date;//дата покупки
}
