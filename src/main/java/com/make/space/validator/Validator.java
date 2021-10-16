package com.make.space.validator;

import com.make.space.constants.CommonConstants;
import com.make.space.enums.BufferTime;
import com.make.space.exceptions.AlreadyBookedException;
import com.make.space.exceptions.InvalidParameterExceptions;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class Validator {

    public void validateRequest(String sT, String eT) throws InvalidParameterExceptions, AlreadyBookedException {

        Integer startTime = BufferTime.calculateTimeInMinutes(sT);
        Integer endTime = BufferTime.calculateTimeInMinutes(eT);

        List<Pair<Integer,Integer>> bufferTimeList = BufferTime.getStartEndTimePairList();

        if(startTime%15!=0 || endTime%15!=0 || endTime < startTime){
            throw new InvalidParameterExceptions(CommonConstants.INCORRECT_INPUT);

        }

        for (Pair<Integer,Integer> stEnPair : bufferTimeList){

            Integer bufferStartTime = stEnPair.getKey();
            Integer bufferEndTime = stEnPair.getValue();

            if ( bufferEndTime <= startTime || endTime <= bufferStartTime ){
                continue;
            } else {
                throw new AlreadyBookedException(CommonConstants.NO_VACANT_ROOM);

            }
        }

    }
}
