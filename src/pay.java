import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class pay extends JFrame implements MouseListener{

    JPanel p;
    JLabel[] l;
    JTextField t,t1;
    JTextArea tarea;
    Color c,c1;
    Font f,f1,f2;
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String log;
    
    public pay() {
        
        this.setLocation(1, 1);
        this.setSize(1364,736);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new JPanel();
        l = new JLabel[20];
        t = new JTextField();
        t1 = new JTextField();
        tarea = new JTextArea();
        c = new Color(0, 102, 102);
        c1 = new Color(211, 84, 0);
        f = new Font("seirf", Font.BOLD, 22);
        f1 = new Font("seirf", Font.BOLD, 25);
        f2 = new Font("seirf", Font.BOLD, 18);
        
        p.setBackground(c);
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        p.setLayout(null);
        this.add(p);
        
        tarea.setBounds(450, 280, 450, 400);
        tarea.setFont(f);
        p.add(tarea);
        
        t.setBounds(300, 145, 720, 35);
        t.setFont(f);
        p.add(t);
        
        t1.setBounds(100, 420, 200, 35);
        t1.setFont(f);
        p.add(t1);
        
        l[0] = new JLabel("Pay Bills");
        l[0].setForeground(Color.WHITE);
        l[0].setBounds(8, 3, 200, 30);
        l[0].setFont(f1);
        p.add(l[0]);
        
        l[1] = new JLabel("   X");
        l[1].setBackground(c);
        l[1].setOpaque(true);
        l[1].setForeground(Color.WHITE);
        l[1].setBounds(1315, 1, 50, 30);
        l[1].setFont(f);
        p.add(l[1]);
        l[1].addMouseListener(this);
        
        l[2] = new JLabel("  ---");
        l[2].setBackground(c);
        l[2].setOpaque(true);
        l[2].setForeground(Color.WHITE);
        l[2].setBounds(1265, 1, 50, 30);
        l[2].setFont(f);
        p.add(l[2]);
        l[2].addMouseListener(this);
        
        l[3] = new JLabel("           Search");
        l[3].setBackground(c1);
        l[3].setOpaque(true);
        l[3].setForeground(Color.WHITE);
        l[3].setBounds(300, 85, 200, 30);
        l[3].setFont(f);
        p.add(l[3]);
        l[3].addMouseListener(this);
        
        l[4] = new JLabel("       New Search");
        l[4].setBackground(c1);
        l[4].setOpaque(true);
        l[4].setForeground(Color.WHITE);
        l[4].setBounds(560, 85, 200, 30);
        l[4].setFont(f);
        p.add(l[4]);
        l[4].addMouseListener(this);
        
        l[5] = new JLabel("Customer Name:");
        l[5].setBackground(c);
        l[5].setOpaque(true);
        l[5].setForeground(Color.BLACK);
        l[5].setBounds(300, 215, 175, 30);
        l[5].setFont(f);
        p.add(l[5]);
        
        l[6] = new JLabel("Phone Number:");
        l[6].setBackground(c);
        l[6].setOpaque(true);
        l[6].setForeground(Color.BLACK);
        l[6].setBounds(720, 215, 164, 30);
        l[6].setFont(f);
        p.add(l[6]);
        
        l[7] = new JLabel("");
        l[7].setBackground(c);
        l[7].setOpaque(true);
        l[7].setForeground(new Color(245, 229, 27));
        l[7].setBounds(480, 217, 220, 30);
        l[7].setFont(f2);
        p.add(l[7]);
        
        l[8] = new JLabel("");
        l[8].setBackground(c);
        l[8].setOpaque(true);
        l[8].setForeground(new Color(245, 229, 27));
        l[8].setBounds(889, 217, 220, 30);
        l[8].setFont(f2);
        p.add(l[8]);
        
        l[9] = new JLabel("              Pay");
        l[9].setBackground(c1);
        l[9].setOpaque(true);
        l[9].setForeground(Color.WHITE);
        l[9].setBounds(100, 300, 200, 30);
        l[9].setFont(f);
        p.add(l[9]);
        l[9].addMouseListener(this);
        
        l[10] = new JLabel("            Back");
        l[10].setBackground(c1);
        l[10].setOpaque(true);
        l[10].setForeground(Color.WHITE);
        l[10].setBounds(820, 85, 200, 30);
        l[10].setFont(f);
        p.add(l[10]);
        l[10].addMouseListener(this);
        
        l[11] = new JLabel("        Check out");
        l[11].setBackground(c1);
        l[11].setOpaque(true);
        l[11].setForeground(Color.WHITE);
        l[11].setBounds(100, 500, 200, 30);
        l[11].setFont(f);
        p.add(l[11]);
        l[11].addMouseListener(this);
        
        l[12] = new JLabel("");
        l[12].setBackground(c);
        l[12].setOpaque(true);
        l[12].setForeground(new Color(245, 229, 27));
        l[12].setBounds(100, 365, 200, 30);
        l[12].setFont(f2);
        p.add(l[12]);
        
        l[13] = new JLabel("            Print");
        l[13].setBackground(c1);
        l[13].setOpaque(true);
        l[13].setForeground(Color.WHITE);
        l[13].setBounds(100, 550, 200, 30);
        l[13].setFont(f);
        p.add(l[13]);
        l[13].addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == l[1]) {
        System.exit(0);
        }
        if (me.getSource() == l[2]) {
            this.setState(JFrame.ICONIFIED);
        }
        if (me.getSource() == l[3]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                log = "SELECT * FROM customer WHERE phone=?";
                ps = conn.prepareStatement(log);
                ps.setString(1,t.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    l[7].setText(rs.getString("name"));
                    l[8].setText(rs.getString("phone"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "NO Element Found");
                }
                conn.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == l[4]) {
            t.setText("");
            l[7].setText("");
            l[8].setText("");
        }
        if (me.getSource() == l[9]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                log = "SELECT * FROM customer WHERE phone=?";
                ps = conn.prepareStatement(log);
                ps.setString(1,t.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    l[12].setText(rs.getString("subscrption"));
                }else{
                    JOptionPane.showMessageDialog(null, "NO Element Found");
                }
                conn.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == l[11]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                log = "INSERT INTO customer VALUES("+l[7].getText()+","+l[8].getText()+",?,datetime())";
                ps = conn.prepareStatement(log);
                ps.setString(1, t1.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Palance Added!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            int x = Integer.valueOf(t1.getText())-74;
            tarea.setText("\n=============== Bill ==============="
            +"\n\nCustomer Name: "+l[7].getText()
            +"\n\nCustomer Number: "+l[8].getText()
            +"\n\nCustomer Subscrption: "+l[12].getText()
            +"\n\nAmount: "+t1.getText()
            +"\n\nReturned: "+x);
        }
        if (me.getSource() == l[13]) {
            try{
            tarea.setText(tarea.getText());
            tarea.print();
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == l[1]) {
            l[1].setBackground(Color.RED.brighter());
        }
        if (me.getSource() == l[2]) {
            l[2].setBackground(Color.GRAY.brighter());
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == l[1]) {
            l[1].setBackground(Color.RED.darker());
        }
        if (me.getSource() == l[2]) {
            l[2].setBackground(Color.GRAY);
        }
        if (me.getSource() == l[10]) {
            this.setVisible(false);
            employee log = new employee();
            log.setVisible(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == l[1]) {
            l[1].setBackground(Color.RED.darker());
        }
        if (me.getSource() == l[2]) {
            l[2].setBackground(Color.GRAY);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == l[1]) {
            l[1].setBackground(c);
        }
        if (me.getSource() == l[2]) {
            l[2].setBackground(c);
        }
    }
    
}
