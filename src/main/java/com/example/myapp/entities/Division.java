package com.example.myapp.entities;

import java.util.Date;
import java.util.Set;

public class Division {
    private Long id;
    private String division_name;
    private Date create_date;
    private Date last_update;
    private Country country;
    private Long country_ID;
    private Set<Customer> customers;
}
