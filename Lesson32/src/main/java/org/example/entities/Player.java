package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.entities.exceptions.IllegalBetException;
import org.example.services.Bookmaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Player {

    @Value("100")
    private int money;
    private Bookmaker bookmaker;

    @Autowired
    public Player(Bookmaker bookmaker) {
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
