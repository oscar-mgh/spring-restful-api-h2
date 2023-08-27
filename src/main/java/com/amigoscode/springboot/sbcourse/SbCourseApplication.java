package com.amigoscode.springboot.sbcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SbCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbCourseApplication.class, args);
    }
}
