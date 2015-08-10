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
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Hashim
 */
public class PasswordGUI extends JFrame{
     JTextField usertext;
     JPasswordField passtext;
    PasswordGUI(){
        super("Login University Management System");
        setSize(450,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        getContentPane().setBackground(Color.GREEN);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        Font f = new Font("Times New Roman",Font.BOLD,18);
        setLayout(new FlowLayout());
        JLabel l1 = new JLabel("Username:");
        l1.setFont(f);
        add(l1);
        
        usertext = new JTextField("",25);
        usertext.setFont(f);
        usertext.setPreferredSize(new Dimension(25,25));
        add(usertext);
        
        JLabel l2 = new JLabel("Password: ");
        l2.setFont(f);
        add(l2);
        passtext = new JPasswordField("",25);
        passtext.setFont(f);
        passtext.setPreferredSize(new Dimension(25,25));
        add(passtext);
        MyHandler handler = new MyHandler();
        JButton submit = new JButton("Submit",new ImageIcon(getClass().getResource("tick.png")));
        submit.addActionListener(handler);
        add(submit);
        JButton cancel = new JButton("Cancel",new ImageIcon(getClass().getResource("cancel.png")));
        cancel.addActionListener(handler);
        add(cancel);
    }
    public class MyHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Submit")){
                if(usertext.getText().isEmpty() == false && passtext.getPassword().length != 0){
                    PasswordRead passread = new PasswordRead();
                    passread.openFile();
                    String user = usertext.getText();
                    String pass = passtext.getText();
                    boolean answer = passread.readRecords(user, pass);
                    
                    if(answer){
                        MainWindow mainwindow = new MainWindow();
                        mainwindow.setVisible(true);
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Usename or Password Incorrect ", "Error", 0);
                    
                    }
                    
                
                passread.closeFile();
                }
            
            }else if(e.getActionCommand().equals("Cancel")){
                System.exit(1);
            }
        }
    
    
    }
    
}
