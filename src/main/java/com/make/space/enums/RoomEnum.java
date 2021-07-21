package com.make.space.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum RoomEnum {

    CAVE("C-Cave",3),
    TOWER("D-Tower",7),
    MANSION("G-Mansion",20);

    private String roomName;
    private int maxRoomCapacity;

     RoomEnum(String roomName, int maxRoomCapacity) {
        this.roomName = roomName;
        this.maxRoomCapacity = maxRoomCapacity;
    }

    public static List<String> getRoomList(){

         List<String> roomList = new ArrayList<>();

         for (RoomEnum k : RoomEnum.values()){

             roomList.add(k.name());
         }

         return roomList;
    }


}
