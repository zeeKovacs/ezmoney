package com.gambling;

public class Generator {

    public void generateSimulations(String[] args) {
        try {
            HistoricalDatas history = new HistoricalDatas();
            Horse[] horses = Horse.createHorses();
            Racetrack[] tracks = Racetrack.createAllRacetracks();
            int timesToRun = Integer.parseInt(args[0]);
            int tracksLength = tracks.length;
            Race[] races = new Race[timesToRun*tracksLength];
            String[][] stats = new String[races.length][3];
            String[] tempStats = new String[races.length];

            int i = 0;
            for (int j=0; j < tracksLength; j++) {
                for (int k=0; k < timesToRun; k++) {
                    races[i] = new Race(tracks[j], horses);
                    i++;
                }
            }

            for (int l = 0; l < races.length; l++) {
                stats[l][0] = races[l].getTimestamp();
                stats[l][1] = races[l].getRacetrack().getName();
                stats[l][2] = races[l].getPlacements();
                history.generateData(stats[l]);
                tempStats[l] = races[l].getTimestamp() + "," + races[l].getRacetrack().getName() + "," + races[l].getPlacements();
            }
            history.generateTemp(tempStats);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please give a command line argument (number > 0)!");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Please give a command line argument (number > 0)!");
            System.exit(2);
        }
    }
}