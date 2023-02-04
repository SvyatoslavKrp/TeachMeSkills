package org.example.services.impl;

import org.example.entities.Pair;
import org.example.services.Hippodrome;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HippodromeImpl implements Hippodrome {

    private static final double LAP_DISTANCE = 400;
    private static final byte countLaps = 5;
    Map<Pair, Double> participants;

    public HippodromeImpl(Map<Pair, Double> participants) {
        this.participants = participants;
    }

    public Map<Pair, Double> getResults() {
        return participants;
    }

//    @Override
//    public void participantsRegistration(Pair... pairs) {
//        participants = new HashMap<>();
//        for (Pair pair : pairs) {
//            participants.put(pair, 0.);
//        }
//    }

    @Override
    public void startRace() {

        participants.replaceAll(((pair, aDouble) -> 0.));

        System.out.println("========================");
        System.out.println("the race is beginning");

        for (int i = 0; i < countLaps; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (Pair pair : participants.keySet()) {
                double timeLap = LAP_DISTANCE / (pair.getSpeed() - pair.getHorse().horseEndurance());
                participants.put(pair, participants.get(pair) + timeLap);

                System.out.printf(pair + " with total time: %.3f\n", participants.get(pair));

                if (participants.get(pair) > 0) {
                    System.out.printf("(time lap: %.3f)\n", timeLap);
                }

            }
            System.out.println("==================================");
        }
    }

    @Override
    public void getRaceInfo() {
        participants.keySet()
                .forEach(System.out::println);
    }

    @Override
    public void showResults() {
        participants = participants.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        int place = 1;
        for (Pair pair : participants.keySet()) {
            if (place != 1) {
                System.out.printf("%s has took %d place with time %.3f\n", pair.toString(), place, participants.get(pair));
            } else {
                System.out.printf("%s is winner of ouurrrr rrrraace with time %.3f\n", pair.toString(), participants.get(pair));
            }
            place++;
        }
    }

}
