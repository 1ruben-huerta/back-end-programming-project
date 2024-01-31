package com.example.myapp.entities;

import java.util.Date;
import java.util.Set;

public class CartItem {
    private Long id;
    private Vacation vacation;
    private Set<Excursion> excursions;
    private Cart cart;
    private Date create_date;
    private Date last_update;
}
