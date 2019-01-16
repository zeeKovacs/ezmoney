package com.gambling;

import java.util.Random;

public class Utility {

    public static Horse[] addToArray(Horse[] list, Horse toAdd) {
        Horse[] tempList = new Horse[list.length+1];
        System.arraycopy(list, 0, tempList, 0, tempList.length-1);
        tempList[list.length] = toAdd;
        list = tempList;
        return list;
    }

    public static String[] addToArray(String[] list, String toAdd) {
        String[] tempList = new String[list.length+1];
        System.arraycopy(list, 0, tempList, 0, tempList.length-1);
        tempList[list.length] = toAdd;
        list = tempList;
        return list;
    }

    public static Horse[] removeFromArray(Horse[] list, Horse toRemove) {
        for (int i=0; i < list.length; i++) {
            if (list[i].equals(toRemove)) {
                Horse tempList[] = new Horse[list.length-1];
                System.arraycopy(list, 0, tempList, 0, i);
                System.arraycopy(list, i+1, tempList, i, list.length-i-1);
                return tempList;
            }
        }
        return list;
    }

    public static String[] removeFromArray(String[] list, String toRemove) {
        for (int i=0; i < list.length; i++) {
            if (list[i].equals(toRemove)) {
                String tempList[] = new String[list.length-1];
                System.arraycopy(list, 0, tempList, 0, i);
                System.arraycopy(list, i+1, tempList, i, list.length-i-1);
                return tempList;
            }
        }
        return list;
    }
} 