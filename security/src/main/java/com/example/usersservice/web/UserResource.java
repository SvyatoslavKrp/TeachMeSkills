package com.example.usersservice.web;

import com.example.usersservice.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserResource {

    private final TestService testService;

    @GetMapping("main")
    public String main() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "main-page.html";
    }

    @GetMapping("login")
    public String login() {
        return "login-page.html";
    }

    @GetMapping("read")
    public String read() {
        return "read-page.html";
    }
    @GetMapping("write")
    public String write() {
        return "write-page.html";
    }
    @GetMapping("admin")
    public String admin() {
        return "admin-page.html";
    }
    @GetMapping("user")
    public String user() {
        return "user-page.html";
    }
    @GetMapping("info")
    public String info() {
        return "info-page.html";
    }

//    @Secured("ROLE_ADMIN")
    @GetMapping("test")
    public void test() {
        testService.test();
        System.out.println();
    }
}
