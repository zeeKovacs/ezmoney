package com.gambling;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Statistics {
    FileHandler fh = new FileHandler();
    String[][] statData = fh.Read("data/history.csv");
    private Map<String, Double> statistics = new HashMap<>();
    private Map<String, Integer> winCount = new HashMap<>();
    private Map<String, Integer> raceCount = new HashMap<>();
    
    public Map<String, Integer> winCount() {
        for (int i=0; i < statData.length; i++) {
            if (winCount.get(statData[i][2]) == null) {
                winCount.put(statData[i][2], 1);
            } else {
                winCount.put(statData[i][2], winCount.get(statData[i][2]) + 1);
            }
        }
        return winCount;
    }

    public Map<String, Integer> raceCount() {
            for (int i=0; i < statData.length; i++) {
                if (raceCount.get(statData[i][1]) == null) {
                    raceCount.put(statData[i][1], 1);
                } else {
                    raceCount.put(statData[i][1], raceCount.get(statData[i][1]) + 1);
                }
            }
            return raceCount;
    }

    public Map<String, Double> stats() {
        for (String horse : winCount.keySet()) {
            if (statistics.get(horse) == null) {
                statistics.put(horse, (double)winCount.get(horse) / 2);
            }
        }
        return statistics;
    }


    public void statPrint() {
        for (String[] line : statData) {
            System.out.println(Arrays.toString(line));
        }
    }



    //Stores statistical data about the simulation: how many number of 
    //simulations were run, how many data points, 
    //how long it take to run all the simulations, winning/losing percentages, 
    //etc. It depends on the selected game.
}