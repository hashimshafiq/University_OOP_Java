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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Hashim
 */
public class AddStudentGUI extends JFrame{
    JTextField nametext;
    JTextField phonetext;
    
    JTextField gendertext;
    JTextField gpatext;
    JTextField semestertext;
    JTextField sectiontext;
    JTextField deptext;
    JRadioButton maleradio;
    JRadioButton femaleradio;
    String genderans;
    public AddStudentGUI(){
        super("Adding Student Record");
        setSize(550,350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(Color.GREEN);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        
        MyHandler handler = new MyHandler();
        MyItemHandler itemhandler = new MyItemHandler();
        Font f = new Font("Times New Roman",Font.BOLD,18);
        
        
          setLayout(new FlowLayout());
       
       
        JLabel l1 = new JLabel("  Name:         ");
        l1.setFont(f);
        add(l1);
        nametext = new JTextField("",25);
        nametext.setPreferredSize(new Dimension(25,25));
        nametext.setFont(f);
        add(nametext);
       
       JLabel l2 = new JLabel("  Phone:        ");
       l2.setFont(f);
       add(l2);
       phonetext = new JTextField("",25);
       phonetext.setPreferredSize(new Dimension(25,25));
       phonetext.setFont(f);
       add(phonetext);
       
       JPanel radiopanel = new JPanel();
       radiopanel.setBackground(Color.green);
       radiopanel.setLayout(new FlowLayout());
       maleradio = new JRadioButton("Male    ");
       maleradio.setBackground(Color.green);
       maleradio.setFont(f);
       maleradio.addItemListener(itemhandler);
       femaleradio = new JRadioButton("Female             ");
       femaleradio.setFont(f);
       femaleradio.setBackground(Color.green);
       femaleradio.addItemListener(itemhandler);
       ButtonGroup radiogroup = new ButtonGroup();
       radiopanel.add(maleradio);
       radiopanel.add(femaleradio);
       radiogroup.add(maleradio);
       radiogroup.add(femaleradio);
       JLabel l3 = new JLabel("Gender:                         ");
       l3.setFont(f);
       add(l3);
       gendertext = new JTextField("",25);
       
       add(gendertext);
       gendertext.setVisible(false);
       add(radiopanel);
       
       JLabel l4 = new JLabel("  GPA:          ");
       l4.setFont(f);
       add(l4);

       gpatext = new JTextField("",25);
       gpatext.setPreferredSize(new Dimension(25,25));
       gpatext.setFont(f);
       add(gpatext);
       
       JLabel l5 = new JLabel("  Semester:    ");
       l5.setFont(f);
       add(l5);
       semestertext = new JTextField("",25);
       semestertext.setPreferredSize(new Dimension(25,25));
       semestertext.setFont(f);
       add(semestertext);
       
       JLabel l6 = new JLabel("  Section:      ");
       l6.setFont(f);
       add(l6);
       
       sectiontext = new JTextField("",25);
       sectiontext.setPreferredSize(new Dimension(25,25));
       sectiontext.setFont(f);
       add(sectiontext);
       
       JLabel l7 = new JLabel("Departement:");
       l7.setFont(f);
       add(l7);
       
       deptext = new JTextField("",25);
       deptext.setPreferredSize(new Dimension(25,25));
       deptext.setFont(f);
       add(deptext);
       
       JButton submitbutton = new JButton("Submit",new ImageIcon(getClass().getResource("tick.png")));
       submitbutton.addActionListener(handler);
       JButton cancelbutton = new JButton("Cancel",new ImageIcon(getClass().getResource("cancel.png")));
       cancelbutton.addActionListener(handler);
       add(submitbutton);
       add(cancelbutton);
       
        
        
        
        
        
        
    }
    
    public class MyHandler implements ActionListener{
       Departement dep;
       
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Submit")){
              if(nametext.getText().isEmpty() == false && phonetext.getText().isEmpty() == false &&  gpatext.getText().isEmpty()== false && sectiontext.getText().isEmpty()== false && semestertext.getText().isEmpty()==false && deptext.getText().isEmpty()== false){
                String name = nametext.getText();
                String phone = phonetext.getText();
                //String gender = gendertext.getText();
                String gender = genderans;
                double gpa = Double.parseDouble(gpatext.getText());
                String semester = semestertext.getText();
                String section = sectiontext.getText();
                String depname = deptext.getText();
                StudentWrite stdwrite = new StudentWrite();
                dep = new Departement(depname);
                stdwrite.openFile();
                stdwrite.addRecords(name,phone,gender,gpa,semester,section,dep);
                JOptionPane.showMessageDialog(null,"Successfully Write to File","Information",1);
                StudentGUI stdgui = new StudentGUI();
                stdgui.setVisible(true);
                setVisible(false);
                
                
              }else{
                  JOptionPane.showMessageDialog(null,"All fields must be filled.", "Error",0);
              
              }
              
                
            }else if(e.getActionCommand().equals("Cancel")){
                setVisible(false);
                StudentGUI stdgui = new StudentGUI();
                stdgui.setVisible(true);
                
            }
        }
    
    
    
    }
    public class MyItemHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(maleradio.isSelected()){
                genderans = "male";
            }else if(femaleradio.isSelected()){
                genderans = "female";
            }
        }
    
    }
}
