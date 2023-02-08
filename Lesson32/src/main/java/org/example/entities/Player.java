package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.entities.exceptions.IllegalBetException;
import org.example.entities.exceptions.NoSuchPairException;
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

    public void placeBet() throws IllegalBetException, NoSuchPairException {

        int bet = 0;

        bet = bookmaker.acceptBet();

        if (bet > money || bet < 1) {
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
