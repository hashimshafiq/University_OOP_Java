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
import javax.swing.JTextField;

/**
 *
 * @author Hashim
 */
public class StudentRecordFound extends JFrame{
    JTextField nametext;
    JTextField phonetext;
    
    JTextField gendertext;
    JTextField gpatext;
    JTextField semestertext;
    JTextField sectiontext;
    JTextField deptext;
    StudentRecordFound(String name, String phone,String gender,double gpa,String semester,String section,String dep){
        super("Student Record");
        
        setSize(550,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(Color.GREEN);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        
        MyHandler handler = new MyHandler();
        
        Font f = new Font("Times New Roman",Font.BOLD,18);
        
        
          setLayout(new FlowLayout());
       
       
        JLabel l1 = new JLabel("  Name:         ");
        l1.setFont(f);
        add(l1);
        nametext = new JTextField(name,25);
        nametext.setPreferredSize(new Dimension(25,25));
        nametext.setFont(f);
        nametext.setEditable(false);
        add(nametext);
       
       JLabel l2 = new JLabel("  Phone:        ");
       l2.setFont(f);
       add(l2);
       phonetext = new JTextField(phone,25);
       phonetext.setPreferredSize(new Dimension(25,25));
       phonetext.setFont(f);
       phonetext.setEditable(false);
       add(phonetext);
       
       
       JLabel l3 = new JLabel("  Gender:       ");
       l3.setFont(f);
       add(l3);
       gendertext = new JTextField(gender,25);
       gendertext.setPreferredSize(new Dimension(25,25));
       gendertext.setFont(f);
       gendertext.setEditable(false);
       add(gendertext);
    
       
       
       JLabel l4 = new JLabel("  GPA:          ");
       l4.setFont(f);
       add(l4);
       String gpas = ""+gpa;
       gpatext = new JTextField(gpas,25);
       gpatext.setPreferredSize(new Dimension(25,25));
       gpatext.setFont(f);
       gpatext.setEditable(false);
       add(gpatext);
       
       JLabel l5 = new JLabel("  Semester:    ");
       l5.setFont(f);
       add(l5);
       semestertext = new JTextField(semester,25);
       semestertext.setPreferredSize(new Dimension(25,25));
       semestertext.setFont(f);
       semestertext.setEditable(false);
       add(semestertext);
       
       JLabel l6 = new JLabel("  Section:      ");
       l6.setFont(f);
       add(l6);
       
       sectiontext = new JTextField(section,25);
       sectiontext.setPreferredSize(new Dimension(25,25));
       sectiontext.setFont(f);
       sectiontext.setEditable(false);
       add(sectiontext);
       
       JLabel l7 = new JLabel("Departement:");
       l7.setFont(f);
       add(l7);
       
       deptext = new JTextField(dep,25);
       deptext.setPreferredSize(new Dimension(25,25));
       deptext.setFont(f);
       deptext.setEditable(false);
       add(deptext);
    
       JButton ok = new JButton("OK",new ImageIcon(getClass().getResource("tick.png")));
       ok.addActionListener(handler);
       add(ok);
       
    
    }
    public class MyHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("OK")){
                setVisible(false);
                StudentGUI stdgui = new StudentGUI();
                stdgui.setVisible(true);
            
            }
        }
    
    
    }
}
