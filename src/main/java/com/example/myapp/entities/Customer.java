package com.example.myapp.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    private Long id;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Address")
    private String address;
    @Column(name = "Postal_Code")
    private String postal_code;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Create_Date")
    private Date create_date;
    @Column(name = "Last_Update")
    private Date last_update;
    @Column(name = "Division_ID")
    private Division division;
    @OneToMany
    //fix me
    private Set<Cart> carts;

    public Customer(){
    };

    public Customer(String firstName, String lastName, String address, String postal_code, String phone, Date create_date,
     Date last_update, Division division, Set<Cart> carts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.create_date = create_date;
        this.last_update = last_update;
        this.division = division;
        this.carts = carts;
    };



}
