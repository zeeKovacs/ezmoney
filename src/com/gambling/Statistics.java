package com.gambling;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.text.ParseException;

import java.util.HashSet;
import java.lang.Math;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Statistics {
    FileHandler fh = new FileHandler();
    String[][] statData = fh.read("data/history.csv");
    String[][] tempData = fh.read("data/temp.csv");
    private String[] horses = horses();
    private String[] tracks = tracks();
    private Map<String, Integer> racePerTrack = new HashMap<>();
    private Map<String, String[]> trackResults = new HashMap<>();
    private Map<String, double[]> statRecords = new HashMap<>();

    public void initMaps() {
        racePerTrack();
        trackResults();
        statRecords();
    }

    public Map<String, Integer> racePerTrack() {
            for (int i=0; i < statData.length; i++) {
                if (racePerTrack.get(statData[i][1]) == null) {
                    racePerTrack.put(statData[i][1], 1);
                } else {
                    racePerTrack.put(statData[i][1], racePerTrack.get(statData[i][1]) + 1);
                }
            }
            return racePerTrack;
    }

    public String[] horses() {
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
        int len = racePerTrack.get(track);
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

    public Map<String, String[]> trackResults() {
        for (int i = 0; i < 10; i++) {
            if (trackResults.get(tracks[i]) == null) {
                trackResults.put(tracks[i], winnersOnTrack(tracks[i]));
            }
        }
        return trackResults;            
    }

    public double[] horseWinCounter(String track) {
        int k = 0;
        String[] winners = trackResults.get(track);
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
            tempInt[z] = (tempInt[z] / racePerTrack.get(track)) * 100;
            double num = tempInt[z];
            double rounded = Math.round(num * 100) / 100;
            tempInt[z] = rounded;
        }
        return tempInt;
    }

    public Map<String, double[]> statRecords() {
        for (int i = 0; i < 10; i++) {
            if (statRecords.get(tracks[i]) == null) {
                statRecords.put(tracks[i], horseWinCounter(tracks[i]));
            }
        }
        return statRecords;            
    }
    
    public String winnerOnTrack(String track) {
        double[] trackS = statRecords.get(track);
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

    public Integer numOfSims(String file) {
        Integer num = fh.fileLines(file);
        return num;
    }

    public int historyLength() {
        return statData.length;
    }

    public long getTimeDiff() {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
            Date date1 = format.parse(tempData[0][0]);
            Date date2 = format.parse(tempData[numOfSims("data/temp.csv")-1][0]);
            long diffInMillies = date2.getTime() - date1.getTime();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
            
        } catch (ParseException e) {
            return 0;
        }
    }

    public String[][] getPlacementNames() {
        String[][] raceResults = new String[statData.length][9];
        for (int i=0; i < statData.length; i++) {
            System.arraycopy(statData[i], 1, raceResults[i], 0, 9);
        }
        return raceResults;
    }

    public double[] getPlacementPercentages(String track, String horse) {
        double[] placementRates = new double[8];
        int trackCounter = 0;
        for (int i=0; i < statData.length; i++) {
            if (statData[i][1].equals(track)) {
                trackCounter++;
                for (int j=2; j < 10; j++) {
                    if (statData[i][j].equals(horse)) {
                        placementRates[j-2] += 1;
                        break;
                    } 
                }
            }
        }

        for (int i=0; i < 8; i++) {
            placementRates[i] = placementRates[i] / trackCounter * 100;
        }

        return placementRates;
    }

    public String[] getHorses() {
        return this.horses;
    }

    public String[] getTracks() {
        return this.tracks;
    }

}