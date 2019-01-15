package com.gambling;

public class HistoricalDatas {

    private String file = "data/history.csv";

    public void generateData(String dataLine) {
        
    }
    /*Contains the simulation data.

    It has the following methods:

    generateData(), writes one simulated round to a file. We recommend the CSV format.
    load() , loads the content of an instance of a HistoricalDatas and returns it.*/
    public HistoricalDatas() {

    }

    public void generateData(Result result) {
        FileHandler fh = new FileHandler();
        fh.Write("data/generatedData.csv", result);
    }
}