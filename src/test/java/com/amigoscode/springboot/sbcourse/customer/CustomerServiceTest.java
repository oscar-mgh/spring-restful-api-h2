package com.amigoscode.springboot.sbcourse.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer mike = new Customer(1L, "Mike", "hellotoo", "mike@gmail.com");
        Customer mat = new Customer(2L, "Mathew", "hellotoo", "mathew@gmail.com");
        customerRepository.saveAll(Arrays.asList(mike, mat));
        List<Customer> customers = underTest.getCustomers();

        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        Customer mike = new Customer(1L, "Mike", "hello", "mike@gmail.com");
        customerRepository.save(mike);

        Customer actual = underTest.getCustomer(1L);
        assertEquals(1L, actual.getId());
        assertEquals("Mike", actual.getName());
        assertEquals("hello", actual.getPassword());
        assertEquals("mike@gmail.com", actual.getEmail());
    }
}