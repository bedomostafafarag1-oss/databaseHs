/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

public class Doctor extends Person {
    private String specialization;
    private double salary;
    private String jobLevel;
    private String deptName; // Links the doctor to a department

    public Doctor(int id, String name, String gender, int age, String specialization, double salary, String jobLevel) {
        super(id, name, gender, age);
        this.specialization = specialization;
        this.salary = salary;
        this.jobLevel = jobLevel;
    }

    // Getters and Setters
    public String getSpecialization() { return specialization; }
    public double getSalary() { return salary; }
    public String getJobLevel() { return jobLevel; }
    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    
  @Override
public void displayinfo() {

    System.out.println("Doctor ID : " + id);
    System.out.println("Name : " + name);
    System.out.println("Age : " + age);
    System.out.println("Gender : " + gender);

    System.out.println("Specialization : " + specialization);

    System.out.println("Job Level : " + jobLevel);

    System.out.println("Salary : " + salary);
}
    
    
    
    
}
