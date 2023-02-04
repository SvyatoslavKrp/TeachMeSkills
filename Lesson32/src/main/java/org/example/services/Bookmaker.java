package org.example.services;

import org.example.entities.Pair;

public interface Bookmaker {

    int acceptBet(Pair pair);

    int payOff();

    void close();
}
