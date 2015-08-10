/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author Hashim
 */
public class MainWindow extends JFrame{
        JMenuBar mainbar;
        
    public MainWindow(){
        setSize(1366,786);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(Color.GREEN);
        setTitle("University Management System");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        add(new JLabel(new ImageIcon(getClass().getResource("logo.png"))));
        
        
        
        
        


        // Menu
        
       
        MyHandler handler = new MyHandler();
        
        JMenu menu = new JMenu("Select Tools");
       
        Icon iconmenu = new ImageIcon(getClass().getResource("menu.png"));
        menu.setIcon(iconmenu);
        
        
        JMenuItem std = new JMenuItem("Student");
        std.addActionListener(handler);
        menu.add(std);
       
        JMenuItem tch = new JMenuItem("Teacher");
        tch.addActionListener(handler);
        tch.add(new JSeparator());
        menu.add(tch);
        
        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(handler);
        logout.add(new JSeparator());
        menu.add(logout);
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(handler);
        exit.add(new JSeparator());
        menu.add(exit);
        
        JMenu menu1 = new JMenu("Settings");
        Icon iconsetting = new ImageIcon(getClass().getResource("settings.png"));
        menu1.setIcon(iconsetting);
        JMenuItem pass = new JMenuItem("Change Password");
        pass.addActionListener(handler);
        //pass.add(new JSeparator());
        menu1.add(pass);
        
        JMenuItem color = new JMenuItem("Change Background Color");
        color.addActionListener(handler);
        color.add(new JSeparator());
        menu1.add(color);
        
        JMenuItem barcolor = new JMenuItem("Change MenuBar Color");
        barcolor.addActionListener(handler);
        barcolor.add(new JSeparator());
        menu1.add(barcolor);
        
        mainbar = new  JMenuBar();
        mainbar.setBackground(Color.YELLOW);
        mainbar.add(menu);
        mainbar.add(menu1);
        setJMenuBar(mainbar);
        this.addWindowListener(new WindowAdapter() {});
        
    }
    
    public class MyHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           if(e.getActionCommand().equals("Student")){
                  StudentGUI stdgui = new StudentGUI();
                  stdgui.setVisible(true);
           }else if(e.getActionCommand().equals("Teacher")){
                 TeacherGUI tchgui = new TeacherGUI();
                 tchgui.setVisible(true);
           }else if(e.getActionCommand().equals("Logout")){
                 setVisible(false);
                 PasswordGUI passgui = new PasswordGUI();
                 passgui.setVisible(true);
           }else if(e.getActionCommand().equals("Exit")){
               // exit
               System.exit(1);
           }else if(e.getActionCommand().equals("Change Password")){
               PasswordChangeGUI passgui = new PasswordChangeGUI();
               passgui.setVisible(true);
           
           }else if(e.getActionCommand().equals("Change Background Color")){
               Color c;
               c = JColorChooser.showDialog(MainWindow.this,"Choose Background Color",Color.GREEN);
               if(c != null){
               
               MainWindow.this.getContentPane().setBackground(c);
           }
            
        }else if(e.getActionCommand().equals("Change MenuBar Color")){
                Color c;
                c = JColorChooser.showDialog(MainWindow.this,"Choose MenuBar Color",Color.YELLOW);
                if(c != null)
                    mainbar.setBackground(c);
        
                    
    
    }
    
}
    }
    
}
