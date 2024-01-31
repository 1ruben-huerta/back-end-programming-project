package com.example.myapp.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Cart {
    private Long id;
    private String orderTrackingNumber;
    private BigDecimal package_price;
    private int party_size;
    private StatusType status;
    private Date create_date;
    private Date last_update;
    private Customer customer;
    private Set<CartItem> cartItem;
}
