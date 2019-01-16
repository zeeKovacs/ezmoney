package com.gambling;

//import java.util.Scanner;

public class GamblingSim {

    public static void main(String[] args) {
        Generator gen = new Generator();        
        Statistics stat = new Statistics();
        Logger logger = new Logger();
        //Scanner sc = new Scanner(System.in);
        
        stat.initMaps();
        gen.generateSimulations(args);

        logger.clearTerminal();
        logger.log("NOTIFICATION", "Ran " + stat.numOfSims("data/temp.csv") + " tests in " +
                   stat.getTimeDiff() + "ms.");
        logger.log("NOTIFICATION", "Total number of simulations in history: " + stat.historyLength()
                   + ".");
        logger.log("SYSTEM MESSAGE", "Pick a horse to view it's statistics!");
        logger.log("LISTING", "Horses\n");
        logger.listArray(stat.getHorses()); 
        logger.listArray(stat.getTracks());
    }
}