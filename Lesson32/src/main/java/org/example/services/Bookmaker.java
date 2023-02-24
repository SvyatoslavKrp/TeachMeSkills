package org.example.services;

public interface Bookmaker {

    int acceptBet(String bet, String pair);

    int payOff();
}
