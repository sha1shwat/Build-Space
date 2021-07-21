package com.make.space;

import com.make.space.constants.CommonConstants;
import com.make.space.enums.BufferTime;
import com.make.space.enums.RoomEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class MeetingRoom {

    private String roomName;
    private int maxRoomCapacity;


    public void makeSpace(InputRequest inputRequest, Map<String, List<Pair<Integer, Integer>>> roomBookedIntervalsMap) {

        List<String> roomsList = RoomEnum.getRoomList();

        Pair<Integer, Integer> interval = new ImmutablePair<>(BufferTime.calculateTimeInMinutes(inputRequest.getStartTime())
                , BufferTime.calculateTimeInMinutes(inputRequest.getEndTime()));

        if (inputRequest.getOperationType().equals(CommonConstants.VACANCY)) {

            List<String> availableRoomList = new ArrayList<>();

            for (String room : roomsList) {

                if (!roomBookedIntervalsMap.containsKey(room) || isNotBooked(roomBookedIntervalsMap, room, interval)) {
                    availableRoomList.add(RoomEnum.valueOf(room).getRoomName());
                }
            }

            if (!availableRoomList.isEmpty()) {
                for (String k : availableRoomList) {
                    System.out.print(k + " ");
                }
                System.out.println("");
            } else {
                System.out.println(CommonConstants.NO_VACANT_ROOM);
            }

        } else {

            for (String room : roomsList) {

                if (RoomEnum.valueOf(room).getMaxRoomCapacity() >= inputRequest.getNumberOfMembers()) {

                    if (!roomBookedIntervalsMap.containsKey(room)) {

                        List<Pair<Integer, Integer>> intervalList = new ArrayList<>();
                        intervalList.add(interval);
                        roomBookedIntervalsMap.put(room, intervalList);

                        System.out.println(RoomEnum.valueOf(room).getRoomName());
                        return;
                    } else if (isNotBooked(roomBookedIntervalsMap, room, interval)) {

                        roomBookedIntervalsMap.get(room).add(interval);
                        Collections.sort(roomBookedIntervalsMap.get(room), getPairSorting2());

                        System.out.println(RoomEnum.valueOf(room).getRoomName());
                        return;
                    }
                }
            }

            System.out.println(CommonConstants.NO_VACANT_ROOM);
            return;
        }


    }

    private boolean isNotBooked(Map<String, List<Pair<Integer, Integer>>> roomBookedIntervalsMap, String room, Pair<Integer, Integer> interval) {


        int i = 0;

        while (i < roomBookedIntervalsMap.get(room).size() && roomBookedIntervalsMap.get(room).get(i).getValue() < interval.getKey()) {

            i++;
        }

        if (i >= roomBookedIntervalsMap.get(room).size() || roomBookedIntervalsMap.get(room).get(i).getKey() >= interval.getValue()
                || roomBookedIntervalsMap.get(room).get(i).getValue() <= interval.getKey()) {

            return true;
        }

        return false;


    }

    private Comparator<Pair<Integer, Integer>> getPairSorting2() {
        return new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        };
    }

}
