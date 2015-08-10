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
public class Departement implements Serializable{
    private String depname;
    
    public Departement(String depname){
        this.depname = depname;
    }
    
    public void setDepartement(String depname){
        this.depname = depname;
    }
    
    public String getDepartement(){
        return depname;
    }
    
    
}
