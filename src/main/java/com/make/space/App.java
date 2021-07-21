package com.make.space;



import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args ) throws IOException {

        MeetingRoom meetingRoom = new MeetingRoom();

        Validator validator = new Validator();

        if(args.length > 0){

            String filePath = args[0];
            File file = new File(filePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String readLine;

            Map<String, List<Pair<Integer,Integer>>> roomBookedIntervalsMap = new HashMap<>();

            while ((readLine = bufferedReader.readLine())!= null){

                InputRequest inputRequest = new InputRequest();
                String[] splitArray = readLine.split(" ");
                if (splitArray.length == 3){
                    inputRequest = new InputRequest(splitArray[0],splitArray[1],splitArray[2]);
                } else if (splitArray.length == 4){
                    inputRequest = new InputRequest(splitArray[0],splitArray[1],splitArray[2],splitArray[3]);
                }

                if (validator.isValidRequest(inputRequest)) {
                    meetingRoom.makeSpace(inputRequest,roomBookedIntervalsMap);
                }

            }


        }


    }
}
