import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class history extends JFrame implements MouseListener{

    
    JPanel panel;
    JLabel[] label;
    JTextField textfield;
    JTable table;
    Color c,c1;
    Font f,f1,f2;
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String log;
    
    public history() {
        
        this.setLocation(1, 1);
        this.setSize(1364,736);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        table = new JTable();
        label = new JLabel[20];
        textfield = new JTextField();
        c = new Color(0, 102, 102);
        c1 = new Color(211, 84, 0);
        f = new Font("seirf", Font.BOLD, 22);
        f1 = new Font("seirf", Font.BOLD, 25);
        f2 = new Font("seirf", Font.BOLD, 18);
        
        panel.setBackground(c);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);
        this.add(panel);
        
        textfield.setBounds(440, 145, 680, 35);
        textfield.setFont(f);
        panel.add(textfield);
        
        table.setBounds(30, 300, 1304, 410);
        panel.add(table);
        
        label[0] = new JLabel("Bill's History");
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(8, 3, 200, 30);
        label[0].setFont(f1);
        panel.add(label[0]);
        
        label[1] = new JLabel("   X");
        label[1].setBackground(c);
        label[1].setOpaque(true);
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(1315, 1, 50, 30);
        label[1].setFont(f);
        panel.add(label[1]);
        label[1].addMouseListener(this);
        
        label[2] = new JLabel("  ---");
        label[2].setBackground(c);
        label[2].setOpaque(true);
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(1265, 1, 50, 30);
        label[2].setFont(f);
        panel.add(label[2]);
        label[2].addMouseListener(this);
        
        label[3] = new JLabel("           Search");
        label[3].setBackground(c1);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(200, 148, 200, 30);
        label[3].setFont(f);
        panel.add(label[3]);
        label[3].addMouseListener(this);
        
        label[4] = new JLabel("       New Search");
        label[4].setBackground(c1);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(200, 85, 200, 30);
        label[4].setFont(f);
        panel.add(label[4]);
        label[4].addMouseListener(this);
        
        label[5] = new JLabel("Customer Name:");
        label[5].setBackground(c);
        label[5].setOpaque(true);
        label[5].setForeground(Color.BLACK);
        label[5].setBounds(440, 215, 175, 30);
        label[5].setFont(f);
        panel.add(label[5]);
        
        label[6] = new JLabel("Phone Number:");
        label[6].setBackground(c);
        label[6].setOpaque(true);
        label[6].setForeground(Color.BLACK);
        label[6].setBounds(860, 215, 164, 30);
        label[6].setFont(f);
        panel.add(label[6]);
        
        label[7] = new JLabel("");
        label[7].setBackground(c);
        label[7].setOpaque(true);
        label[7].setForeground(new Color(245, 229, 27));
        label[7].setBounds(620, 217, 220, 30);
        label[7].setFont(f2);
        panel.add(label[7]);
        
        label[8] = new JLabel("");
        label[8].setBackground(c);
        label[8].setOpaque(true);
        label[8].setForeground(new Color(245, 229, 27));
        label[8].setBounds(1029, 217, 220, 30);
        label[8].setFont(f2);
        panel.add(label[8]);
        
        label[9] = new JLabel("      View History");
        label[9].setBackground(c1);
        label[9].setOpaque(true);
        label[9].setForeground(Color.WHITE);
        label[9].setBounds(440, 85, 200, 30);
        label[9].setFont(f);
        panel.add(label[9]);
        label[9].addMouseListener(this);
        
        label[10] = new JLabel("         All History");
        label[10].setBackground(c1);
        label[10].setOpaque(true);
        label[10].setForeground(Color.WHITE);
        label[10].setBounds(680, 85, 200, 30);
        label[10].setFont(f);
        panel.add(label[10]);
        label[10].addMouseListener(this);
        
        label[11] = new JLabel("            Back");
        label[11].setBackground(c1);
        label[11].setOpaque(true);
        label[11].setForeground(Color.WHITE);
        label[11].setBounds(920, 85, 200, 30);
        label[11].setFont(f);
        panel.add(label[11]);
        label[11].addMouseListener(this);
        
    }
    
    private void CustomerHistory(){
        try{
             
            Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
            System.out.println("Connected");
            log = "SELECT * FROM customer WHERE Phone=?";
            ps = conn.prepareStatement(log);
            ps.setString(1,textfield.getText());
            rs = ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            conn.close();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
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
        if (me.getSource() == label[1]) {
        System.exit(0);
        }
        if (me.getSource() == label[2]) {
            this.setState(JFrame.ICONIFIED);
        }
        if (me.getSource() == label[11]) {
            this.setVisible(false);
            employee log = new employee();
            log.setVisible(true);
        }
        if (me.getSource() == label[10]) {
            Displaytable();
        }
        if (me.getSource() == label[9]) {
            CustomerHistory();
        }
        if (me.getSource() == label[4]) {
            textfield.setText("");
            label[7].setText("");
            label[8].setText("");
            CustomerHistory();
        }
        if (me.getSource() == label[3]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                log = "SELECT * FROM customer WHERE phone=?";
                ps = conn.prepareStatement(log);
                ps.setString(1,textfield.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    label[7].setText(rs.getString("name"));
                    label[8].setText(rs.getString("phone"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "NO Element Found");
                }
                conn.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == label[1]) {
            label[1].setBackground(Color.RED.brighter());
        }
        if (me.getSource() == label[2]) {
            label[2].setBackground(Color.GRAY.brighter());
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == label[1]) {
            label[1].setBackground(Color.RED.darker());
        }
        if (me.getSource() == label[2]) {
            label[2].setBackground(Color.GRAY);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == label[1]) {
            label[1].setBackground(Color.RED.darker());
        }
        if (me.getSource() == label[2]) {
            label[2].setBackground(Color.GRAY);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == label[1]) {
            label[1].setBackground(c);
        }
        if (me.getSource() == label[2]) {
            label[2].setBackground(c);
        }
    }
}
