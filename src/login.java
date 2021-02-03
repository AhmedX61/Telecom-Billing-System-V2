import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 
public class login extends JFrame implements MouseListener{

    JPanel panel;
    Color c;
    Font f1,f2,f3,f4;
    JTextField t;
    JPasswordField pf;
    JLabel[] l;
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String log;
    
    public login() {
        
        this.setLocation(500, 200);
        this.setSize(300, 320);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        l = new JLabel[10];
        c = new Color(0,102,102);
        f1 = new Font("seirf", Font.BOLD, 25);
        f2 = new Font("seirf", Font.CENTER_BASELINE, 20);
        f3 = new Font("seirf", Font.CENTER_BASELINE, 16);
        f4 = new Font("seirf", Font.BOLD, 13);
        
        panel.setBackground(c);
        panel.setLayout(null);
        this.add(panel);
        
        l[0] = new JLabel("Login");
        l[0].setForeground(Color.WHITE);
        l[0].setBounds(5, 0, 120, 30);
        l[0].setFont(f1);
        panel.add(l[0]);
        
        l[1] = new JLabel("User Name");
        l[1].setForeground(Color.WHITE);
        l[1].setBounds(35, 80, 150, 30);
        l[1].setFont(f3);
        panel.add(l[1]);
        
        l[2] = new JLabel("Password");
        l[2].setForeground(Color.WHITE);
        l[2].setBounds(35, 150, 150, 30);
        l[2].setFont(f3);
        panel.add(l[2]);
        
        t = new JTextField();
        t.setBounds(35, 110, 220, 30);
        t.setFont(f4);
        panel.add(t);
        
        pf = new JPasswordField();
        pf.setBounds(35, 180, 220, 30);
        pf.setFont(f4);
        panel.add(pf);
        
        l[3] = new JLabel("   X");
        l[3].setBackground(c);
        l[3].setOpaque(true);
        l[3].setForeground(Color.WHITE);
        l[3].setBounds(250, 0, 50, 30);
        l[3].setFont(f2);
        panel.add(l[3]);
        l[3].addMouseListener(this);
        
        l[4] = new JLabel("  ---");
        l[4].setBackground(c);
        l[4].setOpaque(true);
        l[4].setForeground(Color.WHITE);
        l[4].setBounds(200, 0, 50, 30);
        l[4].setFont(f2);
        panel.add(l[4]);
        l[4].addMouseListener(this);
        
        l[5] = new JLabel("             Login");
        l[5].setBackground(new Color(211, 84, 0));
        l[5].setOpaque(true);
        l[5].setForeground(Color.WHITE);
        l[5].setFont(f3);
        l[5].setBounds(75, 250, 150, 30);
        panel.add(l[5]);
        l[5].addMouseListener(this);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == l[3]) {
            System.exit(0);
        }
        if (me.getSource() == l[4]) {
            this.setState(JFrame.ICONIFIED);
        }
        if (me.getSource() == l[5]) {
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("JDBC:sqlite:tlecome.db");
            System.out.println("Connected");
            if ("admin".equals(t.getText())) {
                log="SELECT * FROM admin WHERE username=? AND pass=?";
                ps=conn.prepareStatement(log);
                ps.setString(1,t.getText());
                ps.setString(2,pf.getText());
                rs=ps.executeQuery();
                if (rs.next()) {
                new admin().setVisible(true);
                this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Wrong");
                }
            }else{
                log="SELECT * FROM employee WHERE name=? AND pass=?";
                ps=conn.prepareStatement(log);
                ps.setString(1,t.getText());
                ps.setString(2,pf.getText());
                rs=ps.executeQuery();
                if (rs.next()) {
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
        if (me.getSource() == l[3]) {
            l[3].setBackground(Color.RED.brighter());
        }
        if (me.getSource() == l[4]) {
            l[4].setBackground(Color.GRAY.brighter());
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == l[3]) {
            l[3].setBackground(Color.RED.darker());
        }
        if (me.getSource() == l[4]) {
            l[4].setBackground(Color.GRAY);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == l[3]) {
            l[3].setBackground(Color.RED.darker());
        }
        if (me.getSource() == l[4]) {
            l[4].setBackground(Color.GRAY);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == l[3]) {
            l[3].setBackground(c);
        }
        if (me.getSource() == l[4]) {
            l[4].setBackground(c);
        }
    }
}
