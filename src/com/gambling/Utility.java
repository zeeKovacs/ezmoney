package com.gambling;

import java.util.Random;

public class Utility {

    public static Item[] addToArray(Item[] list, Item toAdd) {
        Item[] tempList = new Item[list.length+1];
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

    public static Item[] removeFromArray(Item[] list, Item toRemove) {
        for (int i=0; i < list.length; i++) {
            if (list[i].equals(toRemove)) {
                Item tempList[] = new Item[list.length-1];
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