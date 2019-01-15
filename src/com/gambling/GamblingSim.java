package com.gambling;

import java.util.Iterator;
import java.util.Arrays;

public class GamblingSim {

    public static void main(String[] args) {

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

            // need races.length for all simulations

            //for (Race race : races) {
            //    System.out.println(race.getRacetrack().getName() + " " + race.getWinner().getName());
            //}   --------> add this to statistics or something..

        } catch (IndexOutOfBoundsException i) {
            System.out.println("Please give a command line argument (number > 0)!");
        } catch (NumberFormatException n) {
            System.out.println("Please give a command line argument (number > 0)!");
        }
        
        
    }
}