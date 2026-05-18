/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

/**
 *
 * @author bedo
 */
public class MedicalRecord {
    private String bloodType;
    private String allergies;
    private String diagnosis;

    public MedicalRecord(String bloodType, String allergies, String diagnosis) {
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.diagnosis = diagnosis;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    
    
    
    

    public void setBloodType(String bloodType) {
        if(!bloodType.isEmpty()) {
        this.bloodType = bloodType;
    }
    }

    public void setAllergies(String allergies) {
         if(!allergies.isEmpty()) {
        this.allergies = allergies;
    }
    }

    public void setDiagnosis(String diagnosis) {
       if(!diagnosis.isEmpty()) {
        this.diagnosis = diagnosis;
    }
       
    }
    public void displayRecord() {

    System.out.println("Blood Type: " + bloodType);
    System.out.println("Allergies: " + allergies);
    System.out.println("Diagnosis: " + diagnosis);
}
    
    
    
}
