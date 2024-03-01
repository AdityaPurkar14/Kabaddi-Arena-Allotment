package kabaddi.arena.allotment;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteArena extends JFrame implements ActionListener
{
JButton delete;  
JTextField labelname;
String name;


DeleteArena(String name)
{
    this.name=name;
    setBounds(450, 180, 870, 625);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
   
    JLabel thename=new JLabel("Name of Arena");
    thename.setBounds(30, 50, 150, 25);
    add(thename);
    
    labelname=new JTextField();
    labelname.setBounds(220, 50, 150, 25);
    add(labelname);
    
   
    
    delete=new JButton("Delete");
    delete.setBackground(Color.BLACK);
    delete.setForeground(Color.WHITE);
    delete.setBounds(350, 350, 100, 25);
    delete.addActionListener(this);
    add(delete);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/people.jpg"));
    Image i2=i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(20, 400, 600, 200);
    add(image);
    
    ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("images/people.jpg"));
    Image i5=i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
    ImageIcon i6=new ImageIcon(i5);
    JLabel image2=new JLabel(i6);
    image2.setBounds(600, 400, 600, 200);
    add(image2);
    
    try{
        Conn conn=new Conn();
        String query="select * from arena where name='"+name+"'";
        ResultSet rs=conn.s.executeQuery(query);
        while(rs.next())
        {
            labelname.setText(rs.getString("name"));
            
            
        }
    }catch(Exception e)
    {
        
    }
    
    setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
     if(ae.getSource()==delete)
        {
            String name=labelname.getText();
            
           
    try{
        Conn c=new Conn();
        c.s.executeUpdate("delete from arena where name='"+name+"'");
        
        JOptionPane.showMessageDialog(null, "Arena Deleted Successfully");
        setVisible(false);
    }catch(Exception e){
        e.printStackTrace();
    }
    }else{
            setVisible(false);
        }
}
public static void main(String args[])
{
    new DeleteArena("");
}
    
}
