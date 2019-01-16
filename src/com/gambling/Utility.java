package com.gambling;

import java.util.Random;

public class Utility {

    public static T[] addToArray(T[] list, T toAdd) {
        T[] tempList = (T[])new Object[list.length+1];
        System.arraycopy(list, 0, tempList, 0, tempList.length-1);
        tempList[list.length] = toAdd;
        list = tempList;
        return list;
    }

    public static <T> T[] removeFromArray(T[] list, T toRemove) {
        for (int i=0; i < list.length; i++) {
            if (list[i].equals(toRemove)) {
                T tempList[] = (T[])new Object[list.length-1];
                System.arraycopy(list, 0, tempList, 0, i);
                System.arraycopy(list, i+1, tempList, i, list.length-i-1);
                return tempList;
            }
        }
        return list;
    }
} 