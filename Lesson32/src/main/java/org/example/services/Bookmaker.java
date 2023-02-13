package org.example.services;

import org.example.entities.Pair;
import org.example.entities.exceptions.NoSuchPairException;

public interface Bookmaker {

    int acceptBet() throws NoSuchPairException;

    int payOff();

    void close();
}
