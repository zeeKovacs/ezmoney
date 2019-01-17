package com.gambling;

//import java.util.Calendar;
//import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

public class Logger {

    public void log(String type, String message) {
        // Calendar calendar = Calendar.getInstance();
        // SimpleDateFormat sdf = new SimpleDateFormat(Race.DATE_FORMAT_NOW);
        // sdf.format(calendar.getTime());
        System.out.println(" -> " + type + ": " + message);
    }

    public void clearTerminal() {
        System.out.println("\033[H\033[2J");
    }

    public void listArray(String[] array) {
        for (int i = 0; i < array.length; i ++) {
            System.out.println(" -> " + Integer.toString(i+1) + ": " + array[i]);
        }
        System.out.println();
    }

    public void listDoubleArray(String[] array, double[] nums) {
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);
        for (int i = 0; i < array.length; i ++) {
            System.out.println(" -> " + Integer.toString(i+1) + ": " + array[i] + " -> " + format.format(nums[i]) + "%");
        }
        System.out.println();
    }
}