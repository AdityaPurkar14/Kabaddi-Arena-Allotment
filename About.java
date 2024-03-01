package kabaddi.arena.allotment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class About extends JFrame implements ActionListener{

About(){
    setBounds(600,200,500,550);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    
    JLabel l1=new JLabel("ABOUT");
    l1.setBounds(200, 10, 100, 40);
    l1.setForeground(Color.red);
    l1.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l1);
    
    String s="About Project  \n" +
            "\n"+"The Objective of the Kabaddi Arena Allotment is to develope the system that avoid the manual work done previously \n"+
            "\n"+"This Application will help in accessing the information related  tto kabaddi arena reserving processs \n"+
            "\n"+
            "\n"+
            "Advantages of Project:\n"+
            "\n"+
            "Given accurate information \n"+
            "Simplifies the manual work\n"+
            "It minimizes the documentation related work\n"+
            "Provides up to date information\n"+
            "Friendly Environment by providing warning meassages.\n"+
            "reserving the kabaddi arena confirmation notification\n"+
            "\n"+
            "\n"+
            "we have provided season discounts for the user to enjoy his match\n"+
            "we have also proivded coachin services for users to improve their gaming skills\n"+
            "\n"+
            "As the needs of the user we will understand as per that requirements we will add more functionalties";
            
    
    TextArea area=new TextArea(s,10,40,Scrollbar.VERTICAL);
    area.setEditable(false);
    area.setBounds(20, 100, 450, 300);
    add(area);
    
        JButton back=new JButton("Back");
        back.setBounds(200, 420, 100, 25);
        back.addActionListener(this);
        add(back);
    
    setVisible(true);
    
}
 public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

public static void main(String args[]){
    new About();
}
    
}
