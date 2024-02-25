package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {


    @Autowired
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (customerRepository.count() == 1) {
            List<Division> division = divisionRepository.findAll();
            //System.out.println(division.get(44).getDivision_name());
            Customer customer1 = new Customer();
            customer1.setFirstName("Ben");
            customer1.setLastName("Jamison");
            customer1.setAddress("123 Washington Ave");
            customer1.setPostal_code("29354");
            customer1.setPhone("283-453-8573");
            customer1.setDivision(division.get(44));
            customerRepository.save(customer1);

            Customer customer2 = new Customer();
            customer2.setFirstName("Jimmy");
            customer2.setLastName("John");
            customer2.setAddress("284 Sandwich Ln");
            customer2.setPostal_code("38295");
            customer2.setPhone("193-433-3823");
            customer2.setDivision(division.get(40));
            customerRepository.save(customer2);

            Customer customer3 = new Customer();
            customer3.setFirstName("Mike");
            customer3.setLastName("Tyson");
            customer3.setAddress("187 Box Dr");
            customer3.setPostal_code("93847");
            customer3.setPhone("929-293-7462");
            customer3.setDivision(division.get(12));
            customerRepository.save(customer3);

            Customer customer4 = new Customer();
            customer4.setFirstName("Sydney");
            customer4.setLastName("Sweeney");
            customer4.setAddress("364 Angels Ave");
            customer4.setPostal_code("92736");
            customer4.setPhone("951-928-8374");
            customer4.setDivision(division.get(37));
            customerRepository.save(customer4);

            Customer customer5 = new Customer();
            customer5.setFirstName("Jenna");
            customer5.setLastName("Ortega");
            customer5.setAddress("273 Palm Loop");
            customer5.setPostal_code("93827");
            customer5.setPhone("951-325-0394");
            customer5.setDivision(division.get(37));
            customerRepository.save(customer5);
            System.out.println("Customers have now been created.");
        } else {
            System.out.println("Customers have already been created.");
        }
    }
}
