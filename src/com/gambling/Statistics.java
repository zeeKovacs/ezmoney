package com.gambling;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

//THIS IS CHAOS, PLEASE DONT TOUCH IT
//THIS IS CHAOS, PLEASE DONT TOUCH IT
//THIS IS CHAOS, PLEASE DONT TOUCH IT

public class Statistics {
    FileHandler fh = new FileHandler();
    String[][] statData = fh.Read("data/history.csv");
    private Map<String, Double> statistics = new HashMap<>();
    private Map<String, Integer> winCount = new HashMap<>();
    private Map<String, Integer> raceCount = new HashMap<>();
    private String[] horses;
    private String[] tracks;
    private Map<String, String[]> trackRec = new HashMap<>();
    private String[] temp;
    
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

    public String[] tracks() {
        Set<String> horseset = new HashSet<>();
        for (int i = 0; i < statData.length; i++) {
            horseset.add(statData[i][2]);
            }
        String[] horses = horses.toArray(new String[horseset.size()]);
        return horses;
    }

    public String[] contenders() {
        Set<String> trackset = new HashSet<>();
        for (int i = 0; i < statData.length; i++) {
            trackset.add(statData[i][1]);
            }
        String[] tracks = trackset.toArray(new String[trackset.size()]);
        return tracks;
    }
    public String[] winnersOnTrack(String track) {
        int len = raceCount.get(track);
        temp = new String[len];
        for (int i = 0; i < statData.length; i++) {
            if (statData[1].equals(track)) {
                temp[i] = statData[i][1];
            }
        }
        return temp;
    }

    public Map<String, String[]> trackRecords() {
        int k = 0;
        for (int i = 0; i < statData.length; i++) {
            if (trackRec.get(tracks[k]) == null) {
                trackRec.put(tracks[k], winnersOnTrack(tracks[k]));
                k++;
            }
        }
        return trackRec;            
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