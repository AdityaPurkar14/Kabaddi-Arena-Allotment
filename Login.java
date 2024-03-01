package kabaddi.arena.allotment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,signup,password;
    JTextField tpassword,tusername;
    
    Login()
    {
    setSize(900,400);
    setLocation(350,200);
    setLayout(null);
    
    getContentPane().setBackground(Color.WHITE);
    
    JPanel p1=new JPanel();
    p1.setBackground(Color.LIGHT_GRAY);
    p1.setBounds(0, 0, 400, 400);
    add(p1);
    
    
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/log.png"));
    Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(100,120,200,200);
    p1.add(image);
    p1.setLayout(null);
    
    
    JPanel p2=new JPanel();
    p2.setLayout(null);
    p2.setBounds(400, 30, 450, 300);
    add(p2);
    
    JLabel theusername=new JLabel("username");
    theusername.setBounds(60, 20, 100,25);
    theusername.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    p2.add(theusername);
    
    tusername=new JTextField();
    tusername.setBounds(60,60,300,30);
    tusername.setBorder(BorderFactory.createEmptyBorder());
    p2.add(tusername);
    
    
     JLabel thepassword=new JLabel("password");
    thepassword.setBounds(60, 110, 100,25);
    thepassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    p2.add(thepassword);
    
    tpassword=new JTextField();
    tpassword.setBounds(60,150,300,30);
    tpassword.setBorder(BorderFactory.createEmptyBorder());
    p2.add(tpassword);
    
    login=new JButton("Login");
    login.setBounds(60, 200, 130, 30);
    login.setBackground(Color.GREEN);
    login.addActionListener(this);
    p2.add(login);
    
    
    signup=new JButton("Signup");
    signup.setBounds(230, 200, 130, 30);
    signup.setBackground(Color.yellow);
    signup.addActionListener(this);
    p2.add(signup);
    
    
    password=new JButton("Forget Password");
    password.setBounds(130, 250, 130, 30);
    password.setBackground(Color.RED);
    password.addActionListener(this);
    p2.add(password);
    
    JLabel text=new JLabel("Trouble in Login...");
    text.setBounds(300, 250, 150, 20);
    text.setForeground(Color.red);
    p2.add(text);
    
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==login){
        try{
            String username=tusername.getText();
            String pass=tpassword.getText();
            String query="select * from account where username='"+username+"'AND password='"+pass+"'";
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Loading(username);
                
            }else
            {
                JOptionPane.showMessageDialog(null, "Incorrect username or password");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }else if(ae.getSource()==signup){
       setVisible(false);
       new Signup();
    }else{
    setVisible(false);
    new ForgetPass();
    }
    }

    
    
public static void main(String args[]){
   new Login();
}
}