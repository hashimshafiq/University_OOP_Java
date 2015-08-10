/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import java.io.Serializable;

/**
 *
 * @author Hashim
 */
public class Student extends Person implements Serializable{
    private double gpa;
    private String semester;
    private String section;
    private Departement dep;
    public Student(){
        super();
    }
    public Student(String name, String phone, String gender,double gpa,String semester,String section, Departement dep) {
        super(name, phone, gender);
        this.gpa = gpa;
        this.semester = semester;
        this.section = section;
        this.dep = dep;
    }
    
    public void setGPA(double gpa){
        this.gpa = gpa;
    }
    
    public void setSemester(String semester){
        this.semester = semester;
    }
    
    public void setSection(String section){
        this.section = section;
    }
    
    public void setDepartemnt(Departement dep){
        this.dep = dep;
    }
    
    public double getGPA(){
        return gpa;
    }
    
    public String getSemester(){
        return semester;
    }
    
    public String getSection(){
        return section;
    }
    
    public Departement getDepartement(){
        return dep;
    }
    
    
}
