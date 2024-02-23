package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Division division = new Division();
        division.setId(2L);
        Customer customer1 = new Customer("Ben", "Jamison", "123 Washington Ave", "29352",
                "919-112-2354", division);
        customer1.getDivision().getId();
        division.getCustomers().add(customer1);
        customerRepository.save(customer1);
        divisionRepository.save(division);
    }
}
