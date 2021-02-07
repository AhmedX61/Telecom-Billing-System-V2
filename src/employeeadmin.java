import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class employeeadmin extends JFrame implements MouseListener{

    JPanel panel;
    JLabel[] label;
    JTextField[] textfield;
    JTable table;
    Color color1,color2;
    Font font1,font2,font3;
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
        
        panel = new JPanel();
        table = new JTable();
        label = new JLabel[20];
        textfield = new JTextField[10];
        color1 = new Color(0, 102, 102);
        color2 = new Color(211, 84, 0);
        bg = new ButtonGroup();
        font1 = new Font("seirf", Font.BOLD, 22);
        font2 = new Font("seirf", Font.BOLD, 25);
        font3 = new Font("seirf", Font.BOLD, 13);
        
        panel.setBackground(color1);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);
        this.add(panel);
        
        table.setBounds(30, 370, 1304, 350);
        panel.add(table);
        
        r1 = new JRadioButton("Male");
        r1.setBackground(color1);
        r1.setBounds(200, 320, 100, 30);
        r1.setFont(font1);
        bg.add(r1);
        panel.add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBackground(color1);
        r2.setBounds(320, 320, 100, 30);
        r2.setFont(font1);
        bg.add(r2);
        panel.add(r2);
        
        textfield[0] = new JTextField();
        textfield[0].setBounds(160, 70, 320, 30);
        textfield[0].setFont(font3);
        panel.add(textfield[0]);
        
        textfield[1] = new JTextField();
        textfield[1].setBounds(160, 120, 320, 30);
        textfield[1].setFont(font3);
        panel.add(textfield[1]);
        
        textfield[2] = new JTextField();
        textfield[2].setBounds(160, 170, 320, 30);
        textfield[2].setFont(font3);
        panel.add(textfield[2]);
        
        textfield[3] = new JTextField();
        textfield[3].setBounds(160, 220, 320, 30);
        textfield[3].setFont(font3);
        panel.add(textfield[3]);
        
        textfield[4] = new JTextField();
        textfield[4].setBounds(160, 270, 320, 30);
        textfield[4].setFont(font3);
        panel.add(textfield[4]);
        
        
        label[0] = new JLabel("Employees: Admin");
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(8, 3, 300, 30);
        label[0].setFont(font2);
        panel.add(label[0]);
        
        label[1] = new JLabel("   X");
        label[1].setBackground(color1);
        label[1].setOpaque(true);
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(1315, 1, 50, 30);
        label[1].setFont(font1);
        panel.add(label[1]);
        label[1].addMouseListener(this);
        
        label[2] = new JLabel("  ---");
        label[2].setBackground(color1);
        label[2].setOpaque(true);
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(1265, 1, 50, 30);
        label[2].setFont(font1);
        panel.add(label[2]);
        label[2].addMouseListener(this);
        
        label[3] = new JLabel("Name:");
        label[3].setBackground(color1);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(20, 70, 120, 30);
        label[3].setFont(font1);
        panel.add(label[3]);
        label[3].addMouseListener(this);
        
        label[4] = new JLabel("Phone:");
        label[4].setBackground(color1);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(20, 120, 120, 30);
        label[4].setFont(font1);
        panel.add(label[4]);
        label[4].addMouseListener(this);
        
        label[5] = new JLabel("E-Mail:");
        label[5].setBackground(color1);
        label[5].setOpaque(true);
        label[5].setForeground(Color.WHITE);
        label[5].setBounds(20, 170, 120, 30);
        label[5].setFont(font1);
        panel.add(label[5]);
        label[5].addMouseListener(this);
        
        label[6] = new JLabel("Password:");
        label[6].setBackground(color1);
        label[6].setOpaque(true);
        label[6].setForeground(Color.WHITE);
        label[6].setBounds(20, 220, 120, 30);
        label[6].setFont(font1);
        panel.add(label[6]);
        label[6].addMouseListener(this);
        
        label[7] = new JLabel("Address:");
        label[7].setBackground(color1);
        label[7].setOpaque(true);
        label[7].setForeground(Color.WHITE);
        label[7].setBounds(20, 270, 120, 30);
        label[7].setFont(font1);
        panel.add(label[7]);
        label[7].addMouseListener(this);
        
        label[8] = new JLabel("Gender:");
        label[8].setBackground(color1);
        label[8].setOpaque(true);
        label[8].setForeground(Color.WHITE);
        label[8].setBounds(20, 320, 120, 30);
        label[8].setFont(font1);
        panel.add(label[8]);
        label[8].addMouseListener(this);
        
        label[9] = new JLabel("      Add Embloyee");
        label[9].setBackground(color2);
        label[9].setOpaque(true);
        label[9].setForeground(Color.WHITE);
        label[9].setBounds(1100, 50, 210, 30);
        label[9].setFont(font1);
        panel.add(label[9]);
        label[9].addMouseListener(this);
        
        label[10] = new JLabel("    Delete Embloyee");
        label[10].setBackground(color2);
        label[10].setOpaque(true);
        label[10].setForeground(Color.WHITE);
        label[10].setBounds(1100, 100, 210, 30);
        label[10].setFont(font1);
        panel.add(label[10]);
        label[10].addMouseListener(this);
        
        label[11] = new JLabel("   Update Embloyee");
        label[11].setBackground(color2);
        label[11].setOpaque(true);
        label[11].setForeground(Color.WHITE);
        label[11].setBounds(1100, 150, 210, 30);
        label[11].setFont(font1);
        panel.add(label[11]);
        label[11].addMouseListener(this);
        
        label[14] = new JLabel("    Show to Update");
        label[14].setBackground(color2);
        label[14].setOpaque(true);
        label[14].setForeground(Color.WHITE);
        label[14].setBounds(1100, 200, 210, 30);
        label[14].setFont(font1);
        panel.add(label[14]);
        label[14].addMouseListener(this);
        
        label[12] = new JLabel(" Show All Embloyee");
        label[12].setBackground(color2);
        label[12].setOpaque(true);
        label[12].setForeground(Color.WHITE);
        label[12].setBounds(1100, 250, 210, 30);
        label[12].setFont(font1);
        panel.add(label[12]);
        label[12].addMouseListener(this);
        
        label[13] = new JLabel("             Back");
        label[13].setBackground(color2);
        label[13].setOpaque(true);
        label[13].setForeground(Color.WHITE);
        label[13].setBounds(1100, 300, 210, 30);
        label[13].setFont(font1);
        panel.add(label[13]);
        label[13].addMouseListener(this);
        
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
        if (me.getSource() == label[1]) {
        System.exit(0);
        }
        if (me.getSource() == label[2]) {
            this.setState(JFrame.ICONIFIED);
        }
        if (me.getSource() == label[13]){
            this.setVisible(false);
            admin ha = new admin();
            ha.setVisible(true);
        }
        if (me.getSource() == label[12]) {
            Displaytable();
        }
        if (me.getSource() == label[9]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                log = "INSERT INTO employee VALUES(?,?,?,?,?,?)";
                ps = conn.prepareStatement(log);
                ps.setString(1, textfield[0].getText());
                ps.setString(2, textfield[1].getText());
                ps.setString(3, textfield[2].getText());
                ps.setString(4, textfield[3].getText());
                ps.setString(5, textfield[4].getText());
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
        if (me.getSource() == label[10]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                log = "DELETE FROM employee WHERE phone="+textfield[2].getText();
                ps = conn.prepareStatement(log);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Deleted!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == label[11]) {
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                log = "UPDATE employee SET name=?,phone=?,email=?,pass=?,address=? WHERE phone="+textfield[2].getText();
                ps = conn.prepareStatement(log);
                ps.setString(1, textfield[0].getText());
                ps.setString(2, textfield[1].getText());
                ps.setString(3, textfield[2].getText());
                ps.setString(4, textfield[3].getText());
                ps.setString(5, textfield[4].getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Updated!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == label[14]) {
            int i = table.getSelectedRow();
            TableModel model = table.getModel();
            textfield[0].setText(model.getValueAt(i, 0).toString());
            textfield[1].setText(model.getValueAt(i, 1).toString());
            textfield[2].setText(model.getValueAt(i, 2).toString());
            textfield[3].setText(model.getValueAt(i, 3).toString());
            textfield[4].setText(model.getValueAt(i, 4).toString());
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
            label[1].setBackground(color1);
        }
        if (me.getSource() == label[2]) {
            label[2].setBackground(color1);
        }
    }
    
}
