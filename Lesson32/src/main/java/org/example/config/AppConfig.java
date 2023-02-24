package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"org.example"})
@EnableAspectJAutoProxy
public class AppConfig {

//    @Bean
//    Horse horseJacqueline() {
//        return new Horse();
//    }
//    @Bean
//    Horse horseAggressive() {
//        return new Horse();
//    }
//    @Bean
//    Horse horseStrong() {
//        return new Horse();
//    }
//
//    @Bean
//    Rider riderDavid() {
//        return new Rider("David");
//    }
//    @Bean
//    Rider riderJohn() {
//        return new Rider("John");
//    }
//    @Bean
//    Rider riderLucas() {
//        return new Rider("Lucas");
//    }
//
//    @Bean
//    Pair pair1() {
//        return new Pair(horseAggressive(), riderDavid());
//    }
//    @Bean
//    Pair pair2() {
//        return new Pair(horseStrong(), riderJohn());
//    }
//    @Bean
//    Pair pair3() {
//        return new Pair(horseJacqueline(), riderLucas());
//    }

//    @Bean
//    Map<Pair, Double> participants() {
//        Map<Pair, Double> participants = new HashMap<>();
//
//        participants.put(pair1(), 0.);
//        participants.put(pair2(), 0.);
//        participants.put(pair3(), 0.);
//
//        return participants;
//    }

}
