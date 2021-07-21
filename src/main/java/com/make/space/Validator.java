package com.make.space;

import com.make.space.constants.CommonConstants;
import com.make.space.enums.BufferTime;
import org.apache.commons.lang3.tuple.Pair;


import java.util.List;

public class Validator {

    public Boolean isValidRequest(InputRequest inputRequest){

        Integer startTime = BufferTime.calculateTimeInMinutes(inputRequest.getStartTime());
        Integer endTime = BufferTime.calculateTimeInMinutes(inputRequest.getEndTime());

        List<Pair<Integer,Integer>> bufferTimeList = BufferTime.getStartEndTimePairList();

        if(startTime%15!=0 || endTime%15!=0 || endTime < startTime){
            System.out.println(CommonConstants.INCORRECT_INPUT);
            return false;
        }

        for (Pair<Integer,Integer> stEnPair : bufferTimeList){

            Integer bufferStartTime = stEnPair.getKey();
            Integer bufferEndTime = stEnPair.getValue();

            if ( bufferEndTime <= startTime || endTime <= bufferStartTime ){
                continue;
            } else {
                System.out.println(CommonConstants.NO_VACANT_ROOM);
                return false;
            }
        }

        return true;
    }
}
