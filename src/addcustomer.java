import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class addcustomer extends JFrame implements MouseListener{
    
    JPanel panel;
    JLabel[] label;
    JTextField textfield1,textfield2,textfield3;
    JTable table;
    Color color1,color2;
    Font font1,font2,font3;
    Connection connection;
    PreparedStatement preparedstatement = null;
    ResultSet resultset = null;
    String sql;
    
    public addcustomer() {
        
        this.setLocation(1, 1);
        this.setSize(1364,736);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        table = new JTable();
        label = new JLabel[20];
        textfield1 = new JTextField();
        textfield2 = new JTextField();
        textfield3 = new JTextField();
        color1 = new Color(0, 102, 102);
        color2 = new Color(211, 84, 0);
        font1 = new Font("seirf", Font.BOLD, 22);
        font2 = new Font("seirf", Font.BOLD, 25);
        font3 = new Font("seirf", Font.BOLD, 18);
        
        panel.setBackground(color1);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);
        this.add(panel);
        
        textfield2.setBounds(160, 100, 300, 35);
        textfield2.setFont(font1);
        panel.add(textfield2);
        
        textfield3.setBounds(160, 160, 300, 35);
        textfield3.setFont(font1);
        panel.add(textfield3);
        
        table.setBounds(30, 300, 1304, 410);
        panel.add(table);
        
        label[0] = new JLabel("Add New Customer");
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
        
        label[4] = new JLabel("Name:");
        label[4].setBackground(color1);
        label[4].setOpaque(true);
        label[4].setForeground(Color.BLACK);
        label[4].setBounds(70, 100, 175, 30);
        label[4].setFont(font1);
        panel.add(label[4]);
        
        label[5] = new JLabel("Phone:");
        label[5].setBackground(color1);
        label[5].setOpaque(true);
        label[5].setForeground(Color.BLACK);
        label[5].setBounds(70, 160, 175, 30);
        label[5].setFont(font1);
        panel.add(label[5]);
        
        label[6] = new JLabel("     Add");
        label[6].setBackground(color2);
        label[6].setOpaque(true);
        label[6].setForeground(Color.WHITE);
        label[6].setBounds(120, 240, 100, 30);
        label[6].setFont(font1);
        panel.add(label[6]);
        label[6].addMouseListener(this);
        
        label[7] = new JLabel("   Delete");
        label[7].setBackground(color2);
        label[7].setOpaque(true);
        label[7].setForeground(Color.WHITE);
        label[7].setBounds(240, 240, 100, 30);
        label[7].setFont(font1);
        panel.add(label[7]);
        label[7].addMouseListener(this);
        
        label[8] = new JLabel("   Update");
        label[8].setBackground(color2);
        label[8].setOpaque(true);
        label[8].setForeground(Color.WHITE);
        label[8].setBounds(360, 240, 110, 30);
        label[8].setFont(font1);
        panel.add(label[8]);
        label[8].addMouseListener(this);
        
        label[3] = new JLabel("   Show to Update");
        label[3].setBackground(color2);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(480, 240, 200, 30);
        label[3].setFont(font1);
        panel.add(label[3]);
        label[3].addMouseListener(this);
        
        label[9] = new JLabel("  Show All Customers");
        label[9].setBackground(color2);
        label[9].setOpaque(true);
        label[9].setForeground(Color.WHITE);
        label[9].setBounds(690, 240, 230, 30);
        label[9].setFont(font1);
        panel.add(label[9]);
        label[9].addMouseListener(this);
        
        label[10] = new JLabel("        Back");
        label[10].setBackground(color2);
        label[10].setOpaque(true);
        label[10].setForeground(Color.WHITE);
        label[10].setBounds(1150, 240, 150, 30);
        label[10].setFont(font1);
        panel.add(label[10]);
        label[10].addMouseListener(this);
    }
    
    private void Displaytable(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
            System.out.println("Connected");
            sql = "SELECT * FROM customer";
            preparedstatement = connection.prepareStatement(sql);
            resultset = preparedstatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultset));
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
        if (me.getSource() == label[10]) {
            this.setVisible(false);
            employee log = new employee();
            log.setVisible(true);
        }
        if (me.getSource() == label[9]) {
            Displaytable();
        }
        if (me.getSource() == label[3]) {
            int i = table.getSelectedRow();
            TableModel model = table.getModel();
            textfield2.setText(model.getValueAt(i, 0).toString());
            textfield3.setText(model.getValueAt(i, 1).toString());
        }
        if (me.getSource() == label[6]) {
            try{
                Class.forName("org.sqlite.JDBC");
                connection=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                sql = "INSERT INTO customer(name,phone,date) VALUES(?,?,datetime())";
                preparedstatement = connection.prepareStatement(sql);
                preparedstatement.setString(1, textfield2.getText());
                preparedstatement.setString(2, textfield3.getText());
                preparedstatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Added!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == label[7]) {
            try{
                Class.forName("org.sqlite.JDBC");
                connection=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                sql = "DELETE FROM customer WHERE phone="+textfield3.getText();
                preparedstatement = connection.prepareStatement(sql);
                preparedstatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Deleted!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == label[8]) {
            try{
                Class.forName("org.sqlite.JDBC");
                connection=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                sql = "UPDATE customer SET name=?,phone=? WHERE phone="+textfield3.getText();
                preparedstatement = connection.prepareStatement(sql);
                preparedstatement.setString(1, textfield2.getText());
                preparedstatement.setString(2, textfield3.getText());
                preparedstatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Updated!");
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
            label[1].setBackground(color1);
        }
        if (me.getSource() == label[2]) {
            label[2].setBackground(color1);
        }
    }
}
