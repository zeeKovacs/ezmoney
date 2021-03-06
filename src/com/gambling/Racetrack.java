package com.gambling;

import java.util.Map;

public class Racetrack {

    private String name;
    private int climate;
    private int material;
    private int length;
    
    private Map<Integer, String> climates = Map.of(1, "warm", 2, "cold");
    private Map<Integer, String> materials = Map.of(1, "sand", 2, "grass", 3, "slag", 4, "asphalt");
    private Map<Integer, String> lengths = Map.of(1, "short", 2, "medium", 3, "long");

    public Racetrack(String name, int material, int climate, int length) {
       this.name = name;
       this.climate = climate;
       this.material = material;
       this.length = length;
    }

    public static Racetrack[] createAllRacetracks() {
        FileHandler fh = new FileHandler();
        String[][] trackDatas = fh.read("data/racetracks.csv");
        Racetrack[] tracks = new Racetrack[trackDatas.length];

        for (int i=0; i < trackDatas.length; i++) {
            tracks[i] = new Racetrack(trackDatas[i][0], Integer.parseInt(trackDatas[i][1]),
                                      Integer.parseInt(trackDatas[i][2]), Integer.parseInt(trackDatas[i][3]));
        }
        return tracks;
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

    @Override
    public String toString() {
        return this.name + " racetrack is a(n) " + materials.get(this.material) + " covered " + lengths.get(this.length) +
               " track where the weather is usually " + climates.get(this.climate) + ".\n";
    }
}