/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashim
 */
public class StudentWrite {
    private ObjectOutputStream output;
    public static int counter=0;
    public void openFile(){
        try{
            output = new ObjectOutputStream(new FileOutputStream("students.ser"));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error Creating File","Error",0);
        }
    }
    
    public void addRecords(String name,String phone,String gender,double gpa,String semester,String section, Departement dep){
        try{
            
            Student std = new Student(name,phone,gender,gpa,semester,section,dep);
        output.writeObject(std);
        counter++;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Cannot Write to File","Error",0);
        }catch(NoSuchElementException e){
            JOptionPane.showMessageDialog(null,"Invalid Input","Error",0);
        }
     }
    
    public void closeFile(){
    try{
        if(output!=null)
            output.close();
    }catch(IOException e){
        JOptionPane.showMessageDialog(null,"Error closing File","Error",0);
    }
    
    }
    
    
    
    
}
