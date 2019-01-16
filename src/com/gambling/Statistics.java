package com.gambling;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.lang.Math;

public class Statistics {
    FileHandler fh = new FileHandler();
    String[][] statData = fh.Read("data/history.csv");
    private Map<String, Integer> raceCount = new HashMap<>();
    private Map<String, String[]> trackRec = new HashMap<>();
    private Map<String, double[]> statRec = new HashMap<>();
    private String[] horses = contenders();
    private String[] tracks = tracks();

    public void initMaps() {
        raceCount();
        trackRecords();
        statRecords();
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

    public String[] contenders() {
        Set<String> horseset = new HashSet<>();
        for (int i = 0; i < statData.length; i++) {
            horseset.add(statData[i][2]);
            }
        String[] horses = horseset.toArray(new String[horseset.size()]);
        return horses;
    }

    public String[] tracks() {
        Set<String> trackset = new HashSet<>();
        for (int i = 0; i < statData.length; i++) {
            trackset.add(statData[i][1]);
            }
        String[] tracks = trackset.toArray(new String[trackset.size()]);
        return tracks;
    }
    public String[] winnersOnTrack(String track) {
        int len = raceCount.get(track);
        String[] temp = new String[len];
        int k = 0;
        for (int i = 0; i < statData.length; i++) {
            if (statData[i][1].equals(track)) {
                temp[k] = statData[i][2];
                k++;
            }
        }
        return temp;
    }

    public Map<String, String[]> trackRecords() {
        for (int i = 0; i < 10; i++) {
            if (trackRec.get(tracks[i]) == null) {
                trackRec.put(tracks[i], winnersOnTrack(tracks[i]));
            }
        }
        return trackRec;            
    }

    public double[] horseWinCounter(String track) {
        int k = 0;
        String[] winners = trackRec.get(track);
        double[] tempInt = new double[horses.length];
        Arrays.sort(horses);
        Arrays.sort(winners);
        for (int i = 0; i < winners.length; i++) {
            if (horses[k].equals(winners[i])) {
                tempInt[k] += 1;
            } else {
                k++;
                i--;
            }
        }
        for (int z = 0; z < tempInt.length; z++) {
            tempInt[z] = (tempInt[z] / raceCount.get(track)) * 100;
            double num = tempInt[z];
            double rounded = Math.round(num * 100) / 100;
            tempInt[z] = rounded;
        }
        return tempInt;
    }

    public Map<String, double[]> statRecords() {
        for (int i = 0; i < 10; i++) {
            if (statRec.get(tracks[i]) == null) {
                statRec.put(tracks[i], horseWinCounter(tracks[i]));
            }
        }
        return statRec;            
    }
    
    public String winnerWinner(String track) {
        double[] trackS = statRec.get(track);
        double max = 0;
        int indx = 0;
        for (int i = 0; i < trackS.length; i++) {
            if (trackS[i] > max) {
                max = trackS[i];
                indx = i;
            }
        }
        Arrays.sort(horses);
        return horses[indx];          
    }





    //Stores statistical data about the simulation: how many number of 
    //simulations were run, how many data points, 
    //how long it take to run all the simulations, winning/losing percentages, 
    //etc. It depends on the selected game.
}