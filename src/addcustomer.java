import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class addcustomer extends JFrame implements MouseListener{
    
     JPanel p;
    JLabel[] l;
    JTextField t,t1,t2;
    JTable table;
    Color c,c1;
    Font f,f1,f2;
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String log;
    
    public addcustomer() {
        
        this.setLocation(1, 1);
        this.setSize(1364,736);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new JPanel();
        table = new JTable();
        l = new JLabel[20];
        t = new JTextField();
        t1 = new JTextField();
        t2 = new JTextField();
        c = new Color(0, 102, 102);
        c1 = new Color(211, 84, 0);
        f = new Font("seirf", Font.BOLD, 22);
        f1 = new Font("seirf", Font.BOLD, 25);
        f2 = new Font("seirf", Font.BOLD, 18);
        
        p.setBackground(c);
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        p.setLayout(null);
        this.add(p);
        
        t1.setBounds(160, 100, 300, 35);
        t1.setFont(f);
        p.add(t1);
        
        t2.setBounds(160, 160, 300, 35);
        t2.setFont(f);
        p.add(t2);
        
        table.setBounds(30, 300, 1304, 410);
        p.add(table);
        
        l[0] = new JLabel("Add New Customer");
        l[0].setForeground(Color.WHITE);
        l[0].setBounds(8, 3, 300, 30);
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
        
        l[4] = new JLabel("Name:");
        l[4].setBackground(c);
        l[4].setOpaque(true);
        l[4].setForeground(Color.BLACK);
        l[4].setBounds(70, 100, 175, 30);
        l[4].setFont(f);
        p.add(l[4]);
        
        l[5] = new JLabel("Phone:");
        l[5].setBackground(c);
        l[5].setOpaque(true);
        l[5].setForeground(Color.BLACK);
        l[5].setBounds(70, 160, 175, 30);
        l[5].setFont(f);
        p.add(l[5]);
        
        l[6] = new JLabel("     Add");
        l[6].setBackground(c1);
        l[6].setOpaque(true);
        l[6].setForeground(Color.WHITE);
        l[6].setBounds(120, 240, 100, 30);
        l[6].setFont(f);
        p.add(l[6]);
        l[6].addMouseListener(this);
        
        l[7] = new JLabel("   Delete");
        l[7].setBackground(c1);
        l[7].setOpaque(true);
        l[7].setForeground(Color.WHITE);
        l[7].setBounds(240, 240, 100, 30);
        l[7].setFont(f);
        p.add(l[7]);
        l[7].addMouseListener(this);
        
        l[8] = new JLabel("   Update");
        l[8].setBackground(c1);
        l[8].setOpaque(true);
        l[8].setForeground(Color.WHITE);
        l[8].setBounds(360, 240, 110, 30);
        l[8].setFont(f);
        p.add(l[8]);
        l[8].addMouseListener(this);
        
        l[3] = new JLabel("   Show to Update");
        l[3].setBackground(c1);
        l[3].setOpaque(true);
        l[3].setForeground(Color.WHITE);
        l[3].setBounds(480, 240, 200, 30);
        l[3].setFont(f);
        p.add(l[3]);
        l[3].addMouseListener(this);
        
        l[9] = new JLabel("  Show All Customers");
        l[9].setBackground(c1);
        l[9].setOpaque(true);
        l[9].setForeground(Color.WHITE);
        l[9].setBounds(690, 240, 230, 30);
        l[9].setFont(f);
        p.add(l[9]);
        l[9].addMouseListener(this);
        
        l[10] = new JLabel("        Back");
        l[10].setBackground(c1);
        l[10].setOpaque(true);
        l[10].setForeground(Color.WHITE);
        l[10].setBounds(1150, 240, 150, 30);
        l[10].setFont(f);
        p.add(l[10]);
        l[10].addMouseListener(this);
    }
    
    private void Displaytable(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
            System.out.println("Connected");
            log = "SELECT * FROM customer";
            ps = conn.prepareStatement(log);
            rs = ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == l[1]) {
        System.exit(0);
        }
        if (me.getSource() == l[2]) {
            this.setState(JFrame.ICONIFIED);
        }
        if (me.getSource() == l[10]) {
            this.setVisible(false);
            employee log = new employee();
            log.setVisible(true);
        }
        if (me.getSource() == l[9]) {
            Displaytable();
        }
        if (me.getSource() == l[3]) {
            int i = table.getSelectedRow();
            TableModel model = table.getModel();
            t1.setText(model.getValueAt(i, 0).toString());
            t2.setText(model.getValueAt(i, 1).toString());
        }
        if (me.getSource() == l[6]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                log = "INSERT INTO customer(name,phone,date) VALUES(?,?,datetime())";
                ps = conn.prepareStatement(log);
                ps.setString(1, t1.getText());
                ps.setString(2, t2.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Added!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == l[7]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                log = "DELETE FROM customer WHERE phone="+t2.getText();
                ps = conn.prepareStatement(log);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Deleted!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == l[8]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                log = "UPDATE customer SET name=?,phone=? WHERE phone="+t2.getText();
                ps = conn.prepareStatement(log);
                ps.setString(1, t1.getText());
                ps.setString(2, t2.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Updated!");
            }catch(Exception e){
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
