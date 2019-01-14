package com.gambling;

import java.io.File;
import java.util.Random;

public class GamblingSim {

    public static void main(String[] args) {

        FileHandler fh = new FileHandler();
        String[][] trackDatas = fh.Read("data/racetracks.csv");
        Random random = new Random();
        int randomTrackNUmber = random.nextInt(trackDatas[0].length-1);
        String[] trackData = trackDatas[randomTrackNUmber];
        Racetrack racetrack = new Racetrack(trackData[0], Integer.parseInt(trackData[1]),
                                                         Integer.parseInt(trackData[2]),
                                                         Integer.parseInt(trackData[3]));


        String[][] horseData = fh.Read("data/horses.csv");
        Horse[] horses = new Horse[fh.fileLines("data/horses.csv")];
        for (int i = 0; i < horseData.length; i++) {
            horses[i] = new Horse(horseData[i]);
        } 

        for (Horse horse : horses) {
            System.out.println(horse.getName());
        }

        /*try {
            int numberOfRounds = Integer.parseInt(args[0]);
            for (int i=0; i < numberOfRounds; i++) {

            }
        } catch (NullPointerException n) {
            System.out.println("Imperium rectae rationis inire velit!");
        }

        /*Main : Starts the application. Able to configure the round of the 
        //simulations to run by taking an argument from the command line. It has the following methods:

        // public generateHistoricalDatas(int round)
            //returns a HistoricalDatas instance that contains the simulation result

        //main(String[] args) , the main entry point of the application.*/

            int horseChance = 0;
            int[] horseStats = new int[8];
            for (int i = 0; i < 8; i++) {
                horseChance += horses[i].getTerrains().get(racetrack.getMaterial());
                if (horses[i].getClimates() == racetrack.getClimate()) {
                    horseChance += 2;
                } else {
                    horseChance += 1;
                }
                if (horses[i].getLength() == racetrack.getLength()) {
                    horseChance += 2;
                } else {
                    horseChance += 2;
                }
                horseChance += horses[i].getJockey();
                horseStats[i] = horseChance * 100;
                horseChance = 0;        
            } 
    for (int value : horseStats) {
        System.out.println(value);
    }
}
}