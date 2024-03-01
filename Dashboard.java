package kabaddi.arena.allotment;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener
{
    String username;
    JButton addPersonalDetails,deletePersonalDetails,about,viewPersonalDetails,payments,viewbookedArena,updatePersonalDetails,checkPackage,viewPackage,bookPackage,viewArenas,bookArena;

    Dashboard(String username){
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
       
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.MAGENTA);
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/icon.jpeg"));
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
        p2.setBackground(Color.MAGENTA);
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPersonalDetails=new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 50);
        addPersonalDetails.setBackground(Color.MAGENTA);
        addPersonalDetails.setForeground(Color.BLACK);
        addPersonalDetails.setFont(new Font("Tahoma",Font.BOLD,20));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails=new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 50, 300, 50);
        updatePersonalDetails.setBackground(Color.MAGENTA);
        updatePersonalDetails.setForeground(Color.BLACK);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.BOLD,20));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        viewPersonalDetails=new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0, 100, 300, 50);
        viewPersonalDetails.setBackground(Color.MAGENTA);
        viewPersonalDetails.setForeground(Color.BLACK);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.BOLD,20));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        deletePersonalDetails=new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 150, 300, 50);
        deletePersonalDetails.setBackground(Color.MAGENTA);
        deletePersonalDetails.setForeground(Color.BLACK);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.BOLD,20));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
        checkPackage=new JButton("Check Package");
        checkPackage.setBounds(0, 200, 300, 50);
        checkPackage.setBackground(Color.MAGENTA);
        checkPackage.setForeground(Color.BLACK);
        checkPackage.setFont(new Font("Tahoma",Font.BOLD,20));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);
        
        bookPackage=new JButton("Book Packages");
        bookPackage.setBounds(0, 250, 300, 50);
        bookPackage.setBackground(Color.MAGENTA);
        bookPackage.setForeground(Color.BLACK);
        bookPackage.setFont(new Font("Tahoma",Font.BOLD,20));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);
        
        viewPackage=new JButton("View Packages");
        viewPackage.setBounds(0, 300, 300, 50);
        viewPackage.setBackground(Color.MAGENTA);
        viewPackage.setForeground(Color.BLACK);
        viewPackage.setFont(new Font("Tahoma",Font.BOLD,20));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);
        
        viewArenas=new JButton("View Arenas");
        viewArenas.setBounds(0, 350, 300, 50);
        viewArenas.setBackground(Color.MAGENTA);
        viewArenas.setForeground(Color.BLACK);
        viewArenas.setFont(new Font("Tahoma",Font.BOLD,20));
        viewArenas.addActionListener(this);
        p2.add(viewArenas);
        
        bookArena=new JButton("Book Arena");
        bookArena.setBounds(0, 400, 300, 50);
        bookArena.setBackground(Color.MAGENTA);
        bookArena.setForeground(Color.BLACK);
        bookArena.setFont(new Font("Tahoma",Font.BOLD,20));
        bookArena.addActionListener(this);
        p2.add(bookArena);
        
        viewbookedArena=new JButton("View Booked Arena");
        viewbookedArena.setBounds(0, 450, 300, 50);
        viewbookedArena.setBackground(Color.MAGENTA);
        viewbookedArena.setForeground(Color.BLACK);
        viewbookedArena.setFont(new Font("Tahoma",Font.BOLD,20));
        viewbookedArena.addActionListener(this);
        p2.add(viewbookedArena);
        
        payments=new JButton("Payments");
        payments.setBounds(0, 500, 300, 50);
        payments.setBackground(Color.MAGENTA);
        payments.setForeground(Color.BLACK);
        payments.setFont(new Font("Tahoma",Font.BOLD,20));
        payments.addActionListener(this);
        p2.add(payments);
        
        about=new JButton("About");
        about.setBounds(0, 550, 300, 50);
        about.setBackground(Color.MAGENTA);
        about.setForeground(Color.BLACK);
        about.setFont(new Font("Tahoma",Font.BOLD,20));
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/dashboard.jpeg"));
        Image i5=i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(0, 0, 1650, 800);
        add(image);
        
        JLabel text=new JLabel("Kabaddi Arena Allotment");
        text.setBounds(550, 150, 1000, 70);
        text.setForeground(Color.cyan);
        text.setFont(new Font("Raleway",Font.PLAIN,60));
        image.add(text);
        
        setVisible(true);
    }
    
    public  void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==addPersonalDetails)
        {
            new AddCustomer(username);
        }else if(ae.getSource()==viewPersonalDetails){
            new ViewCustomer(username);
        }else if(ae.getSource()==updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource()==checkPackage){
            new CheckPackage();
        }else if(ae.getSource()==bookPackage){
            new BookPackage(username);
        }else if(ae.getSource()==viewPackage){
            new ViewPackage(username);
        }else if(ae.getSource()==viewArenas){
            new CheckArenas();
        }else if(ae.getSource()==bookArena){
            new BookArena(username);
        }else if(ae.getSource()==viewbookedArena){
            new ViewBookedArena(username);
        }else if(ae.getSource()==payments){
            new Payment();
        }else if(ae.getSource()==about){
            new About();
        }else if(ae.getSource()==deletePersonalDetails){
            new DeleteDetails(username);
        }
    }
    
    public static void main(String args[])
    {
        new Dashboard("");
    }
}
