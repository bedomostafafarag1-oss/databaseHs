/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

public class Appointment {
    private int appointmentId;
    private int patientId; // Used to link to the Patient table
    private int doctorId;  // Used to link to the Doctor table
    private String date;
    private String time;

    // Constructor for creating a new appointment
    public Appointment(int appointmentId, int patientId, int doctorId, String date, String time) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    // --- Getters and Setters ---

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Useful for displaying a summary of the appointment 
     * without printing every single field manually.
     */
    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + 
               "\nPatient ID: " + patientId + 
               "\nDoctor ID: " + doctorId + 
               "\nDate: " + date + 
               "\nTime: " + time;
    }
}