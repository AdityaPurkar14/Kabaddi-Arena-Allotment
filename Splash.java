package kabaddi.arena.allotment;
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable
{
   Thread thread; 
    Splash()
    {
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/splash.jpeg"));
    Image i2=i1.getImage().getScaledInstance(1200,600, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    add(image);
    setVisible(true);
   thread=new Thread(this);
   thread.start();
    
    }
 public void run()
 {
 try{
 Thread.sleep(5000);
  new Login();
 setVisible(false);
 }catch(Exception e){
 
 }
 }

    
    public static void main(String[] args)
    {
     Splash frame=new Splash();
     
   frame.setLocation(100,100);
   frame.setSize(1200,600);
   try{
   Thread.sleep(10);
   
   }catch(Exception e){
       
   }
   

   }
     }
    

