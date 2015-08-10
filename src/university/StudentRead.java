/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashim
 */
public class StudentRead {
    private ObjectInputStream input;
    
    public void openFile(){
        try {
            input = new ObjectInputStream(new FileInputStream("students.ser"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Opening File", "Error",1);
        }
    }
    
    public boolean readRecord(String search){
        boolean ans = false;
        Student std;
        
        try{
            while(true){
                std = (Student) input.readObject();
                if(std.getName().equalsIgnoreCase(search)){
                    StudentRecordFound srf = new StudentRecordFound(std.getName(),std.getPhone(),std.getGender(),std.getGPA(),std.getSemester(),std.getSection(),std.getDepartement().getDepartement());
                    srf.setVisible(true);
                    ans = true;
                    break;
                }
                
            }
            
        }catch(EOFException e){
            ans = false;
            
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Unable to create object","Error",1);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Unable to read file","Error",1);
        }
        return ans;
    }
    
    public boolean readRecord(String search,String depname){
        boolean ans = false;
        Student std;
        try{
            while(true){
                std = (Student) input.readObject();
                if(std.getName().equalsIgnoreCase(search) && std.getDepartement().getDepartement().equalsIgnoreCase(depname)){
                    StudentRecordFound srf = new StudentRecordFound(std.getName(),std.getPhone(),std.getGender(),std.getGPA(),std.getSemester(),std.getSection(),std.getDepartement().getDepartement());
                    srf.setVisible(true);
                    ans = true;
                    break;
                }
            
            }
        }catch(EOFException e){
            ans = false;
            
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Unable to create object","Error",1);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Unable to read file","Error",1);
        }
        return ans;
    }
    
    public void closeFile(){
        try{
            if(input!=null)
                input.close();
            
        }catch(IOException e){
           JOptionPane.showMessageDialog(null,"Error Closing File","Error",0);
        }
    }
    
}
