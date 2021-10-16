package com.make.space.handler;

import com.make.space.domain.MeetingRooms;
import com.make.space.domain.Slot;
import com.make.space.exceptions.AlreadyBookedException;

public class MakeSpaceCommandHandler {

    private MeetingRooms meetingRooms;

    public MakeSpaceCommandHandler(){
        meetingRooms = new MeetingRooms();
    }

    public void bookSpace(String[] params) throws AlreadyBookedException {

        try {

            Slot slot = new Slot(params[0], params[1]);
            meetingRooms.reserveRoom(slot, Integer.parseInt(params[2]));
        }catch (AlreadyBookedException e){
            throw e;
        }

    }

    public void findStatus(String[] params) throws AlreadyBookedException {

        try {

            Slot slot = new Slot(params[0], params[1]);
            meetingRooms.checkStatus(slot);
        }catch (AlreadyBookedException ex){
            throw ex;
        }

    }
}
