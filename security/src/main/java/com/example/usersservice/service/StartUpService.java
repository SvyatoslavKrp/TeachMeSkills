package com.example.usersservice.service;

import com.example.usersservice.model.User;
import com.example.usersservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StartUpService {

    private final UserRepository repository;

    @PostConstruct
    private void init() {
        User user = User.builder()
                .id(UUID.randomUUID())
                .username("user")
                .password("pass")
                .auths("ROLE_USER")
                .build();
        User admin = User.builder()
                .id(UUID.randomUUID())
                .username("admin")
                .password("pass")
                .auths("ROLE_ADMIN")
                .build();
        User read = User.builder()
                .id(UUID.randomUUID())
                .username("read")
                .password("pass")
                .auths("read")
                .build();
        User write = User.builder()
                .id(UUID.randomUUID())
                .username("write")
                .password("pass")
                .auths("write")
                .build();
        repository.save(user);
        repository.save(admin);
        repository.save(read);
        repository.save(write);
    }

}
