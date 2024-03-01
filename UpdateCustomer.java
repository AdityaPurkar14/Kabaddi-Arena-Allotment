package kabaddi.arena.allotment;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.Pattern;


public class UpdateCustomer extends JFrame implements ActionListener
{
    Choice comboid;
    JLabel labelusername,labelname;
    JTextField tnumber,tcountry,taddress,temail,tphone,tid,tgender;
    JRadioButton rmale,rfemale;
    JButton add,back;
    
    UpdateCustomer(String username)
    {
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel theusername=new JLabel("Username");
        theusername.setBounds(30,50,150,25);
        add(theusername);
        
        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        tid=new JTextField();
        tid.setBounds(220,90,150,25);
        add(tid);
    
        JLabel lblnumber=new JLabel("Id Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tnumber=new JTextField();
        tnumber.setBounds(220,130,150,25);
        add(tnumber);
        
        JLabel thename=new JLabel("Name");
        thename.setBounds(30,170,150,25);
        add(thename);
        
        labelname=new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        tgender=new JTextField();
        tgender.setBounds(220,210,150,25);
        add(tgender);
      
        
        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
        tcountry=new JTextField();
        tcountry.setBounds(220,250,150,25);
        add(tcountry);
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
        taddress=new JTextField();
        taddress.setBounds(220,290,150,25);
        add(taddress);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(30,330,150,25);
        add(lblemail);
        
        temail=new JTextField();
        temail.setBounds(220,330,150,25);
        add(temail);
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);
        
        tphone=new JTextField();
        tphone.setBounds(220,370,150,25);
        add(tphone);
        
        add=new JButton("Update");
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
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/update.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,40,400,500);
        add(image);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tid.setText(rs.getString("id"));
                tnumber.setText(rs.getString("number"));
                tgender.setText(rs.getString("gender"));
                tcountry.setText(rs.getString("country"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add)
        {
            
            String username=labelusername.getText();
            String id=tid.getText();
            String number=tnumber.getText();
            String name=labelname.getText();
            String gender=tgender.getText();
            String country=tcountry.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
             String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            if (!Pattern.matches(emailPattern, email)) {
                JOptionPane.showMessageDialog(this, "Invalid email format or cant keep it empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            String phonePattern = "^[0-9]{10}$"; 
            if (!Pattern.matches(phonePattern, phone)) {
                JOptionPane.showMessageDialog(this, "Invalid phone number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try{
                Conn c=new Conn();
                String query="update customer set username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
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
        new UpdateCustomer("");
    }
}
