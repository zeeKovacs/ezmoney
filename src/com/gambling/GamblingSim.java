package com.gambling;

import java.util.Arrays;
import java.util.Scanner;

public class GamblingSim {

    public static void main(String[] args) throws Exception {
        Generator gen = new Generator();  
        gen.generateSimulations(args); 
        Statistics stat = new Statistics();
        Logger logger = new Logger();
        
        stat.initMaps();

        logger.clearTerminal();
        logger.log("NOTIFICATION", "Ran " + stat.numOfSims("data/temp.csv") + " tests in " +
                   stat.getTimeDiff() + "ms.");
        logger.log("NOTIFICATION", "Total number of simulations in history: " + stat.historyLength()
                   + ".");
        logger.log("SYSTEM MESSAGE", "NEXT RACE WILL TAKE PLACE ON:\n");
        Race randomRace = new Race();

        String[] horses = stat.getHorses();
        double[] winChances = stat.statRecords.get(randomRace.getRacetrack().getName());

        logger.log("TRACK", randomRace.getRacetrack().toString());
        
        String betPercent = "";
        for (int i = 0; i < horses.length; i ++) {
            Arrays.sort(horses);
            if (stat.winnerOnTrack(randomRace.getRacetrack().getName()).equals(horses[i])) {
                betPercent += winChances[i] + "%";
            }
        }

        String betOn = stat.winnerOnTrack(randomRace.getRacetrack().getName()) + " - Chance to win: " + betPercent;  ;
        logger.log("BET ON", betOn);

        Scanner sc = new Scanner(System.in);
        while (true) {
            logger.log("SYSTEM MESSAGE", "PRESS (1) TO GET DETAILED STATISTICS");
            logger.log("SYSTEM MESSAGE", "PRESS (2) TO CHECK WINNER");
            logger.log("SYSTEM MESSAGE", "PRESS (3) TO EXIT");
            switch (sc.nextLine()) {
                case "1":
                    logger.log("DETAILED STATISTICS", "\n");
                    int i = 1;
                    for (String horse : stat.getHorses()) {
                        logger.log(horse, "");
                        logger.listDoubleArray(stat.getPlacementPercentages(randomRace.getRacetrack().getName(), horse));
                        i ++;
                    }
                    continue;
                case "2":
                    logger.log("WINNER OF ACTUAL RACE", randomRace.getWinner().getName());
                    continue;
                case "3":
                    System.exit(3);
                default:
                    continue;
            }
        
        }


        
        
    }
}