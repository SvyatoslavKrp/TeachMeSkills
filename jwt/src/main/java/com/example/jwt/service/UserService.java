package com.example.jwt.service;

import com.example.jwt.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public User getUserByName(String username) {

        if (StringUtils.isNotBlank(username)) {
            return User.builder()
                    .username(username)
                    .password("password")
                    .auths(List.of("user", "admin"))
                    .build();
        }
        return null;
    }

}
