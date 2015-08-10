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
public class SearchTeacherGUI extends JFrame {
    JTextField searchtext;
    SearchTeacherGUI(){
         super("Search Teacher by Name");
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
        JButton srchbutton = new JButton("Search",new ImageIcon(getClass().getResource("search.png")));
        add(srchbutton);
        srchbutton.addActionListener(handler);
        JButton cancelbutton = new JButton("Cancel",new ImageIcon(getClass().getResource("cancel.png")));
        add(cancelbutton);
        cancelbutton.addActionListener(handler);

    
    }
    
    public class MyHandler implements ActionListener{
        TeacherGUI tchgui;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Search")){
                if(searchtext.getText().isEmpty()==false){
                    TeacherRead tchread = new TeacherRead();
                    tchread.openFile();
                    boolean ans = tchread.readRecord(searchtext.getText());
                    if(ans)
                        //JOptionPane.showMessageDialog(null,"Record Found of Teacher "+searchtext.getText(),"Information",1);
                        setVisible(false);
                    else
                        JOptionPane.showMessageDialog(null,"Record Not Found of Teacher "+searchtext.getText(),"Error",0);
                    tchread.closeFile();
                }else{
                    JOptionPane.showMessageDialog(null,"Enter Name to Search","Error", 0);
                }
                
            
            }else if(e.getActionCommand().equals("Cancel")){
                setVisible(false);
                tchgui = new TeacherGUI();
                tchgui.setVisible(true);
            
            }
        }
    
    
    }
}
