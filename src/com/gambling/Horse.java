package com.gambling;

import java.util.Map;
import java.util.Collections;

public class Horse {
    private String name;
    private int climates;
    private Map<Integer, Integer> terrains;
    private int lengths;
    private int jockeySkill;

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
        int indx = 0;
        for (int i : this.terrains.keySet()) {
            
            if (terrains.get(i) == 3) {
                indx = i;
                break;
            }
        }
        String[] materials = new String[] {"sand", "grass", "slag", "asphalt"};
        if (indx == 0) {
            return "grass";
        }
        return materials[indx-1];
    }

    public String getClimatePref() {
        String climatePref = "";
        switch (this.climates) {
            case 1:
                climatePref = "warm";
                break;
            case 2:
                climatePref = "cold";
                break;
            default:
                break;
        }
        return climatePref;
    }

    public String getLengthPref() {
        String lengthPref = "";
        switch (this.lengths) {
            case 1:
                lengthPref = "short";
                break;
            case 2:
                lengthPref = "medium";
                break;
            case 3:
                lengthPref = "long";
                break;
            default:
                break;
        }
        return lengthPref;
    }

    public String getJockeySkill() {
        String jockey = "";
        switch (this.jockeySkill) {
            case 3:
                jockey = "low-skilled jockey";
                break;
            case 4:
                jockey = "medium-skilled jockey";
                break;
            case 5:
                jockey = "high-skilled jockey";
                break;
            default:
                break;
        }
        return jockey;
    }

    @Override
    public String toString() {
        return this.name + " is a horse who runs best on " + getTerrainPref() + " covered terrains and prefers " + getLengthPref() +
               " distance tracks, where the climate is " + getClimatePref() + ". " + "Currently has a " + getJockeySkill() + ".\n";
    }
}