package com.gambling;

import java.util.HashMap;

public class Racetrack {

    private String name;
    private Climate climate;
    private Material material;
    private Length length;
    private Climate[] climates = {WARM, COLD};
    private Material[] materials = {GRASS, SAND, ASPHALT, SLAG};
    private Length[] lengths = {SHORT, MEDIUM, LONG};

    private enum Climate {
        WARM,
        COLD;
    }

    private enum Material {
        GRASS,
        SAND,
        ASPHALT,
        SLAG,
    }

    private enum Length {
        SHORT,
        MEDIUM,
        LONG;
    }

    public Racetrack(String name, int climateNum, int materialNum, int lengthNum) {
        this.name = name;
        this.climate = clmiates[climateNum-1];
        this.material = materials[materialNum-1];
        this.length = lengths[lengthNum-1];
    }

    public Climate getClimate() {
        return this.climate;
    }

    public Material getMaterial() {
        return this.material;
    }

    public Length getLength() {
        return this.length;
    }
}