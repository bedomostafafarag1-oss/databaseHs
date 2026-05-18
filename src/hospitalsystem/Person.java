/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

/**
 *
 * @author bedo
 */
public abstract class Person {
    
    
    
    protected int id;
    protected String name;
    protected String gender;
    protected int age;

    public Person(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    
    
    
    public void setId(int id) {
        
        if(id > 0) {
            this.id = id;
        }
      
    }

    public void setName(String name) {
         if(!name.isEmpty()) {
            this.name = name;
        }
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("Male")  || gender.equalsIgnoreCase("Female")) 

            this.gender = gender;
    
    
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
       
    }
    
    }
    

    public int getId() {
        
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
    
    abstract void displayinfo();

    
    
}
