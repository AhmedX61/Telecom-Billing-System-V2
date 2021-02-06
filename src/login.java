import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 
public class login extends JFrame implements MouseListener{

    JPanel panel;
    Color color;
    Font font1,font2,font3,font4;
    JTextField textfield;
    JPasswordField passwordfield;
    JLabel[] label;
    Connection connection;
    PreparedStatement preparedstatement = null;
    ResultSet resultset = null;
    String sql;
    
    public login() {
        
        this.setLocation(500, 200);
        this.setSize(300, 320);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        label = new JLabel[10];
        color = new Color(0,102,102);
        font1 = new Font("seirf", Font.BOLD, 25);
        font2 = new Font("seirf", Font.CENTER_BASELINE, 20);
        font3 = new Font("seirf", Font.CENTER_BASELINE, 16);
        font4 = new Font("seirf", Font.BOLD, 13);
        
        panel.setBackground(color);
        panel.setLayout(null);
        this.add(panel);
        
        label[0] = new JLabel("Login");
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(5, 0, 120, 30);
        label[0].setFont(font1);
        panel.add(label[0]);
        
        label[1] = new JLabel("User Name");
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(35, 80, 150, 30);
        label[1].setFont(font3);
        panel.add(label[1]);
        
        label[2] = new JLabel("Password");
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(35, 150, 150, 30);
        label[2].setFont(font3);
        panel.add(label[2]);
        
        textfield = new JTextField();
        textfield.setBounds(35, 110, 220, 30);
        textfield.setFont(font4);
        panel.add(textfield);
        
        passwordfield = new JPasswordField();
        passwordfield.setBounds(35, 180, 220, 30);
        passwordfield.setFont(font4);
        panel.add(passwordfield);
        
        label[3] = new JLabel("   X");
        label[3].setBackground(color);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(250, 0, 50, 30);
        label[3].setFont(font2);
        panel.add(label[3]);
        label[3].addMouseListener(this);
        
        label[4] = new JLabel("  ---");
        label[4].setBackground(color);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(200, 0, 50, 30);
        label[4].setFont(font2);
        panel.add(label[4]);
        label[4].addMouseListener(this);
        
        label[5] = new JLabel("             Login");
        label[5].setBackground(new Color(211, 84, 0));
        label[5].setOpaque(true);
        label[5].setForeground(Color.WHITE);
        label[5].setFont(font3);
        label[5].setBounds(75, 250, 150, 30);
        panel.add(label[5]);
        label[5].addMouseListener(this);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == label[3]) {
            System.exit(0);
        }
        if (me.getSource() == label[4]) {
            this.setState(JFrame.ICONIFIED);
        }
        if (me.getSource() == label[5]) {
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("JDBC:sqlite:tlecome.db");
            System.out.println("Connected");
            if ("admin".equals(textfield.getText())) {
                sql="SELECT * FROM admin WHERE username=? AND pass=?";
                preparedstatement=connection.prepareStatement(sql);
                preparedstatement.setString(1,textfield.getText());
                preparedstatement.setString(2,passwordfield.getText());
                resultset=preparedstatement.executeQuery();
                if (resultset.next()) {
                new admin().setVisible(true);
                this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Wrong");
                }
            }else{
                sql="SELECT * FROM employee WHERE name=? AND pass=?";
                preparedstatement=connection.prepareStatement(sql);
                preparedstatement.setString(1,textfield.getText());
                preparedstatement.setString(2,passwordfield.getText());
                resultset=preparedstatement.executeQuery();
                if (resultset.next()) {
                new employee().setVisible(true);
                this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Wrong");
                }
            }
            
        }catch(Exception e){
            System.out.println("Can't Connect");
            System.out.println(e.getMessage());
        }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == label[3]) {
            label[3].setBackground(Color.RED.brighter());
        }
        if (me.getSource() == label[4]) {
            label[4].setBackground(Color.GRAY.brighter());
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == label[3]) {
            label[3].setBackground(Color.RED.darker());
        }
        if (me.getSource() == label[4]) {
            label[4].setBackground(Color.GRAY);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == label[3]) {
            label[3].setBackground(Color.RED.darker());
        }
        if (me.getSource() == label[4]) {
            label[4].setBackground(Color.GRAY);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == label[3]) {
            label[3].setBackground(color);
        }
        if (me.getSource() == label[4]) {
            label[4].setBackground(color);
        }
    }
}
