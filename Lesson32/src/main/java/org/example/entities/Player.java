package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.entities.exceptions.IllegalBetException;
import org.example.services.Bookmaker;

@Setter
@Getter
public class Player {

    private int money;
    private Bookmaker bookmaker;

    public Player(int money, Bookmaker bookmaker) {
        this.money = money;
        this.bookmaker = bookmaker;
    }

    //можно ли разбивать валидацию ставки? Делать часть у player и часть - у bookmaker
    public void placeBet(Pair pair) throws IllegalBetException {

        int bet = bookmaker.acceptBet(pair);
        if (bet > money) {
            throw new IllegalBetException();
        }
        money -= bet;
    }

    public void getResult(int bet) {
        if (bet > 0) {
            money += bet;
        }
    }

}
