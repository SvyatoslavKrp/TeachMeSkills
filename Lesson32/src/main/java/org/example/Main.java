package org.example;

import org.example.entities.Pair;
import org.example.entities.Player;
import org.example.entities.exceptions.IllegalBetException;
import org.example.entities.exceptions.NoSuchPairException;
import org.example.services.Bookmaker;
import org.example.services.Hippodrome;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {

//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.example");

        Pair pair1 = context.getBean("pair1", Pair.class);
        Pair pair2 = context.getBean("pair2", Pair.class);
        Pair pair3 = context.getBean("pair3", Pair.class);

        Hippodrome hippodrome = context.getBean(Hippodrome.class);
        Bookmaker bookmaker = context.getBean(Bookmaker.class);
        Player player = context.getBean(Player.class);

        System.out.println("you have " + player.getMoney() + " money");
//        hippodrome.participantsRegistration(pair1, pair2, pair3);
        while (player.getMoney() > 0) {
            hippodrome.getRaceInfo();
            try {

                player.placeBet();
                hippodrome.startRace();
                hippodrome.showResults();

            } catch (IllegalBetException | NoSuchPairException e) {
                System.out.println(e.getMessage());
            }


            player.getResult(bookmaker.payOff());

            System.out.println("you have " + player.getMoney() + " money");
        }


        context.close();
    }
}