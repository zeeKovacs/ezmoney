package com.gambling;

import java.util.HashMap;
import java.util.Map;

public class Racetrack {

    private String name;
    private int climate;
    private int material;
    private int length;
   
    private Map<Integer, String> climates = Map.of(1, "warm", 2, "cold");
    private Map<Integer, String> materials = Map.of(1, "sand", 2, "grass", 3, "slag", 4, "asphalt");
    private Map<Integer, String> lengths = Map.of(1, "short", 2, "medium", 3, "long");

    public Racetrack(String name, int climate, int material, int length) {
       this.name = name;
       this.climate = climate;
       this.material = material;
       this.length = length;
    }

    public String getName() {
        return this.name;
    }

    public int getClimate() {
        return this.climate;
    }

    public int getMaterial() {
        return this.material;
    }

    public int getLength() {
        return this.length;
    }
}