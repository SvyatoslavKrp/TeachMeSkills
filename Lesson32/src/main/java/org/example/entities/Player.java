package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.services.Bookmaker;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

@Setter
@Getter
@Component
public class Player {

    @Min(0)
    private int money = 100;
    private Bookmaker bookmaker;

    public Player(Bookmaker bookmaker) {
        this.bookmaker = bookmaker;
    }


    public void feelConsequences(int bet) {
        money += bet;
    }

}
