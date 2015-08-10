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
import java.awt.GridLayout;
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
public class AddTeacherGUI extends JFrame{
    JTextField nametext;
    JTextField phonetext;
    JTextField gendertext;
    JTextField designationtext;
    JTextField salarytext;
    JTextField deptext;
    JRadioButton maleradio;
    JRadioButton femaleradio;
    String genderans;
    
    public AddTeacherGUI(){
        super("Add Teacher Record");
        setSize(550,300);
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
       
       JLabel l1 = new JLabel(" Name:          ");
       l1.setFont(f);
       add(l1);
        nametext = new JTextField("",25);
        nametext.setPreferredSize(new Dimension(25,25));
        nametext.setFont(f);
        add(nametext);
       
       JLabel l2 = new JLabel(" Phone:         ");
       l2.setFont(f);
       add(l2);
       phonetext = new JTextField("",25);
       phonetext.setFont(f);
       phonetext.setPreferredSize(new Dimension(25,25));
       add(phonetext);
       
       JPanel radiopanel = new JPanel();
       radiopanel.setBackground(Color.green);
       radiopanel.setLayout(new FlowLayout());
       maleradio = new JRadioButton("Male       ");
       maleradio.setBackground(Color.green);
       maleradio.setFont(f);
       maleradio.addItemListener(itemhandler);
       femaleradio = new JRadioButton("Female         ");
       femaleradio.setFont(f);
       femaleradio.setBackground(Color.green);
       femaleradio.addItemListener(itemhandler);
       ButtonGroup radiogroup = new ButtonGroup();
       radiopanel.add(maleradio);
       radiopanel.add(femaleradio);
       radiogroup.add(maleradio);
       radiogroup.add(femaleradio);
       JLabel l3 = new JLabel("Gender:                          ");
       l3.setFont(f);
       add(l3);
       gendertext = new JTextField("",25);
       
       add(gendertext);
       gendertext.setVisible(false);
       add(radiopanel);
       
       JLabel l4 = new JLabel(" Designation: ");
       l4.setFont(f);
       add(l4);
       designationtext = new JTextField("",25);
       designationtext.setFont(f);
       designationtext.setPreferredSize(new Dimension(25,25));
       add(designationtext);
       
       JLabel l5 = new JLabel(" Salary:         ");
       l5.setFont(f);
       add(l5);
       salarytext = new JTextField("",25);
       salarytext.setFont(f);
       salarytext.setPreferredSize(new Dimension(25,25));
       add(salarytext);
       
       JLabel l6 = new JLabel("Departement:");
       l6.setFont(f);
       add(l6);
       deptext = new JTextField("",25);
       deptext.setFont(f);
       deptext.setPreferredSize(new Dimension(25,25));
       add(deptext);
       
       
       JButton submitbutton = new JButton("Submit",new ImageIcon(getClass().getResource("tick.png")));
       submitbutton.addActionListener(handler);
       JButton cancelbutton = new JButton("Cancel",new ImageIcon(getClass().getResource("cancel.png")));
       cancelbutton.addActionListener(handler);
       add(submitbutton);
       add(cancelbutton);
       
    
    
    }
    public class MyHandler implements ActionListener{
            TeacherGUI tchgui;
        @Override
        public void actionPerformed(ActionEvent e) {
          if(e.getActionCommand().equals("Submit")){
              if(nametext.getText().isEmpty()==false && phonetext.getText().isEmpty() == false && designationtext.getText().isEmpty()==false&& salarytext.getText().isEmpty()==false && deptext.getText().isEmpty()==false){
                  TeacherWrite tchwrite = new TeacherWrite();
                  Departement dep = new Departement(deptext.getText());
                  tchwrite.openFile();
                  tchwrite.addRecords(nametext.getText(),phonetext.getText(),genderans, designationtext.getText(),salarytext.getText(), dep);
                  tchwrite.closeFile();
                  JOptionPane.showMessageDialog(null,"Successfully Write to File","Information",1);
                  setVisible(false);
                  TeacherGUI tchgui = new TeacherGUI();
                  tchgui.setVisible(true);
              
              }else{
                  JOptionPane.showMessageDialog(null,"Please fill all the fields","Error", 0);
              
              }
          
          }else if(e.getActionCommand().equals("Cancel")){
              setVisible(false);
              tchgui = new TeacherGUI();
              tchgui.setVisible(true);
          }  
        }
    
    }
    public class MyItemHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(maleradio.isSelected())
                genderans = "male";
            else if(femaleradio.isSelected())
                genderans = "female";
        }
    
    
    }
    
}
