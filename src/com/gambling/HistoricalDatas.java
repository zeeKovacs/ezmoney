package com.gambling;

public class HistoricalDatas {

    /*Contains the simulation data.

    It has the following methods:

    generateData(), writes one simulated round to a file. We recommend the CSV format.
    load() , loads the content of an instance of a HistoricalDatas and returns it.*/

    private String file = "data/history.csv";

    public HistoricalDatas() {
        
    }

    public void generateData(String[] data) {
        FileHandler fh = new FileHandler();
        fh.Write(this.file, data);
    }

}