/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;
import java.util.ArrayList;
/**
 *
 * @author bedo
 */
public class Department {  
    private String departmentName;
    ArrayList<Doctor> doctors = new ArrayList<>();
    
    Department(String departmentName) {

    this.departmentName = departmentName;
    doctors = new ArrayList<>();
}
    
    
    
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {

        if(!departmentName.isEmpty()) {
            this.departmentName = departmentName;
        }
    }
    
    public void addDoctor(Doctor doctor) {

        if(doctor != null) {

            doctors.add(doctor);
        }
    }

    public void displayDoctors() {

        if(doctors.isEmpty()) {

            System.out.println("No doctors found.");
        }

        else {

            for(Doctor doctor : doctors) {

                doctor.displayinfo();

                System.out.println("----------------");
            }
        }
    }

    public Doctor searchDoctorById(int id) {

        for(Doctor doctor : doctors) {

            if(doctor.getId() == id) {

                return doctor;
            }
        }

        return null;
    }

    public void removeDoctor(int id) {

        Doctor doctor = searchDoctorById(id);

        if(doctor != null) {

            doctors.remove(doctor);

            System.out.println("Doctor removed.");
        }

        else {

            System.out.println("Doctor not found.");
        }
    }
}
    
    
    
    
    
    
    

