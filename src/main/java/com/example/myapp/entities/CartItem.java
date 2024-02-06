package com.example.myapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart_items")
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;
    private Vacation vacation;
    private Set<Excursion> excursions;
    private Cart cart;
    @Column(name = "create_date")
    private Date create_date;
    @Column(name = "last_update")
    private Date last_update;
}
