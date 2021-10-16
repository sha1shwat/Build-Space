package com.make.space.domain;

import com.make.space.constants.CommonConstants;
import com.make.space.enums.BufferTime;
import com.make.space.enums.RoomEnum;
import com.make.space.exceptions.AlreadyBookedException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;


public class MeetingRooms {


    private Map<String, List<Pair<Integer, Integer>>> roomBookedIntervalsMap;

    public MeetingRooms() {
        this.roomBookedIntervalsMap = new HashMap<>();
    }

    public void checkStatus(Slot slot) throws AlreadyBookedException {

        List<String> roomsList = RoomEnum.getRoomList();

        Pair<Integer, Integer> interval = new ImmutablePair<>(BufferTime.calculateTimeInMinutes(slot.getStartingTime())
                , BufferTime.calculateTimeInMinutes(slot.getEndingTime()));

        List<String> availableRoomList = new ArrayList<>();

        for (String room : roomsList) {

            if (!roomBookedIntervalsMap.containsKey(room) || isNotBooked(room, interval)) {
                availableRoomList.add(RoomEnum.valueOf(room).getRoomName());
            }
        }

        if (!availableRoomList.isEmpty()) {
            for (String k : availableRoomList) {
                System.out.print(k + " ");
            }
            System.out.println("");
        } else {
            throw new AlreadyBookedException(CommonConstants.NO_VACANT_ROOM);
        }


    }

    public void reserveRoom(Slot slot, Integer numberOfMembers) throws AlreadyBookedException {

        List<String> roomsList = RoomEnum.getRoomList();
        Pair<Integer, Integer> interval = new ImmutablePair<>(BufferTime.calculateTimeInMinutes(slot.getStartingTime())
                , BufferTime.calculateTimeInMinutes(slot.getEndingTime()));

        for (String room : roomsList) {

            if (RoomEnum.valueOf(room).getMaxRoomCapacity() >= numberOfMembers) {

                if (!roomBookedIntervalsMap.containsKey(room)) {

                    List<Pair<Integer, Integer>> intervalList = new ArrayList<>();
                    intervalList.add(interval);
                    roomBookedIntervalsMap.put(room, intervalList);

                    System.out.println(RoomEnum.valueOf(room).getRoomName());
                    return;
                } else if (isNotBooked(room, interval)) {

                    roomBookedIntervalsMap.get(room).add(interval);
                    Collections.sort(roomBookedIntervalsMap.get(room), getPairSorting2());

                    System.out.println(RoomEnum.valueOf(room).getRoomName());
                    return;
                }
            }
        }

        throw new AlreadyBookedException(CommonConstants.NO_VACANT_ROOM);

    }

    private boolean isNotBooked(String room, Pair<Integer, Integer> interval) {


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
