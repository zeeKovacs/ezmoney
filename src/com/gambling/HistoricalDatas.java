package com.gambling;

public class HistoricalDatas {
    private String file = "data/history.csv";
    private String temp = "data/temp.csv";

    public void generateData(String[] data) {
        FileHandler fh = new FileHandler();
        fh.append(this.file, data);
    }

    public void generateTemp(String[] data) {
        FileHandler fh = new FileHandler();
        fh.write(this.temp, data);
    }

}