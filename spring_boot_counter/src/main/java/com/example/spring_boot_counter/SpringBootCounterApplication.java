package com.example.spring_boot_counter;

import com.example.spring_boot_counter.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCounterApplication {

    @Autowired
    CounterService counterService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCounterApplication.class, args);
    }

}
