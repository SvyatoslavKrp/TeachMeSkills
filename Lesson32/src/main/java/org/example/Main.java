package org.example;

import org.example.entities.Pair;
import org.example.entities.Player;
import org.example.entities.exceptions.IllegalBetException;
import org.example.services.Bookmaker;
import org.example.services.Hippodrome;
import org.example.services.impl.BookmakerImpl;
import org.example.services.impl.HippodromeImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Pair pair1 = context.getBean("pair1", Pair.class);
        Pair pair2 = context.getBean("pair2", Pair.class);
        Pair pair3 = context.getBean("pair3", Pair.class);

        Hippodrome hippodrome = context.getBean(HippodromeImpl.class);
        Bookmaker bookmaker = context.getBean(BookmakerImpl.class);
        Player player = context.getBean(Player.class);

        System.out.println("you have " + player.getMoney() + " money");
//        hippodrome.participantsRegistration(pair1, pair2, pair3);
        while (player.getMoney() > 0) {
            try {
                player.placeBet(pair2);

                hippodrome.getRaceInfo();
                hippodrome.startRace();
                hippodrome.showResults();

                player.getResult(bookmaker.payOff());

                System.out.println("you have " + player.getMoney() + " money");
            } catch (IllegalBetException e) {
                System.out.println("you have no enough money");
                break;
            }
        }
        context.close();
    }
}