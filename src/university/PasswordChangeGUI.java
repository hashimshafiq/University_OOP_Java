/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Hashim
 */
public class PasswordChangeGUI extends JFrame{
    JTextField usertext;
    JTextField passtext;
    JTextField cpasstext;
    
    PasswordChangeGUI(){
        super("Change Password");
        setSize(400,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(Color.GREEN);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        setLayout(new FlowLayout());
        Font f = new Font("Times New Roman",Font.BOLD,18);
        MyHandler handler = new MyHandler();
        JLabel l1 = new JLabel("New Username: ");
        l1.setFont(f);
        add(l1);
        
        usertext = new JTextField("",20);
        usertext.setPreferredSize(new Dimension(25,25));
        usertext.setFont(f);
        add(usertext);
        
        JLabel l2 = new JLabel("New Password: ");
        l2.setFont(f);
        add(l2);
        
        passtext = new JTextField("",20);
        passtext.setPreferredSize(new Dimension(25,25));
        passtext.setFont(f);
        add(passtext);
        
        JLabel l3 = new JLabel("Confirm Password: ");
        l3.setFont(f);
        add(l3);
        
        cpasstext = new JTextField("",20);
        cpasstext.setPreferredSize(new Dimension(25,25));
        cpasstext.setFont(f);
        add(cpasstext);
        
        JButton submit = new JButton("Submit",new ImageIcon(getClass().getResource("tick.png")));
        add(submit);
        submit.addActionListener(handler);
        JButton cancel = new JButton("Cancel",new ImageIcon(getClass().getResource("cancel.png")));
        add(cancel);
        cancel.addActionListener(handler);
    
    }
    public class MyHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Submit")){
                if(usertext.getText().isEmpty() == false && passtext.getText().isEmpty() == false && cpasstext.getText().isEmpty()==false){
                    if(passtext.getText().equals(cpasstext.getText())){
                        PasswordWrite passwrite = new PasswordWrite();
                        passwrite.openFile();
                        passwrite.addRecords(usertext.getText(),passtext.getText());
                        passwrite.closeFile();
                        JOptionPane.showMessageDialog(null,"Username and Password Changed Successfully","Information",1);
                    
                    
                    
                    }else{
                        JOptionPane.showMessageDialog(null,"Password does not Match","Error",0);
                    
                    }
                
                
                
                }else{
                    JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",0);
                }
                
            }
            else if(e.getActionCommand().equals("Cancel")){
                setVisible(false);
            
            }
        }
    
    
    }
    
}
