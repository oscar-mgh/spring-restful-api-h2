package com.amigoscode.springboot.sbcourse.customer;

import com.amigoscode.springboot.sbcourse.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {
//    @Value("${useFakeRepo:false}")
//    private Boolean useFakeRepo;

    @Value("${info.company.name}")
    private String companyName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp, CustomerRepository customerRepository) {
        return args -> {
            System.out.print("CommandLineRunner executed !!!\n\n");
            System.out.println(environment.getProperty("info.app.name"));
            System.out.print("Compay Name = " + companyName + "\n\n");

            System.out.println(infoApp);

            Customer homero = new Customer(1L, "Homero", "asdfghjklñ", "homerosimpson@email.com");
            Customer marge = new Customer(2L, "Marge", "asdfghjklñ", "margesimpson@email.com");
            Customer bart = new Customer(3L, "Bart", "asdfghjklñ", "bartsimpson@email.com");
            Customer lisa = new Customer(4L, "Lisa", "asdfghjklñ", "lisasimpson@email.com");
            Customer maggie = new Customer(5L, "Maggie", "asdfghjklñ", "maggiesimpson@email.com");
            customerRepository.save(homero);
            customerRepository.save(marge);
            customerRepository.save(bart);
            customerRepository.save(lisa);
            customerRepository.save(maggie);
        };
    }

//    @Bean
//    CustomerRepo customerRepo() {
//        System.out.println("FakeCustomerRepo: " + useFakeRepo);
//        return new CustomerFakeRepository();
//    }
}