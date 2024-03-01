package kabaddi.arena.allotment;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class BookArena extends JFrame implements ActionListener{
    
    Choice carena,cdrinks,cfood;
    JTextField tplayers,labeldateforbook,labeltime;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice,labelDate,labeladdress;
    JButton checkprice,bookpackage,back;
    String username;
    
    BookArena(String  username){
        
        this.username=username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("BOOK Arena");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
    JLabel theusername=new JLabel("username");
    theusername.setFont(new Font("Tahoma",Font.PLAIN,16));
    theusername.setBounds(40, 70, 100, 20);
    add(theusername);
    
    labelusername=new JLabel();
    labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
    labelusername.setBounds(250, 70, 100, 20);
    add(labelusername);
    
    JLabel lblpackage=new JLabel("Select Arena");
    lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblpackage.setBounds(40, 100, 100, 20);
    add(lblpackage);
    
    carena=new Choice();
    carena.setBounds(250, 100, 200, 20);
    add(carena);

    try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from arena");
        while(rs.next()){
            carena.add(rs.getString("name"));
        
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    JLabel theaddress = new JLabel("Arena Address");
        theaddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        theaddress.setBounds(40, 130, 200, 20);
        add(theaddress);

        labeladdress = new JLabel();
        labeladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labeladdress.setBounds(250, 130, 200, 20);
        add(labeladdress);

       carena.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from arena where name='" + carena.getSelectedItem() + "'");
            if (rs.next()) {
                labeladdress.setText(rs.getString("address"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});

    
    JLabel lblplayers=new JLabel("Total Players");
    lblplayers.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblplayers.setBounds(40, 170, 150, 25);
    add(lblplayers);
    
    tplayers=new JTextField("1");
    tplayers.setBounds(250, 170, 200, 20);
    add(tplayers);
    
    JLabel lbldrinks=new JLabel("Drinks");
    lbldrinks.setFont(new Font("Tahoma",Font.PLAIN,16));
    lbldrinks.setBounds(40, 200, 150, 25);
    add(lbldrinks);
    
    cdrinks=new Choice();
    cdrinks.add("Yes");
    cdrinks.add("No");
    cdrinks.setBounds(250, 200, 200, 25);
    add(cdrinks);
    
    JLabel lblfood=new JLabel("Food");
    lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblfood.setBounds(40, 230, 150, 25);
    add(lblfood);
    
    cfood=new Choice();
    cfood.add("Yes");
    cfood.add("No");
    cfood.setBounds(250, 230, 200, 25);
    add(cfood);
    
    JLabel tdateforbook=new JLabel("Date of Playing");
    tdateforbook.setFont(new Font("Tahoma", Font.PLAIN, 16));
    tdateforbook.setBounds(40, 260, 150, 20);
    add(tdateforbook);
    
    labeldateforbook=new JTextField();
    labeldateforbook.setBounds(250, 260, 200, 25);
    add(labeldateforbook);
    
    JLabel thetime=new JLabel("Time of Playing");
    thetime.setFont(new Font("Tahoma", Font.PLAIN, 16));
    thetime.setBounds(40, 290, 150, 20);
    add(thetime);
    
    labeltime=new JTextField();
    labeltime.setBounds(250, 290, 200, 25);
    add(labeltime);
    
    
    JLabel lblid=new JLabel("id");
    lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblid.setBounds(40, 320, 150, 20);
    add(lblid);
    
    labelid=new JLabel();
    labelid.setBounds(250, 320, 200, 25);
    add(labelid);

    
    JLabel lblnumber=new JLabel("Number");
    lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblnumber.setBounds(40, 350, 150, 25);
    add(lblnumber);
    
    labelnumber=new JLabel();
    labelnumber.setBounds(250, 350, 150, 25);
    add(labelnumber);
    
    JLabel lblphone=new JLabel("Phone");
    lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblphone.setBounds(40, 380, 150, 25);
    add(lblphone);
    
    labelphone=new JLabel();
    labelphone.setBounds(250, 380, 200, 25);
    add(labelphone);
     
    JLabel lbltotal=new JLabel("Total Price");
    lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
    lbltotal.setBounds(40, 410, 150, 25);
    add(lbltotal);
    
    labelprice=new JLabel();
    labelprice.setBounds(250, 410, 150, 25);
    add(labelprice);
    
    
        JLabel lbldate = new JLabel("Date");
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldate.setBounds(40, 440, 150, 25);
        add(lbldate);

        labelDate = new JLabel();
        labelDate.setBounds(250, 440, 200, 25);
        add(labelDate);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        labelDate.setText(dateFormat.format(new java.util.Date()));
    try{
        Conn conn=new Conn();
        String query="select * from customer where username='"+username+"'";
        ResultSet rs=conn.s.executeQuery(query);
        while(rs.next())
        {   
          
            labelusername.setText(rs.getString("username"));
            labelid.setText(rs.getString("id"));
            labelnumber.setText(rs.getString("number"));
            labelphone.setText(rs.getString("phone"));
            
        }
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    checkprice=new JButton("Check Price");
    checkprice.setBackground(Color.BLACK);
    checkprice.setForeground(Color.WHITE);
    checkprice.setBounds(60, 510, 120, 25);
    checkprice.addActionListener(this);
    add(checkprice);
    
    bookpackage=new JButton("Book Arena");
    bookpackage.setBackground(Color.BLACK);
    bookpackage.setForeground(Color.WHITE);
    bookpackage.setBounds(200, 510, 120, 25);
    bookpackage.addActionListener(this);
    add(bookpackage);
    
    back=new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(340, 510, 120, 25);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/ss1.jpeg"));
    Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel l12=new JLabel(i3);
    l12.setBounds(500, 50, 600, 300);
    add(l12);
    
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            try{
            Conn c=new Conn();
            ResultSet rs = c.s.executeQuery("select * from arena where name='" + carena.getSelectedItem() + "'");
            
            while(rs.next()){
                String address = String.valueOf(rs.getString("address"));
                int cost=Integer.parseInt(rs.getString("costperplayer"));
                int drinks=Integer.parseInt(rs.getString("drinks"));
                int food=Integer.parseInt(rs.getString("foodincluded"));
                
                int players=Integer.parseInt(tplayers.getText());
                String drinkselected=cdrinks.getSelectedItem();
                String foodselected=cfood.getSelectedItem();
                String date=labelDate.getText();
                String dforbooking=labeldateforbook.getText();
                String time=labeltime.getText();
                
                if(players>0){
                    int total=0;
                    total +=drinkselected.equals("Yes") ? drinks :0 ;
                    total +=foodselected.equals("Yes") ? food:0;
                    total +=cost;
                    total=total*players;
                    labelprice.setText("Rs"+total);
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter valid number");
                }
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==bookpackage){
            
            try{
                Conn c=new Conn();
               c.s.executeUpdate("insert into bookarena values('"+labelusername.getText()+"','"+carena.getSelectedItem()+"','"+labeladdress.getText()+"','"+tplayers.getText()+"','"+cdrinks.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"','"+labelnumber.getText()+"','"+labelDate.getText()+"','"+labeldateforbook.getText()+"','"+labeltime.getText()+"')");


               
                JOptionPane.showMessageDialog(null, "Arena Booked Successfully");
                setVisible(false);
            }catch(Exception e){
               e.printStackTrace();
            }
            
        }else {
         setVisible(false);   
        }
    }
        public static void main(String args[])
        {
           new BookArena(""); 
        }
    }
    

