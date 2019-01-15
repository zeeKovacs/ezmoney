package com.gambling;

import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class Race {
    
    private Racetrack racetrack;
    private Horse[] horses;
    private Horse winner;
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss:SS";

    public Race() {
        this.racetrack = createRandomTrack();
        this.horses = createHorses();
        this.winner = declareWinner();
        
    }

    public Race(Racetrack track) {
        this.racetrack = track;
        this.horses = createHorses();
        this.winner = declareWinner();
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(calendar.getTime());
    }

    private Racetrack createRandomTrack() {
        FileHandler fh = new FileHandler();
        String[][] trackDatas = fh.Read("data/racetracks.csv");
        Random random = new Random();
        int randomTrackNUmber = random.nextInt(trackDatas[0].length-1);
        String[] trackData = trackDatas[randomTrackNUmber];
        return new Racetrack(trackData[0], Integer.parseInt(trackData[1]),
                                           Integer.parseInt(trackData[2]),
                                           Integer.parseInt(trackData[3]));
    }

    private Horse[] createHorses() {
        FileHandler fh = new FileHandler();
        String[][] horseData = fh.Read("data/horses.csv");
        Horse[] horses = new Horse[fh.fileLines("data/horses.csv")];
        for (int i = 0; i < horseData.length; i++) {
            horses[i] = new Horse(horseData[i]);
        }
        return horses; 
    }

    private Horse declareWinner() {
        Random rand = new Random();
        int total = 0;
        int horseChance = 0;
        int[] horseStats = new int[9];
        horseStats[0] = 0;
        for (int i = 1; i < 9; i++) {
            horseChance += horses[i-1].getTerrains().get(racetrack.getMaterial());
            if (horses[i-1].getClimates() == racetrack.getClimate()) {
                horseChance += 2;
            } else {
                horseChance += 1;
            }
            if (horses[i-1].getLength() == racetrack.getLength()) {
                horseChance += 2;
            } else {
                horseChance += 1;
            }
            horseChance += horses[i-1].getJockey();
            horseStats[i] = total + horseChance * 100;
            total += horseChance * 100;
            horseChance = 0;        
        } 

        int winner = rand.nextInt(total) + 1;
        for (int i = 0; i < 8; i++) {
            if (winner >= horseStats[i] && winner < horseStats[i + 1]) {
                return horses[i];
            }
        }
        return null;
    } 
}
