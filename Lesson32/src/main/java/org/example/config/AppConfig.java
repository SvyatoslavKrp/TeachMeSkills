package org.example.config;

import org.example.entities.Horse;
import org.example.entities.Pair;
import org.example.entities.Rider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"org.example"})
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    Horse horseJacqueline() {
        return new Horse("Jacqueline");
    }
    @Bean
    Horse horseAggressive() {
        return new Horse("Aggressive");
    }
    @Bean
    Horse horseStrong() {
        return new Horse("Strong");
    }

    @Bean
    Rider riderDavid() {
        return new Rider("David");
    }
    @Bean
    Rider riderJohn() {
        return new Rider("John");
    }
    @Bean
    Rider riderLucas() {
        return new Rider("Lucas");
    }

    @Bean
    Pair pair1() {
        return new Pair(horseAggressive(), riderDavid());
    }
    @Bean
    Pair pair2() {
        return new Pair(horseStrong(), riderJohn());
    }
    @Bean
    Pair pair3() {
        return new Pair(horseJacqueline(), riderLucas());
    }

    @Bean
    Map<Pair, Double> participants() {
        Map<Pair, Double> participants = new HashMap<>();

        participants.put(pair1(), 0.);
        participants.put(pair2(), 0.);
        participants.put(pair3(), 0.);

        return participants;
    }

}
