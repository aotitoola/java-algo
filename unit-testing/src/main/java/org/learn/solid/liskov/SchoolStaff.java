package org.learn.solid.liskov;

public class SchoolStaff {

    private void makeAnnouncements(){
        System.out.println("made announcements..");
    }

    private void takeAttendance(){
        System.out.println("took attendance..");
    }

    private void collectPaperWork(){
        System.out.println("collected paperwork..");
    }

    private void conductHallwayDuties(){
        System.out.println("conducted hallway duties..");
    }

    private void performOtherResponsibilities(){
        makeAnnouncements();
        takeAttendance();
        collectPaperWork();
        conductHallwayDuties();
        performOtherResponsibilities();
    }

}
