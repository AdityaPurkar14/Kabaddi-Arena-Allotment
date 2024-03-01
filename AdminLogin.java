package kabaddi.arena.allotment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {
    JButton login;
    JTextField tpassword, tusername;

    AdminLogin() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.BLUE);
        p1.setBounds(0, 0, 400, 400);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/log.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);
        p1.setLayout(null);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel theusername = new JLabel("Admin Name");
        theusername.setBounds(60, 20, 200, 25);
        theusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(theusername);

        tusername = new JTextField();
        tusername.setName("Admin");
        tusername.setBounds(60, 60, 300, 30);
        tusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tusername);

        JLabel thepassword = new JLabel("Password");
        thepassword.setBounds(60, 110, 100, 25);
        thepassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(thepassword);

        tpassword = new JPasswordField();
        tpassword.setName("nimda");
        tpassword.setBounds(60, 150, 300, 30);
        tpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tpassword);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(Color.GREEN);
        login.addActionListener(this);
        p2.add(login);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tusername.getText();
            String password = tpassword.getText();

           
            if ("Admin".equals(username) && "nimda".equals(password)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                    setVisible(false);
                    new AdminDashboard(username);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new AdminLogin();
    }
}
