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
public class TeacherRead {
    private ObjectInputStream input;
    
    public void openFile(){
        try {
            input = new ObjectInputStream(new FileInputStream("faculty.ser"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Opening File", "Error",0);
        }
    }
    
    public boolean readRecord(String search){
        boolean ans = false;
         Faculty fct;
        try{
            while(true){
                fct = (Faculty) input.readObject();
                if(fct.getName().equalsIgnoreCase(search)){
                    TeacherRecordFound trf = new TeacherRecordFound(fct.getName(),fct.getPhone(),fct.getGender(),fct.getDesignation(),fct.getSalary(),fct.getDeaprtement().getDepartement());
                    trf.setVisible(true);
                    ans = true;
                    break;
                }
            
            }
        }catch(EOFException e){
            ans = false;
            
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Unable to create object","Error",0);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Unable to read file","Error",0);
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
