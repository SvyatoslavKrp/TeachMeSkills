package org.example.services;

import org.example.entities.Pair;

import java.util.Map;

public interface Hippodrome {

    //    void participantsRegistration(Pair... pairs);
    void startRace();

    void prepareRacing();

    Map<Pair, Double> getParticipants();


    void registerPair(Pair pair);

    Map<Pair, Double> getResult();
}
