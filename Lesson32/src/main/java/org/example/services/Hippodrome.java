package org.example.services;

import org.example.entities.Pair;

import java.util.Map;

public interface Hippodrome {

    //    void participantsRegistration(Pair... pairs);
    void startRace();

    void getRaceInfo();

    void showResults();

    Map<Pair, Double> getResults();


}
