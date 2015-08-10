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
public class Faculty extends Person implements Serializable{
    
    private String designation;
    private String salary;
    private Departement dep;
    
    public Faculty(String name, String phone, String gender, String designation, String salary,Departement dep) {
        super(name, phone, gender);
        this.designation = designation;
        this.salary = salary;
        this.dep = dep;
    }
    
    public void setDesignation(String designation){
        this.designation = designation;
    }
    
    public void setSalary(String salary){
        this.salary = salary;
    }
    
    public void setDepartement(Departement dep){
        this.dep = dep;
    }
    
    public String getDesignation(){
        return designation;
    }
    
    public String getSalary(){
        return salary;
    }
    
    public Departement getDeaprtement(){
        return dep;
    }
    
    
}
