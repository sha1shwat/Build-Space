package com.make.space.domain;

public class Slot {

    private String startingTime;
    private String endingTime;

    public Slot(String startingTime, String endingTime) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }
}
