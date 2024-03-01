
package kabaddi.arena.allotment;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener
{
 JButton create,back;   
 JTextField tusername,tname,tpassword,tanswer;
 Choice security;
 
Signup()
{
    setBounds(350,200,900,360);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JPanel p1=new JPanel();
    p1.setBackground(new Color(133,193,233));
    p1.setBounds(0, 0, 500, 400);
    p1.setLayout(null);
    add(p1);
    
    JLabel theusername=new JLabel("username");
    theusername.setFont(new Font("Tahoma",Font.BOLD,14));
    theusername.setBounds(50, 20, 125, 25);
    p1.add(theusername);
    
    tusername=new JTextField();
    tusername.setBounds(190,20,180,25);
    tusername.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tusername);

    JLabel thename=new JLabel("Name");
    thename.setFont(new Font("Tahoma",Font.BOLD,14));
    thename.setBounds(50, 60, 125, 25);
    p1.add(thename);
    
    tname=new JTextField();
    tname.setBounds(190,60,180,25);
    tname.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tname);
    
    
    
    
    JLabel thepassword=new JLabel("Password");
    thepassword.setFont(new Font("Tahoma",Font.BOLD,14));
    thepassword.setBounds(50, 100, 125, 25);
    p1.add(thepassword);
    
    tpassword=new JTextField();
    tpassword.setBounds(190,100,180,25);
    tpassword.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tpassword);
    
    
    JLabel tsecurity=new JLabel("Security Question");
    tsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
    tsecurity.setBounds(50, 140, 125, 25);
    p1.add(tsecurity);
    
    
    security=new Choice();
    security.add("What is your pet name?");
    security.add("What is your car name?");
    security.add("your best friend name");
    security.add("your fav movie name?");
    security.add("your fav marvel super Hero");
    security.add("your fav childhood cartoon");
    security.setBounds(190, 140, 180, 25);
    p1.add(security);
    
    
    JLabel theans=new JLabel("Answer");
    theans.setFont(new Font("Tahoma",Font.BOLD,14));
    theans.setBounds(50, 180, 125, 25);
    p1.add(theans);
    
    tanswer=new JTextField();
    tanswer.setBounds(190,180,180,25);
    tanswer.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tanswer);
    
    
    create=new JButton("create");
    create.setBackground(Color.GREEN);
    create.setForeground(Color.WHITE);
    create.setFont(new Font("Tahoma",Font.BOLD,14));
    create.setBounds(80,250,100,30);
    create.addActionListener(this);
    p1.add(create);
    
    back=new JButton("back");
    back.setBackground(Color.RED);
    back.setForeground(Color.WHITE);
    back.setFont(new Font("Tahoma",Font.BOLD,14));
    back.setBounds(250,250,100,30);
    back.addActionListener(this);
    p1.add(back);


    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/lo.jpeg"));
    Image i2=i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(580,50,250,250);
    add(image);
    
    
    
    setVisible(true);
}
    
public void actionPerformed(ActionEvent ae) 
{
  if(ae.getSource() == create)
  {
  String username=tusername.getText();
  String name=tname.getText();
  String password=tpassword.getText();
  String question=security.getSelectedItem();
  String answer=tanswer.getText();
  if (username.isEmpty() || name.isEmpty() || password.isEmpty() || answer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
  
  String query="insert into account values('"+username+"', '"+name+"','"+password+"','"+question+"','"+answer+"')";
  try{
  Conn c=new Conn();
  c.s.executeUpdate(query);
  
  
  JOptionPane.showMessageDialog(null,"Account Created Successfully");
  setVisible(false);
  new Login();
  }catch(Exception e){
  e.printStackTrace();
  }
  }else if(ae.getSource()==back)
  {
  setVisible(false);
  new Login();
  }
}
public static void main(String args[])    
{
new Signup(); 
}
}