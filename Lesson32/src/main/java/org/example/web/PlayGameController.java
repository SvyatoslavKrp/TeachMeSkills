package org.example.web;

import lombok.NoArgsConstructor;
import org.example.entities.Pair;
import org.example.entities.Player;
import org.example.services.Bookmaker;
import org.example.services.Hippodrome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/play")
@NoArgsConstructor
public class PlayGameController {

    private Hippodrome hippodrome;
    private Bookmaker bookmaker;
    private Player player;

    @Autowired
    public PlayGameController(Hippodrome hippodrome, Player player, Bookmaker bookmaker) {
        this.bookmaker = bookmaker;
        this.hippodrome = hippodrome;
        this.player = player;
    }

    @GetMapping
    public ModelAndView goToPage() {
        ModelAndView modelAndView = new ModelAndView("play");
        hippodrome.prepareRacing();
        modelAndView.addObject("pairs", hippodrome.getParticipants().keySet());
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView play(@NotBlank @RequestParam(name = "bet") String bet, @NotBlank @RequestParam(name = "radio") String pairName) {

        bookmaker.acceptBet(bet, pairName);
        hippodrome.startRace();
        player.feelConsequences(bookmaker.payOff());

        return showResult();
    }

    @GetMapping("/result")
    public ModelAndView showResult() {
        ModelAndView modelAndView = new ModelAndView("result");
        Map<Pair, Double> result = hippodrome.getResult();
        Set<Pair> pairs = result.keySet();
        modelAndView.addObject("pairs", pairs);
        modelAndView.addObject("result", result);
        modelAndView.addObject("player", player);
        return modelAndView;

    }

}
