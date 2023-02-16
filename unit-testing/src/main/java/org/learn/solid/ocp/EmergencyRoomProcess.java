package org.learn.solid.ocp;

public class EmergencyRoomProcess {

    public static void main(String[] args) {
        HospitalManagement erDirector = new HospitalManagement();

        Employee peggy = new Nurse(1, "Peggy", "emergency", true);
        erDirector.callUpon(peggy);

        Employee suzan = new Nurse(1, "Suzan", "emergency", true);
        erDirector.callUpon(suzan);

    }
}
