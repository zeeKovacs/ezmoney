package com.gambling;

import java.util.Map;
import java.util.Collections;

public class Horse {
    private String name;
    private int climates;
    private Map<Integer, Integer> terrains;
    private int lengths;
    private int jockeySkill;
    private String terrainPref;
    private String climatePref;
    private String lengthPref;
    private String jockey;

    public Horse(String[] data) {
        this.name = data[0];
        this.terrains = Map.of(1, Integer.parseInt(data[1].substring(0, 1)), 
                               2, Integer.parseInt(data[1].substring(1, 2)),
                               3, Integer.parseInt(data[1].substring(2, 3)),
                               4, Integer.parseInt(data[1].substring(3, 4)));
        this.climates = Integer.parseInt(data[2]);
        this.lengths = Integer.parseInt(data[3]);
        this.jockeySkill = Integer.parseInt(data[4]);
    }

    public Map<Integer, Integer> getTerrains() {
        return this.terrains;
    }

    public int getClimates() {
        return this.climates;
    }

    public int getLength() {
        return this.lengths;
    }

    public int getJockey() {
        return this.jockeySkill;
    }

    public String getName() {
        return this.name;
    }

    public static Horse[] createHorses() {
        FileHandler fh = new FileHandler();
        String[][] horseData = fh.read("data/horses.csv");
        Horse[] horses = new Horse[fh.fileLines("data/horses.csv")];
        for (int i = 0; i < horseData.length; i++) {
            horses[i] = new Horse(horseData[i]);
        }
        return horses; 
    }

    public String getTerrainPref() {
        int max = Collections.max(this.terrains.values());
        switch (max) {
            case 1:
                this.terrainPref = "sand";
                break;
            case 2:
                this.terrainPref = "grass";
                break;
            case 3:
                this.terrainPref = "slag";
                break;
            case 4:
                this.terrainPref = "asphalt";
                break;
            default:
                this.terrainPref = "grass";
                break;
        }
        return this.terrainPref;
    }

    public String getClimatePref() {
        switch (this.climates) {
            case 1:
                this.climatePref = "warm";
                break;
            case 2:
                this.climatePref = "cold";
                break;
            default:
                break;
        }
        return this.climatePref;
    }

    public String getLengthPref() {
        switch (this.lengths) {
            case 1:
                this.lengthPref = "short";
                break;
            case 2:
                this.lengthPref = "medium";
                break;
            case 3:
                this.lengthPref = "long";
                break;
            default:
                break;
        }
        return this.lengthPref;
    }

    public String getJockeySkill() {
        switch (this.jockeySkill) {
            case 3:
                this.jockey = "low-skilled jockey";
                break;
            case 4:
                this.jockey = "medium-skilled jockey";
                break;
            case 5:
                this.jockey = "high-skilled jockey";
                break;
            default:
                break;
        }
        return this.jockey;
    }

    @Override
    public String toString() {
        return this.name + " is a horse who runs best on " + this.terrainPref + " terrain and prefers " + this.lengthPref +
               " distance tracks, where the climate is " + this.climatePref + ". " + "Currently has a " + this.jockey + ".\n";
    }
}