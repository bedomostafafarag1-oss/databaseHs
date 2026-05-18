/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

/**
 *
 * @author bedo
 */
public class Nurse extends Person {
    

    private String shift;
    private int yearsOfExperience;

    Nurse(int id, String name, String gender, int age,
          String shift, int yearsOfExperience) {

        super(id, name, gender, age);
        this.shift = shift;
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    
    

   

    @Override
    public void displayinfo() {

        System.out.println("Nurse ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Shift: " + shift);
        System.out.println("Experience: " + yearsOfExperience);
    }
}
    
    
    
    
    
    

