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
public class Password implements Serializable{
    private String user;
    private String pass;
    
    Password(){
    
    }
    
    Password(String user, String pass){
        this.user = user;
        this.pass = pass;
    }
    
    public void setUser(String user){
        this.user = user;
    }
    
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public String getUser(){
        return user;
    }
    
    public String getPass(){
        return pass;
    }
    
    
}
