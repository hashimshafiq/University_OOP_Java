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
public class SearchStudentbyDepGUI extends JFrame{
    JTextField searchtext;
    JTextField searchdeptext;
    public SearchStudentbyDepGUI(){
        super("Search Student by Name");
        setSize(400,150);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        setResizable(false);
        getContentPane().setBackground(Color.green);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        setLayout(new FlowLayout());
        Font f = new Font("Times New Roman",Font.BOLD,18);
        MyHandler handler = new MyHandler();
        JLabel l1 = new JLabel("Name : ");
        l1.setFont(f);
        add(l1);
        searchtext = new JTextField("",20);
        searchtext.setFont(f);
        searchtext.setPreferredSize(new Dimension(25,25));
        add(searchtext);
        JLabel l2 = new JLabel("Dept  : ");
        l2.setFont(f);
        add(l2);
        searchdeptext = new JTextField("",20);
        searchdeptext.setFont(f);
        searchdeptext.setPreferredSize(new Dimension(25,25));
        add(searchdeptext);
        JButton srchbutton = new JButton("Search",new ImageIcon(getClass().getResource("search.png")));
        add(srchbutton);
        srchbutton.addActionListener(handler);
        JButton cancelbutton = new JButton("Cancel",new ImageIcon(getClass().getResource("cancel.png")));
        add(cancelbutton);
        cancelbutton.addActionListener(handler);
    
    }
    public class MyHandler implements ActionListener{

       @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Search")){
                if(searchtext.getText().isEmpty() == false && searchdeptext.getText().isEmpty() == false){
                    StudentRead stdread = new StudentRead();
                    stdread.openFile();
                    boolean ans = stdread.readRecord(searchtext.getText(),searchdeptext.getText());
                    if(ans)
                        setVisible(false);
                    else
                        JOptionPane.showMessageDialog(null,"Record Not Found of Student "+searchtext.getText()+" in depratement "+searchdeptext.getText(),"Error",0);
                    stdread.closeFile();
                }else{
                    JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",0);
                }
            }else if(e.getActionCommand().equals("Cancel")){
                setVisible(false);
                StudentGUI stdgui = new StudentGUI();
                stdgui.setVisible(true);
            }
    
    
    }
    }
}
