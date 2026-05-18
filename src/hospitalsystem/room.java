/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

/**
 *
 * @author bedo
 */
public class room {
      private int roomNumber;
    private String type;
    private boolean isAvailable;
    private Patient patient;

    room(int roomNumber, String type) {

        this.roomNumber = roomNumber;
        this.type = type;
        this.isAvailable = true;
        this.patient = null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void assignPatient(Patient p) {

        if(isAvailable && p != null) {

            this.patient = p;
            this.isAvailable = false;
        }
    }

    public void dischargePatient() {

        this.patient = null;
        this.isAvailable = true;
    }

    public void displayRoom() {

        System.out.println("Room Number: " + roomNumber);
        System.out.println("Type: " + type);
        System.out.println("Available: " + isAvailable);

        if(patient != null) {
            System.out.println("Assigned Patient:");
            patient.displayinfo();
        }
    
}
}
