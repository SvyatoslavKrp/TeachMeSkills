package com.example.usersservice.config;

import com.example.usersservice.service.MyUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(
        jsr250Enabled = true,
        prePostEnabled = true,
        securedEnabled = true
)
public class NewConfiguration {

    private final MyUserDetailService detailService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests(auth -> {
            try {
                auth
                        .antMatchers("/main").authenticated()
                        .antMatchers("/login", "/info").permitAll()
                        .antMatchers("/read").hasAuthority("read")
                        .antMatchers("/write").hasAuthority("write")
                        .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
                        .antMatchers("/user").hasAuthority("ROLE_USER")
                        .and()
                        .formLogin()
                        .loginPage("/login").loginProcessingUrl("/try-login")
                        .successHandler((request, response, authentication) -> {
                            response.sendRedirect("/main");
                        })
                        .and()
                        .logout()
                        .logoutUrl("/try-logout")
                        .logoutSuccessUrl("/main")
                        .and()
                        .userDetailsService(detailService);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).httpBasic();
        return http.build();
    }

//    @Bean
//    InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails user = User.builder().username("user").password("pass").authorities("read").roles("user").build();
//        UserDetails admin = User.builder().username("admin").password("admin").authorities("write").roles("admin").build();
//        return new InMemoryUserDetailsManager(user, admin);
//
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
