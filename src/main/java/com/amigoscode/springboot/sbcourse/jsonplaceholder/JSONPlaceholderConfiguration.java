package com.amigoscode.springboot.sbcourse.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceholderConfiguration {
    @Bean("json placeholder")
    CommandLineRunner commandLineRunner(JSONPlaceholderClient jsonPlaceholderClient) {
        return args -> {
            System.out.println();
            System.out.println("Getting response from json placeholder with open feign");
            System.out.println("https://jsonplaceholder.typicode.com/posts");
            System.out.println("Posts size = " + jsonPlaceholderClient.getPosts().size());
            System.out.println();
            System.out.println("Getting user with id 4");
            System.out.println("https://jsonplaceholder.typicode.com/posts/4");
            System.out.println(jsonPlaceholderClient.getPost(4));
            System.out.println();
        };
    }

}
