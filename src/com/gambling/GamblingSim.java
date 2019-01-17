package com.gambling;

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
        logger.log("SYSTEM MESSAGE", "Pick a horse to view it's statistics!");
        logger.log("LISTING", "Horses\n");
        logger.listArray(stat.getHorses()); 
        logger.listArray(stat.getTracks());
    }
}