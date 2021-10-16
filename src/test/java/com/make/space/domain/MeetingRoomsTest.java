package com.make.space.domain;

import com.make.space.constants.CommonConstants;
import com.make.space.exceptions.AlreadyBookedException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeetingRoomsTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private MeetingRooms meetingRooms = new MeetingRooms();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testCheckStatus() throws AlreadyBookedException {


        Slot slot1 = new Slot("10:00", "12:00");

        meetingRooms.checkStatus(slot1);
        Assert.assertEquals("C-Cave D-Tower G-Mansion", outputStreamCaptor.toString()
                .trim());



    }

    @Test
    public void testReserveRoom() throws AlreadyBookedException {

        Slot slot1 = new Slot("10:00", "12:00");

        meetingRooms.reserveRoom(slot1,3);
        assertTrue(outputStreamCaptor.toString().endsWith("C-Cave" + System.lineSeparator()));

        meetingRooms.checkStatus(slot1);
        Assert.assertEquals("C-Cave\nD-Tower G-Mansion", outputStreamCaptor.toString()
                .trim());


    }

    @Test
    public void testNoVacancy() throws AlreadyBookedException {

        Slot slot1 = new Slot("10:00", "12:00");

        meetingRooms.reserveRoom(slot1,3);
        meetingRooms.reserveRoom(slot1,3);
        meetingRooms.reserveRoom(slot1,3);

        meetingRooms.checkStatus(slot1);

        assertTrue(outputStreamCaptor.toString().endsWith(CommonConstants.NO_VACANT_ROOM + System.lineSeparator()));
    }


}
