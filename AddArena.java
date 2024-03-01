package kabaddi.arena.allotment;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class AddArena extends JFrame implements ActionListener
{
   
    JTextField tname,taddress,tfood,tdrinks,tcost;
    JButton add,back;
    
    AddArena(String username)
    {
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel thename=new JLabel("Name of Arena");
        thename.setBounds(30,50,150,25);
        add(thename);
        
        tname=new JTextField();
        tname.setBounds(220,50,150,25);
        add(tname);
        
        JLabel theaddress=new JLabel("Address of Arena");
        theaddress.setBounds(30,90,150,25);
        add(theaddress);
        
        taddress=new JTextField();
        taddress.setBounds(220,90,150,25);
        add(taddress);
        
        JLabel lblcost=new JLabel("Cost per player");
        lblcost.setBounds(30,130,150,25);
        add(lblcost);
        
        tcost=new JTextField();
        tcost.setBounds(220, 130, 150, 25);
        add(tcost);
        
        
        JLabel lbldrinks=new JLabel("Drinks cost");
        lbldrinks.setBounds(30,170,150,25);
        add(lbldrinks);
        
        tdrinks=new JTextField();
        tdrinks.setBounds(220,170,150,25);
        add(tdrinks);
        
        JLabel thefood=new JLabel("Food Cost");
        thefood.setBounds(30,210,150,25);
        add(thefood);
        
        tfood=new JTextField();
        tfood.setBounds(220,210,150,25);
        add(tfood);

        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/us.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,40,400,500);
        add(image);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from account where username='"+username+"'");
            while(rs.next()){
               
                tname.setText(rs.getString("name"));
            }
            c.s.executeQuery("select *from account where username");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add)
        {
            String name=tname.getText();
            String address=taddress.getText();
            String costperplayer=tcost.getText();
            String drinks=tdrinks.getText();
            String food=tfood.getText();
          
            
            try{
                Conn c=new Conn();
                String query="insert into arena values('"+name+"','"+address+"','"+costperplayer+"','"+drinks+"','"+food+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Arena Added Successfully");
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
        new AddArena("");
    }
}
