package com.gambling;

public class Result {

    private Statistics stat;
    
    //Stores the result of the simulation. It has getters and setters to read and write its members (data class).
    //A Result contains (in it, as a field) a Statistics instance.

    public Statistics getStatistics() {
        return this.stat;
    }

    public void setStatistics() {
    }
}