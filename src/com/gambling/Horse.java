package com.gambling;

import java.util.Map;

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
}