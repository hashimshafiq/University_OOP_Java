/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Hashim
 */
public class TeacherGUI extends JFrame{
    public TeacherGUI(){
    
        super("Teacher Records");
        setSize(400,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(Color.green);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        setLayout(new FlowLayout());
        // Buttons
        Icon img1 = new ImageIcon(getClass().getResource("addrecord.png"));
        Icon img2 = new ImageIcon(getClass().getResource("search.png"));
        Icon img3 = new ImageIcon(getClass().getResource("cancel.png"));
        JButton addstd = new JButton("Add Teacher");
        addstd.setPreferredSize(new Dimension(260,50));
        addstd.setIcon(img1);
        JButton searchstdname = new JButton("Search Teacher by Name");
        searchstdname.setPreferredSize(new Dimension(260,50));
        searchstdname.setIcon(img2);
       
        JButton cancel = new JButton("Cancel");
        cancel.setPreferredSize(new Dimension(260,50));
        cancel.setIcon(img3);
        MyHandler handler = new MyHandler();
        addstd.addActionListener(handler);
        searchstdname.addActionListener(handler);
        
        cancel.addActionListener(handler);
        add(addstd);
        add(searchstdname);
        
        add(cancel);
    
    }
    public class MyHandler implements ActionListener{
        AddTeacherGUI addtchgui;
        SearchTeacherGUI searchtchgui;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Add Teacher")){
                //Add teacher code
                addtchgui = new AddTeacherGUI();
                addtchgui.setVisible(true);
                setVisible(false);
            }else if(e.getActionCommand().equals("Search Teacher by Name")){
                // search teacher record
                searchtchgui = new SearchTeacherGUI();
                searchtchgui.setVisible(true);
                setVisible(false);
            }else if(e.getActionCommand().equals("Cancel")){
                setVisible(false);
            }
            
        }
    
    
    }
}
