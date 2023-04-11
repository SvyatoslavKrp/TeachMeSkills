package com.example.jwt.config;

import com.example.jwt.domain.User;
import com.example.jwt.service.TokenService;
import com.example.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor

@Service
public class TokenGeneratorFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String username = request.getParameter("username");
        User userByName = userService.getUserByName(username);

        if (userByName != null) {
            List<SimpleGrantedAuthority> simpleGrantedAuthorities = userByName.getAuths()
                    .stream()
                    .map(SimpleGrantedAuthority::new)
                    .toList();
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userByName.getUsername(), null, simpleGrantedAuthorities);

            String tokenAsString = tokenService.createToken(token);
            response.setHeader("token", tokenAsString);
        }
        filterChain.doFilter(request, response);
    }
}
