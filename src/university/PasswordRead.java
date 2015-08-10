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
public class PasswordRead {
    private ObjectInputStream input;
    
    public void openFile(){
        try {
            input = new ObjectInputStream(new FileInputStream("pass.ser"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error Reading File", "Error", 0);
        }
    }
    public boolean readRecords(String user,String pass){
        boolean ans = false;
        Password p;
        try{
            while(true){
                p = (Password) input.readObject();
                if(p.getUser().equals(user) && p.getPass().equals(pass)){
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
