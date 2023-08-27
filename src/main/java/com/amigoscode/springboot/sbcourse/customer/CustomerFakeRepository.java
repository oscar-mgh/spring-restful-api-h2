package com.amigoscode.springboot.sbcourse.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Fernando", "landlord", "fernan@gmail.com"),
                new Customer(2L, "Alexis", "secrecy", "alexis11@gmail.com"),
                new Customer(3L, "Armando", "resisting", "armandoando@gmail.com")
        );
    }
}
