package ru.didorenko.lunchvote.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import ru.didorenko.lunchvote.common.model.BaseEntity;
import ru.didorenko.lunchvote.user.model.User;

import java.time.LocalDate;

@Entity
@Data
public class Vote extends BaseEntity {

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
