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
public class Person implements Serializable{
    private String name;
    private String phone;
    private String gender;
    
    Person(){
    }
    public Person(String name,String phone,String gender){
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getName(){
        return name;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public String getGender(){
        return gender;
    }
    
    
    
    
}
