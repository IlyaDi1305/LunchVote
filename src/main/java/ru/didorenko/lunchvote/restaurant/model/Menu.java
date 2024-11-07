package ru.didorenko.lunchvote.restaurant.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.didorenko.lunchvote.common.model.BaseEntity;
import java.time.LocalDate;

@Entity
@Table(name = "menu")
@Data
public class Menu extends BaseEntity {

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}