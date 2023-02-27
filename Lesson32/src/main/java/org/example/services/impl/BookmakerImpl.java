package org.example.services.impl;

import org.example.entities.Pair;
import org.example.services.Bookmaker;
import org.example.services.Hippodrome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BookmakerImpl implements Bookmaker {

    private int acceptedBet;
    private final Hippodrome hippodrome;

    @Autowired
    public BookmakerImpl(Hippodrome hippodrome) {
        this.hippodrome = hippodrome;
    }

    @Override
    public int acceptBet(String bet, String pair) {

        for (Pair aPair : hippodrome.getParticipants().keySet()) {
            if (aPair.getPairName().equals(pair)) {
                aPair.setChosen(true);
            }
        }
        return acceptedBet = Integer.parseInt(bet);
    }

    @Override
    public int payOff() {
        Set<Pair> results = hippodrome.getResult().keySet();

        Pair pair = results.stream().iterator().next();

        return pair.isChosen() ? acceptedBet : -acceptedBet;
    }

}
