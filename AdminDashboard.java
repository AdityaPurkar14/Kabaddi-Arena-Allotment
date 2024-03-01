package kabaddi.arena.allotment;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener
{
    String username;
    JButton addArena,deleteArena,about,payments,viewbookedArena,checkPackage,viewPackage,viewArenas;

    AdminDashboard(String username){
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
       
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.CYAN);
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/logo.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);
        
        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.CYAN);
        p2.setBounds(0,65,300,900);
        add(p2);
   
        
        checkPackage=new JButton("Check Package");
        checkPackage.setBounds(0, 0, 300, 50);
        checkPackage.setBackground(Color.GREEN);
        checkPackage.setForeground(Color.BLACK);
        checkPackage.setFont(new Font("Tahoma",Font.BOLD,20));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);
        

        
        viewPackage=new JButton("View Packages");
        viewPackage.setBounds(0, 50, 300, 50);
        viewPackage.setBackground(Color.GREEN);
        viewPackage.setForeground(Color.BLACK);
        viewPackage.setFont(new Font("Tahoma",Font.BOLD,20));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);
        
        viewArenas=new JButton("View Arenas");
        viewArenas.setBounds(0, 100, 300, 50);
        viewArenas.setBackground(Color.GREEN);
        viewArenas.setForeground(Color.BLACK);
        viewArenas.setFont(new Font("Tahoma",Font.BOLD,20));
        viewArenas.addActionListener(this);
        p2.add(viewArenas);
        
        viewbookedArena=new JButton("View Booked Arena");
        viewbookedArena.setBounds(0, 150, 300, 50);
        viewbookedArena.setBackground(Color.GREEN);
        viewbookedArena.setForeground(Color.BLACK);
        viewbookedArena.setFont(new Font("Tahoma",Font.BOLD,20));
        viewbookedArena.addActionListener(this);
        p2.add(viewbookedArena);
        
        addArena=new JButton("Add Arena");
        addArena.setBounds(0, 200, 300, 50);
        addArena.setBackground(Color.GREEN);
        addArena.setForeground(Color.BLACK);
        addArena.setFont(new Font("Tahoma",Font.BOLD,20));
        addArena.addActionListener(this);
        p2.add(addArena);
        
        deleteArena=new JButton("Delete Arena");
        deleteArena.setBounds(0, 250, 300, 50);
        deleteArena.setBackground(Color.GREEN);
        deleteArena.setForeground(Color.BLACK);
        deleteArena.setFont(new Font("Tahoma",Font.BOLD,20));
        deleteArena.addActionListener(this);
        p2.add(deleteArena);
        
        
        
        payments=new JButton("Payments");
        payments.setBounds(0, 300, 300, 50);
        payments.setBackground(Color.GREEN);
        payments.setForeground(Color.BLACK);
        payments.setFont(new Font("Tahoma",Font.BOLD,20));
        payments.addActionListener(this);
        p2.add(payments);
        
        about=new JButton("About");
        about.setBounds(0, 350, 300, 50);
        about.setBackground(Color.GREEN);
        about.setForeground(Color.BLACK);
        about.setFont(new Font("Tahoma",Font.BOLD,20));
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/ad.jpeg"));
        Image i5=i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(0, 0, 1650, 800);
        add(image);
        
        JLabel text=new JLabel("Admin Panel of Project");
        text.setBounds(550, 150, 1000, 70);
        text.setForeground(Color.ORANGE);
        text.setFont(new Font("Raleway",Font.PLAIN,60));
        image.add(text);
        
        setVisible(true);
    }
    
    public  void actionPerformed(ActionEvent ae)
    {
         if(ae.getSource()==checkPackage){
            new CheckPackage();
        }else if(ae.getSource()==viewPackage){
            new ViewPackage(username);
        }else if(ae.getSource()==viewArenas){
            new CheckArenas();
        }else if(ae.getSource()==addArena){
            new AddArena(username);
        }else if(ae.getSource()==viewbookedArena){
            new ViewBookedArena(username);
        }else if(ae.getSource()==deleteArena){
            new DeleteArena(username);
        }else if(ae.getSource()==payments){
            new Payment();
        }else if(ae.getSource()==about){
            new About();
        }
    }
    
    public static void main(String args[])
    {
        new AdminDashboard("");
    }
}
