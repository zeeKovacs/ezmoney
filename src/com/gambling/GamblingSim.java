package com.gambling;

import java.util.Iterator;
import java.util.Arrays;

public class GamblingSim {

    public static void main(String[] args) {

        Statistics stats = new Statistics();
        System.out.println(stats.raceCount());
        System.out.println(Arrays.toString(stats.tracks()));
        System.out.println(stats.trackRecords());
        stats.contenders();
        stats.arrayPrinter();
        System.out.println(Arrays.toString(stats.horseWinCounter("Kincsem Park")));
        System.out.println(stats.winnerWinner("Kincsem Park"));
        /*
        try {
            int timesToRun = Integer.parseInt(args[0]);
            Racetrack[] tracks = Racetrack.createAllRacetracks();
            int tracksLength = tracks.length;
            Race[] races = new Race[timesToRun*tracksLength];

            int i = 0;
            for (int j=0; j < tracksLength; j++) {
                for (int k=0; k < timesToRun; k++) {
                    races[i] = new Race(tracks[j]);
                    i++;
                }
            }

            HistoricalDatas history = new HistoricalDatas();
            String[][] stats = new String[races.length][3];
            for (int l = 0; l < races.length; l++) {
                stats[l][0] = races[l].getTimestamp();
                stats[l][1] = races[l].getRacetrack().getName();
                stats[l][2] = races[l].getWinner().getName();
                history.generateData(stats[l]);
            }
            // need races.length for all simulations

            //for (Race race : races) {
            //    System.out.println(race.getRacetrack().getName() + " " + race.getWinner().getName());
            //}   --------> add this to statistics or something..

        } catch (IndexOutOfBoundsException i) {
            System.out.println("Please give a command line argument (number > 0)!");
        } catch (NumberFormatException n) {
            System.out.println("Please give a command line argument (number > 0)!");
        }*/
        
        
    }
}