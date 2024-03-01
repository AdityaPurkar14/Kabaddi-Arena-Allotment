package kabaddi.arena.allotment;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPass extends JFrame implements ActionListener
{
    JTextField tusername,tname,tquestion,tanswer,tpassword;
    JButton search,retrive,back;
    
    ForgetPass()
    {
    setBounds(350,200,850,380);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/forget.png"));
    Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(580,70,200,200);
    add(image);
    
    JPanel p1=new JPanel();
    p1.setLayout(null);
    p1.setBounds(30, 30, 500, 280);
    add(p1);
    
    JLabel theusername=new JLabel("username");
    theusername.setBounds(40,20,100,25);
    theusername.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(theusername);
    
    tusername=new JTextField();
    tusername.setBounds(220,20,150,25);
    tusername.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tusername);
    
    search=new JButton("search");
    search.setBackground(Color.MAGENTA);
    search.setForeground(Color.white);
    search.setBounds(380,20,100,25);
    search.addActionListener(this);
    p1.add(search);
    
    JLabel thename=new JLabel("Name");
    thename.setBounds(40,60,100,25);
    thename.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(thename);
    
    tname=new JTextField();
    tname.setBounds(220,60,150,25);
    tname.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tname);
    
    JLabel thequestion=new JLabel("Security Question");
    thequestion.setBounds(40,100,150,25);
    thequestion.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(thequestion);
    
    tquestion=new JTextField();
    tquestion.setBounds(220,100,150,25);
    tquestion.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tquestion);
    
    JLabel theans=new JLabel("Answer");
    theans.setFont(new Font("Tahoma",Font.BOLD,14));
    theans.setBounds(40, 140, 150, 25);
    p1.add(theans);
    
    tanswer=new JTextField();
    tanswer.setBounds(220,140,150,25);
    tanswer.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tanswer);
    
    
    retrive=new JButton("retrive");
    retrive.setBackground(Color.MAGENTA);
    retrive.setForeground(Color.white);
    retrive.setBounds(380,140,100,25);
    retrive.addActionListener(this);
    p1.add(retrive);
    
     JLabel thepassword=new JLabel("Password");
    thepassword.setFont(new Font("Tahoma",Font.BOLD,14));
    thepassword.setBounds(40, 180, 150, 25);
    p1.add(thepassword);
    
    tpassword=new JTextField();
    tpassword.setBounds(220,180,150,25);
    tpassword.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tpassword);
    
    
    back=new JButton("Back");
    back.setBackground(Color.MAGENTA);
    back.setForeground(Color.white);
    back.setBounds(150,230,100,25);
    back.addActionListener(this);
    p1.add(back);
    
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==search)
    {
    try{
    String query="select*from account where username='"+tusername.getText()+"'";
    Conn c=new Conn();
    ResultSet rs= c.s.executeQuery(query);
    while(rs.next())
    {
    tname.setText(rs.getString("name"));
    tquestion.setText(rs.getString("security"));
    
    }
    }catch(Exception e)
    {
    e.printStackTrace();
    }
    }else if(ae.getSource()==retrive)
    {
    try{
    String query="select*from account where answer='"+tanswer.getText()+"' AND username='"+tusername.getText()+"'";
    Conn c=new Conn();
    ResultSet rs= c.s.executeQuery(query);
    while(rs.next())
    {
    tpassword.setText(rs.getString("password"));
    
    
    }
    }catch(Exception e)
    {
    e.printStackTrace();
    }
        
        
        
    }else
    {
    setVisible(false);
    new Login();
    }
    }
    
    public static void main(String args[])
    {
    
    new ForgetPass();
    
    
    
    }
    
    
}
