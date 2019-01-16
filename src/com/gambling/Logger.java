package com.gambling;

import java.time.Instant;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Logger {

    /* It writes information to the console. Only this class can contain calls to System.out.println().

    It has the following method:

    log(String type, String message) it writes to the console in a formatted way. E.g. TimeStamp Type Message
    type should be something like "INFO" or "ERROR" depending on what you want to display. */
    public Logger() {

    }

    public void log(String type, String message) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(Race.DATE_FORMAT_NOW);
        sdf.format(calendar.getTime());
        System.out.println(sdf + " " + type + " " + message);
    }

    /*public void arrayPrinter() {
        for (double[] winners : statRecords().values()) {
            System.out.println(Arrays.toString(winners));
            }
    }


    public void statPrint() {
        for (String[] line : statData) {
            System.out.println(Arrays.toString(line));
        }
    }*/

}