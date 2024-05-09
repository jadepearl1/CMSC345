//Unit test Java Source code for testing the Constructor & getters methods of the Reservation Class
//Used from the example given by UMGC in the assignment 3 instructions and edited by Jade Pearl
//for further program testing.
//CMSC 345 Assignment 3
//Last updated: 2/20/2023

import java.util.*;
import java.lang.module.ResolutionException;
import java.text.SimpleDateFormat;

public class TestReservation {
    private static String datePattern = "MMM dd, yyyy";
    private static SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

    public static void main(String argv[]) throws Exception {
        testContructorAndGetters();
        System.out.println();
        testSettersAndGetters();
        System.out.println();
        testNumofDays();
        System.out.println();
        testBillAmount();
    }
    public static void testContructorAndGetters() {
        System.out.println();
        System.out.println("Testing Constructor and Getters");
        System.out.println("--------------------------------");
        Reservation r = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        Reservation r2 = new Reservation(7, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        Assert.assertNotEqualsUUID(r.getReservationID(), r2.getReservationID());
        Assert.assertEqualsDate(r.getReservationDate(), new Date());
        Assert.assertEqualsInt(r.getGuestID(), r2.getGuestID());
        Assert.assertEqualsString(r.getRoomType(), r2.getRoomType());
        Assert.assertNotEqualsString(r.getReservationStartDate(), r2.getReservationStartDate());
        Assert.assertEqualsString(r.getReservationEndDate(), r2.getReservationEndDate());
    }
    public static void testSettersAndGetters() {
        System.out.println();
        System.out.println("Testing Setters and Getters");
        System.out.println("--------------------------------");
        Reservation r = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
        //change the values with the setters for testing
        r.setGuestID(3);
        r.setRoom("Normal Room");
        r.setReservationStartDate("Feb 29, 2024");
        r.setReservationEndDate("Mar 7, 2024");
        //Make a separate reservation for comparison. I used the constructor for convenience
        Reservation r2 = new Reservation(2, "RoomWView", "Feb 29, 2024", "Mar 3, 2024");
        Assert.assertNotEqualsUUID(r.getReservationID(), r2.getReservationID());
        Assert.assertEqualsDate(r.getReservationDate(), new Date());
        Assert.assertNotEqualsInt(r.getGuestID(), r2.getGuestID());
        Assert.assertNotEqualsString(r.getRoomType(), r2.getRoomType());
        Assert.assertEqualsString(r.getReservationStartDate(), r2.getReservationStartDate());
        Assert.assertNotEqualsString(r.getReservationEndDate(), r2.getReservationEndDate());
    }
    public static void testNumofDays() {
        System.out.println();
        System.out.println("Testing calculateReservationNumOfDays()");
        System.out.println("--------------------------------");
        Reservation r = new Reservation(1, "RoomWView", "Feb 29, 2024", "Mar 7, 2024");
        Reservation r2 = new Reservation(2, "RoomWBath", "Feb 29, 2024", "Mar 3, 2024");
        //make variables to store the number of days in the reservations.
        try {
            Assert.assertNotEqualsLong(r.calculateReversationNumberOfDays(), r2.calculateReversationNumberOfDays());
            Assert.assertEqualsLong(r.calculateReversationNumberOfDays(), r.calculateReversationNumberOfDays());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void testBillAmount() {
        System.out.println();
        System.out.println("Testing calculateReservationNumOfDays()");
        System.out.println("--------------------------------");
        Reservation r = new Reservation(1, "RoomWView", "Feb 29, 2024", "Mar 7, 2024");
        Reservation r2 = new Reservation(2, "RoomWBath", "Feb 29, 2024", "Mar 3, 2024");
        Reservation r3 = new Reservation(3, "NormalRoom", "Feb 29, 2024", "Mar 7, 2024");
        //make variables to store the number of days in the reservations.
        try {
            Assert.assertNotEqualsDouble(r.calculateReservationBillAmount(), r2.calculateReservationBillAmount());
            Assert.assertEqualsDouble(r.calculateReservationBillAmount(), r.calculateReservationBillAmount());
            Assert.assertNotEqualsDouble(r.calculateReservationBillAmount(), r3.calculateReservationBillAmount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
