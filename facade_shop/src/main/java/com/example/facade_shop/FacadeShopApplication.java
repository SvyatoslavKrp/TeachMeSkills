package com.example.facade_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FacadeShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacadeShopApplication.class, args);
    }

}
