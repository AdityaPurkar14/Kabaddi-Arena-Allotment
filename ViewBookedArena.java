package kabaddi.arena.allotment;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedArena extends JFrame implements ActionListener
{
JButton back;    
ViewBookedArena(String username)
{
    setBounds(400, 200, 1000, 6000);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel text=new JLabel("VIEW BOOKED ARENA");
    text.setFont(new Font("Tahoma",Font.BOLD,20));
    text.setBounds(60, 0, 400, 30);
    add(text);
   
    JLabel theusername=new JLabel("username");
    theusername.setBounds(30, 50, 150, 25);
    add(theusername);
    
    JLabel labelusername=new JLabel();
    labelusername.setBounds(220, 50, 150, 25);
    add(labelusername);
    
    JLabel lblid=new JLabel("Arena Name");
    lblid.setBounds(30, 90, 150, 25);
    add(lblid);
    
    JLabel labelpackage=new JLabel();
    labelpackage.setBounds(220, 90, 150, 25);
    add(labelpackage);

    JLabel lbladd=new JLabel("Arena Address");
    lbladd.setBounds(30, 130, 150, 25);
    add(lbladd);
    
    JLabel labeladdress=new JLabel();
    labeladdress.setBounds(220, 130, 150, 25);
    add(labeladdress);
    
    JLabel lblnumber=new JLabel("Total Players");
    lblnumber.setBounds(30, 170, 150, 25);
    add(lblnumber);
    
    JLabel labelplayers=new JLabel();
    labelplayers.setBounds(220, 170, 150, 25);
    add(labelplayers);
    
    JLabel lbldrinks=new JLabel("Drinks?");
    lbldrinks.setBounds(30, 210, 150, 25);
    add(lbldrinks);
    
    JLabel labeldrinks=new JLabel();
    labeldrinks.setBounds(220, 210, 150, 25);
    add(labeldrinks);
    
     
    JLabel lblfood=new JLabel("Food Included?");
    lblfood.setBounds(30, 250, 150, 25);
    add(lblfood);
    
    JLabel labelfood=new JLabel();
    labelfood.setBounds(220, 250, 150, 25);
    add(labelfood);
    
    JLabel lbldatepla=new JLabel("Date of Playing");
    lbldatepla.setBounds(30, 290, 150, 25);
    add(lbldatepla);
    
    JLabel labeldateofplay=new JLabel();
    labeldateofplay.setBounds(220, 290, 150, 25);
    add(labeldateofplay);
    
    JLabel lbltime=new JLabel("Time of Playing");
    lbltime.setBounds(30, 330, 150, 25);
    add(lbltime);
    
    JLabel labeltime=new JLabel();
    labeltime.setBounds(220, 330, 150, 25);
    add(labeltime);
    
    JLabel lblname=new JLabel("Id");
    lblname.setBounds(30, 370, 150, 25);
    add(lblname);
    
    JLabel labelid=new JLabel();
    labelid.setBounds(220, 370, 150, 25);
    add(labelid);

    
    JLabel lblgender=new JLabel("Number");
    lblgender.setBounds(30, 410, 150, 25);
    add(lblgender);
    
    JLabel labelnumber=new JLabel();
    labelnumber.setBounds(220, 410, 150, 25);
    add(labelnumber);    

    JLabel lblcountry=new JLabel("Phone");
    lblcountry.setBounds(30, 450, 150, 25);
    add(lblcountry);
    
    JLabel labelphone=new JLabel();
    labelphone.setBounds(220, 450, 150, 25);
    add(labelphone);        
    
    JLabel lbladdress=new JLabel("Total Cost");
    lbladdress.setBounds(30, 490, 150, 25);
    add(lbladdress);
    
    JLabel labelprice=new JLabel();
    labelprice.setBounds(220, 490, 150, 25);
    add(labelprice);     
     
    JLabel lblDate=new JLabel("Date of Booking");
    lblDate.setBounds(30, 520, 150, 25);
    add(lblDate);
    
    JLabel labelDate=new JLabel();
    labelDate.setBounds(220, 520, 150, 25);
    add(labelDate);
    
    back=new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(130, 560, 100, 25);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/ss6.jpeg"));
    Image i2=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(450, 20, 500, 400);
    add(image);
    

    
    try{
        Conn conn=new Conn();
        String query="select * from bookarena where username='"+username+"'";
        ResultSet rs=conn.s.executeQuery(query);
        while(rs.next())
        {
            labelusername.setText(rs.getString("username"));
            labelid.setText(rs.getString("id"));
            labelnumber.setText(rs.getString("number"));
            labelpackage.setText(rs.getString("name"));
            labeladdress.setText(rs.getString("address"));
            labelprice.setText(rs.getString("price"));
            labelphone.setText(rs.getString("phone"));
            labelplayers.setText(rs.getString("players"));
            labelfood.setText(rs.getString("food"));
            labeldrinks.setText(rs.getString("drinks"));
            labeldateofplay.setText(rs.getString("dforbooking"));
            labeltime.setText(rs.getString("time"));
            labelDate.setText(rs.getString("date"));
            
        }
    }catch(Exception e)
    {
        
    }
    
    setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
    setVisible(false);
}
public static void main(String args[])
{
    new ViewBookedArena("");
}
    
}

