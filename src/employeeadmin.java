import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class employeeadmin extends JFrame implements MouseListener{

    JPanel p;
    JLabel[] l;
    JTextField[] t;
    JTable table;
    Color c,c1;
    Font f,f1,f2;
    JRadioButton r1,r2;
    ButtonGroup bg;
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String log;
    
    public employeeadmin(){
        
        this.setLocation(1, 1);
        this.setSize(1364,736);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new JPanel();
        table = new JTable();
        l = new JLabel[20];
        t = new JTextField[10];
        c = new Color(0, 102, 102);
        c1 = new Color(211, 84, 0);
        bg = new ButtonGroup();
        f = new Font("seirf", Font.BOLD, 22);
        f1 = new Font("seirf", Font.BOLD, 25);
        f2 = new Font("seirf", Font.BOLD, 13);
        
        p.setBackground(c);
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        p.setLayout(null);
        this.add(p);
        
        table.setBounds(30, 370, 1304, 350);
        p.add(table);
        
        r1 = new JRadioButton("Male");
        r1.setBackground(c);
        r1.setBounds(200, 320, 100, 30);
        r1.setFont(f);
        bg.add(r1);
        p.add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBackground(c);
        r2.setBounds(320, 320, 100, 30);
        r2.setFont(f);
        bg.add(r2);
        p.add(r2);
        
        t[0] = new JTextField();
        t[0].setBounds(160, 70, 320, 30);
        t[0].setFont(f2);
        p.add(t[0]);
        
        t[1] = new JTextField();
        t[1].setBounds(160, 120, 320, 30);
        t[1].setFont(f2);
        p.add(t[1]);
        
        t[2] = new JTextField();
        t[2].setBounds(160, 170, 320, 30);
        t[2].setFont(f2);
        p.add(t[2]);
        
        t[3] = new JTextField();
        t[3].setBounds(160, 220, 320, 30);
        t[3].setFont(f2);
        p.add(t[3]);
        
        t[4] = new JTextField();
        t[4].setBounds(160, 270, 320, 30);
        t[4].setFont(f2);
        p.add(t[4]);
        
        
        l[0] = new JLabel("Employees: Admin");
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
        
        l[3] = new JLabel("Name:");
        l[3].setBackground(c);
        l[3].setOpaque(true);
        l[3].setForeground(Color.WHITE);
        l[3].setBounds(20, 70, 120, 30);
        l[3].setFont(f);
        p.add(l[3]);
        l[3].addMouseListener(this);
        
        l[4] = new JLabel("Phone:");
        l[4].setBackground(c);
        l[4].setOpaque(true);
        l[4].setForeground(Color.WHITE);
        l[4].setBounds(20, 120, 120, 30);
        l[4].setFont(f);
        p.add(l[4]);
        l[4].addMouseListener(this);
        
        l[5] = new JLabel("E-Mail:");
        l[5].setBackground(c);
        l[5].setOpaque(true);
        l[5].setForeground(Color.WHITE);
        l[5].setBounds(20, 170, 120, 30);
        l[5].setFont(f);
        p.add(l[5]);
        l[5].addMouseListener(this);
        
        l[6] = new JLabel("Password:");
        l[6].setBackground(c);
        l[6].setOpaque(true);
        l[6].setForeground(Color.WHITE);
        l[6].setBounds(20, 220, 120, 30);
        l[6].setFont(f);
        p.add(l[6]);
        l[6].addMouseListener(this);
        
        l[7] = new JLabel("Address:");
        l[7].setBackground(c);
        l[7].setOpaque(true);
        l[7].setForeground(Color.WHITE);
        l[7].setBounds(20, 270, 120, 30);
        l[7].setFont(f);
        p.add(l[7]);
        l[7].addMouseListener(this);
        
        l[8] = new JLabel("Gender:");
        l[8].setBackground(c);
        l[8].setOpaque(true);
        l[8].setForeground(Color.WHITE);
        l[8].setBounds(20, 320, 120, 30);
        l[8].setFont(f);
        p.add(l[8]);
        l[8].addMouseListener(this);
        
        l[9] = new JLabel("      Add Embloyee");
        l[9].setBackground(c1);
        l[9].setOpaque(true);
        l[9].setForeground(Color.WHITE);
        l[9].setBounds(1100, 50, 210, 30);
        l[9].setFont(f);
        p.add(l[9]);
        l[9].addMouseListener(this);
        
        l[10] = new JLabel("    Delete Embloyee");
        l[10].setBackground(c1);
        l[10].setOpaque(true);
        l[10].setForeground(Color.WHITE);
        l[10].setBounds(1100, 100, 210, 30);
        l[10].setFont(f);
        p.add(l[10]);
        l[10].addMouseListener(this);
        
        l[11] = new JLabel("   Update Embloyee");
        l[11].setBackground(c1);
        l[11].setOpaque(true);
        l[11].setForeground(Color.WHITE);
        l[11].setBounds(1100, 150, 210, 30);
        l[11].setFont(f);
        p.add(l[11]);
        l[11].addMouseListener(this);
        
        l[14] = new JLabel("    Show to Update");
        l[14].setBackground(c1);
        l[14].setOpaque(true);
        l[14].setForeground(Color.WHITE);
        l[14].setBounds(1100, 200, 210, 30);
        l[14].setFont(f);
        p.add(l[14]);
        l[14].addMouseListener(this);
        
        l[12] = new JLabel(" Show All Embloyee");
        l[12].setBackground(c1);
        l[12].setOpaque(true);
        l[12].setForeground(Color.WHITE);
        l[12].setBounds(1100, 250, 210, 30);
        l[12].setFont(f);
        p.add(l[12]);
        l[12].addMouseListener(this);
        
        l[13] = new JLabel("             Back");
        l[13].setBackground(c1);
        l[13].setOpaque(true);
        l[13].setForeground(Color.WHITE);
        l[13].setBounds(1100, 300, 210, 30);
        l[13].setFont(f);
        p.add(l[13]);
        l[13].addMouseListener(this);
        
    }
    
    private void Displaytable(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
            System.out.println("Connected");
            log = "SELECT * FROM employee";
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
        if (me.getSource() == l[13]){
            this.setVisible(false);
            admin ha = new admin();
            ha.setVisible(true);
        }
        if (me.getSource() == l[12]) {
            Displaytable();
        }
        if (me.getSource() == l[9]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                log = "INSERT INTO employee VALUES(?,?,?,?,?,?)";
                ps = conn.prepareStatement(log);
                ps.setString(1, t[0].getText());
                ps.setString(2, t[1].getText());
                ps.setString(3, t[2].getText());
                ps.setString(4, t[3].getText());
                ps.setString(5, t[4].getText());
                if (r1.isSelected()) {
                    ps.setString(6, "Male");
                }else if(r2.isSelected()){
                    ps.setString(6, "Female");
                }
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Added!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == l[10]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                log = "DELETE FROM employee WHERE phone="+t[2].getText();
                ps = conn.prepareStatement(log);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Deleted!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == l[11]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                log = "UPDATE employee SET name=?,phone=?,email=?,pass=?,address=? WHERE phone="+t[2].getText();
                ps = conn.prepareStatement(log);
                ps.setString(1, t[0].getText());
                ps.setString(2, t[1].getText());
                ps.setString(3, t[2].getText());
                ps.setString(4, t[3].getText());
                ps.setString(5, t[4].getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Updated!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == l[14]) {
            int i = table.getSelectedRow();
            TableModel model = table.getModel();
            t[0].setText(model.getValueAt(i, 0).toString());
            t[1].setText(model.getValueAt(i, 1).toString());
            t[2].setText(model.getValueAt(i, 2).toString());
            t[3].setText(model.getValueAt(i, 3).toString());
            t[4].setText(model.getValueAt(i, 4).toString());
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
