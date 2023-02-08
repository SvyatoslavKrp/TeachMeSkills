package org.example.services.impl;

import org.example.entities.Pair;
import org.example.entities.exceptions.NoSuchPairException;
import org.example.services.Bookmaker;
import org.example.services.Hippodrome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

@Service
public class BookmakerImpl implements Bookmaker {

    private int acceptedBet;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final Hippodrome hippodrome;

    @Autowired
    public BookmakerImpl(Hippodrome hippodrome) {
        this.hippodrome = hippodrome;
    }

    @PreDestroy
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int acceptBet() throws NoSuchPairException {

        System.out.println("type in your bet");
        int bet = 0;
        try {
            String line = reader.readLine();
            while (true) {
                try {
                    if ("exit".equals(line)) {
                        throw new RuntimeException();
                    }
                    bet = Integer.parseInt(line);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("retype in your bet");
                    line = reader.readLine();
                }
            }
            System.out.println("Select your pair");
            String betPair = reader.readLine();
            Map<Pair, Double> participants = hippodrome.getResults();
            int count = 0;
            for (Pair pair : participants.keySet()) {
                if (pair.getPairName().equals(betPair)) {
                    pair.setChosen(true);
                    count++;
                }
            }
            if (count < 1) {
                throw new NoSuchPairException();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return acceptedBet = bet;
    }

    @Override
    public int payOff() {
        Set<Pair> results = hippodrome.getResults().keySet();

        Pair pair = results.stream().iterator().next();

        if (pair.isChosen()) {
            return acceptedBet * 2;
        }

        return -acceptedBet;
    }

}
