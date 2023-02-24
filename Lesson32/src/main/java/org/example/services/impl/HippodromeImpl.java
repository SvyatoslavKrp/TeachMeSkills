package org.example.services.impl;

import org.example.entities.Pair;
import org.example.services.Hippodrome;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HippodromeImpl implements Hippodrome {

    private static final double LAP_DISTANCE = 400;
    private static final byte countLaps = 5;
    private Map<Pair, Double> participants = new HashMap<>();

    public Map<Pair, Double> getParticipants() {
        return participants;
    }

    public void registerPair(Pair pair) {
        participants.put(pair, 0.);
    }

    @Override
    public void startRace() {

        for (int i = 0; i < countLaps; i++) {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }


            for (Pair pair : participants.keySet()) {
                double timeLap = LAP_DISTANCE / (pair.getSpeed() - pair.getHorse().horseEndurance());
                participants.put(pair, participants.get(pair) + timeLap);
            }
        }
    }

    @Override
    public Map<Pair, Double> getResult() {
        sortList();
        return participants;
    }

    private void sortList() {
        participants = participants.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }

    public void prepareRacing() {
        participants.replaceAll((pair, aDouble) -> 0.);
        participants.keySet().forEach(pair -> pair.setChosen(false));
    }

}
