package com.example.usersservice.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @PostAuthorize("hasRole('ROLE_ADMIN')")
    public void test() {
        System.out.println("hello");
    }

}
