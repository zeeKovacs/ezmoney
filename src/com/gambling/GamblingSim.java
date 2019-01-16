package com.gambling;

import java.util.Scanner;

public class GamblingSim {

    public static void main(String[] args) {

        try {
            Logger logger = new Logger();
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
            String[] tempstats = new String[races.length];
            for (int l = 0; l < races.length; l++) {
                stats[l][0] = races[l].getTimestamp();
                stats[l][1] = races[l].getRacetrack().getName();
                stats[l][2] = races[l].getPlacement();
                history.generateData(stats[l]);
                tempstats[l] = races[l].getTimestamp() + "," + races[l].getRacetrack().getName() + "," + races[l].getWinner().getName();
            }
            history.generateTemp(tempstats);

        } catch (IndexOutOfBoundsException i) {
            System.out.println("Please give a command line argument (number > 0)!");
            System.exit(1);
        } catch (NumberFormatException n) {
            System.out.println("Please give a command line argument (number > 0)!");
            System.exit(2);
        }
        
        Statistics statse = new Statistics();
        Logger logger = new Logger();
        Scanner sc = new Scanner(System.in);
        
        logger.clearTerminal();
        logger.log("NOTIFICATION", "Run " + statse.numOfSims("data/temp.csv") + " tests in " +
                   statse.getTimeDiff() + "ms.");
        logger.log("NOTIFICATION", "Total number of simulations in history: " + statse.historyLength()
                   + ".");
        logger.log("\nSYSTEM MESSAGE", "Pick a horse to view it's statistics!");
        logger.log("", "Horses:\n");
        for (String horse : statse.getHorses()) {
            logger.log("", horse);
        }







        statse.initMaps();
        statse.getPlacementPercentages("Ngong", "Pony");
        System.out.println(statse.winnerWinner("Kincsem Park"));
        System.out.println(statse.numOfSims("data/temp.csv"));
        System.out.println(statse.getTimeDiff());
        
    }
}