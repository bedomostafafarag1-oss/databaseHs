/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

/**
 *
 * @author bedo
 */
public class Patient extends Person {       
    
     private String disease;
    private MedicalRecord medicalRecord;
    
  Patient(int id, String name, String gender, int age, String disease, MedicalRecord medicalRecord) {
        super(id, name, gender, age);
        this.disease = disease;
        this.medicalRecord = medicalRecord;
}
  
  
   public String getDisease() {
        return disease;}

    public void setDisease(String disease) {
        if(!disease.isEmpty()) 
            this.disease = disease;}                
    
    

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        if(medicalRecord != null) 
            this.medicalRecord = medicalRecord;}
            
    
    
    @Override
    public void displayinfo() {

        System.out.println("Patient ID: " + id);
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Gender : " + gender);
        System.out.println("Disease : " + disease);

        medicalRecord.displayRecord();
    }
  
}
