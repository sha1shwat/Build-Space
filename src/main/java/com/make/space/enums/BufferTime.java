package com.make.space.enums;



import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public enum BufferTime {


    FIRST("09:00","09:15"),
    SECOND("13:15","13:45"),
    THIRD("18:45","19:00");


    private String startTime;
    private String endTime;

    BufferTime(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public static List<Pair<Integer,Integer>> getStartEndTimePairList(){

        List<Pair<Integer,Integer>> startEndTimePairList = new ArrayList<>();
        for (BufferTime b :BufferTime.values()){

            Integer startTime = calculateTimeInMinutes(b.startTime);
            Integer endTime = calculateTimeInMinutes(b.endTime);
            Pair<Integer,Integer> pair = new ImmutablePair<>(startTime,endTime);
            startEndTimePairList.add(pair);

        }

        return startEndTimePairList;

    }

    public static Integer calculateTimeInMinutes(String time){

        String[] str = time.split(":");

        return Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
    }



}
