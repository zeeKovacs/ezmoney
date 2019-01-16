package com.gambling;

import java.util.Random;
import java.util.Arrays;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Race {
    
    private Racetrack racetrack;
    private Horse[] horses;
    private Horse winner;
    private String timestamp;
    private Horse[] placements;

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss:SS";

    public Race() {
        this.racetrack = createRandomTrack();
        this.horses = createHorses();
        this.timestamp = createTimestamp();
        this.placements = getRaceResults();
        this.winner = placements[0];
    }

    public Race(Racetrack track) {
        this.racetrack = track;
        this.horses = createHorses();
        this.timestamp = createTimestamp();
        this.placements = getRaceResults();
        this.winner = placements[0];
    }

    public Racetrack getRacetrack() {
        return this.racetrack;
    }

    public Horse[] getHorses() {
        return this.horses;
    }

    public Horse getWinner() {
        return this.winner;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getPlacements() {
        int counter = placements.length;
        String horseNames = "";
        for (int i=0; i < counter-1; i++) {
            horseNames += placements[i].getName() + ",";
        }
        horseNames += placements[counter-1].getName();
        return horseNames;
    }

    private String createTimestamp() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(calendar.getTime());
    }

    private Racetrack createRandomTrack() {
        FileHandler fh = new FileHandler();
        String[][] trackDatas = fh.read("data/racetracks.csv");
        Random random = new Random();
        int randomTrackNUmber = random.nextInt(trackDatas[0].length-1);
        String[] trackData = trackDatas[randomTrackNUmber];
        return new Racetrack(trackData[0], Integer.parseInt(trackData[1]),
                                           Integer.parseInt(trackData[2]),
                                           Integer.parseInt(trackData[3]));
    }

    private Horse[] createHorses() {
        FileHandler fh = new FileHandler();
        String[][] horseData = fh.read("data/horses.csv");
        Horse[] horses = new Horse[fh.fileLines("data/horses.csv")];
        for (int i = 0; i < horseData.length; i++) {
            horses[i] = new Horse(horseData[i]);
        }
        return horses; 
    }

    private Horse[] getRaceResults() {
        Horse[] tempHorses = Arrays.copyOf(horses, 8);
        Horse[] placements = new Horse[tempHorses.length];
        for (int i=0; i < placements.length; i++) {
            placements[i] = declareWinner(8-i, tempHorses);
            tempHorses = Utility.removeFromArray(tempHorses, placements[i], Horse.class);
        }
        return placements;
    }

    private Horse declareWinner(int horseCount, Horse[] tempHorses) {
        Random rand = new Random();
        int total = 0;
        int horseChance = 0;
        int[] horseStats = new int[horseCount+1];
        horseStats[0] = 0;
        for (int i = 1; i < horseCount+1; i++) {
            horseChance += tempHorses[i-1].getTerrains().get(racetrack.getMaterial());
            if (tempHorses[i-1].getClimates() == racetrack.getClimate()) {
                horseChance += 2;
            } else {
                horseChance += 1;
            }
            if (tempHorses[i-1].getLength() == racetrack.getLength()) {
                horseChance += 2;
            } else {
                horseChance += 1;
            }
            horseChance += tempHorses[i-1].getJockey();
            horseStats[i] = total + horseChance * 100;
            total += horseChance * 100;
            horseChance = 0;        
        } 

        int winner = rand.nextInt(total) + 1;
    
        for (int i = 0; i < horseCount; i++) {
            if (winner >= horseStats[i] && winner < horseStats[i + 1]) {
                return tempHorses[i];
            }
        }
        return null;
    } 
}
