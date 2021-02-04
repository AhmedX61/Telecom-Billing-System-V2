import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.sql.*;
public class pay extends JFrame implements MouseListener{

    JPanel panel;
    JLabel[] label;
    JTextField textfield,textfield1;
    JTextArea textarea;
    Color color,color1;
    Font font,font1,font2;
    Connection connection;
    PreparedStatement preparedstatement = null;
    ResultSet resultset = null;
    String sql;
    
    public pay() {
        
        this.setLocation(1, 1);
        this.setSize(1364,736);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        label = new JLabel[20];
        textfield = new JTextField();
        textfield1 = new JTextField();
        textarea = new JTextArea();
        color = new Color(0, 102, 102);
        color1 = new Color(211, 84, 0);
        font = new Font("seirf", Font.BOLD, 22);
        font1 = new Font("seirf", Font.BOLD, 25);
        font2 = new Font("seirf", Font.BOLD, 18);
        
        panel.setBackground(color);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);
        this.add(panel);
        
        textarea.setBounds(450, 280, 450, 400);
        textarea.setFont(font);
        panel.add(textarea);
        
        textfield.setBounds(300, 145, 720, 35);
        textfield.setFont(font);
        panel.add(textfield);
        
        textfield1.setBounds(100, 420, 200, 35);
        textfield1.setFont(font);
        panel.add(textfield1);
        
        label[0] = new JLabel("Pay Bills");
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(8, 3, 200, 30);
        label[0].setFont(font1);
        panel.add(label[0]);
        
        label[1] = new JLabel("   X");
        label[1].setBackground(color);
        label[1].setOpaque(true);
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(1315, 1, 50, 30);
        label[1].setFont(font);
        panel.add(label[1]);
        label[1].addMouseListener(this);
        
        label[2] = new JLabel("  ---");
        label[2].setBackground(color);
        label[2].setOpaque(true);
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(1265, 1, 50, 30);
        label[2].setFont(font);
        panel.add(label[2]);
        label[2].addMouseListener(this);
        
        label[3] = new JLabel("           Search");
        label[3].setBackground(color1);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(300, 85, 200, 30);
        label[3].setFont(font);
        panel.add(label[3]);
        label[3].addMouseListener(this);
        
        label[4] = new JLabel("       New Search");
        label[4].setBackground(color1);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(560, 85, 200, 30);
        label[4].setFont(font);
        panel.add(label[4]);
        label[4].addMouseListener(this);
        
        label[5] = new JLabel("Customer Name:");
        label[5].setBackground(color);
        label[5].setOpaque(true);
        label[5].setForeground(Color.BLACK);
        label[5].setBounds(300, 215, 175, 30);
        label[5].setFont(font);
        panel.add(label[5]);
        
        label[6] = new JLabel("Phone Number:");
        label[6].setBackground(color);
        label[6].setOpaque(true);
        label[6].setForeground(Color.BLACK);
        label[6].setBounds(720, 215, 164, 30);
        label[6].setFont(font);
        panel.add(label[6]);
        
        label[7] = new JLabel("");
        label[7].setBackground(color);
        label[7].setOpaque(true);
        label[7].setForeground(new Color(245, 229, 27));
        label[7].setBounds(480, 217, 220, 30);
        label[7].setFont(font2);
        panel.add(label[7]);
        
        label[8] = new JLabel("");
        label[8].setBackground(color);
        label[8].setOpaque(true);
        label[8].setForeground(new Color(245, 229, 27));
        label[8].setBounds(889, 217, 220, 30);
        label[8].setFont(font2);
        panel.add(label[8]);
        
        label[9] = new JLabel("              Pay");
        label[9].setBackground(color1);
        label[9].setOpaque(true);
        label[9].setForeground(Color.WHITE);
        label[9].setBounds(100, 300, 200, 30);
        label[9].setFont(font);
        panel.add(label[9]);
        label[9].addMouseListener(this);
        
        label[10] = new JLabel("            Back");
        label[10].setBackground(color1);
        label[10].setOpaque(true);
        label[10].setForeground(Color.WHITE);
        label[10].setBounds(820, 85, 200, 30);
        label[10].setFont(font);
        panel.add(label[10]);
        label[10].addMouseListener(this);
        
        label[11] = new JLabel("        Check out");
        label[11].setBackground(color1);
        label[11].setOpaque(true);
        label[11].setForeground(Color.WHITE);
        label[11].setBounds(100, 500, 200, 30);
        label[11].setFont(font);
        panel.add(label[11]);
        label[11].addMouseListener(this);
        
        label[12] = new JLabel("");
        label[12].setBackground(color);
        label[12].setOpaque(true);
        label[12].setForeground(new Color(245, 229, 27));
        label[12].setBounds(100, 365, 200, 30);
        label[12].setFont(font2);
        panel.add(label[12]);
        
        label[13] = new JLabel("            Print");
        label[13].setBackground(color1);
        label[13].setOpaque(true);
        label[13].setForeground(Color.WHITE);
        label[13].setBounds(100, 550, 200, 30);
        label[13].setFont(font);
        panel.add(label[13]);
        label[13].addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == label[1]) {
        System.exit(0);
        }
        if (me.getSource() == label[2]) {
            this.setState(JFrame.ICONIFIED);
        }
        if (me.getSource() == label[3]) {
            try{
                Class.forName("org.sqlite.JDBC");
                connection=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                sql = "SELECT * FROM customer WHERE phone=?";
                preparedstatement = connection.prepareStatement(sql);
                preparedstatement.setString(1,textfield.getText());
                resultset = preparedstatement.executeQuery();
                if (resultset.next()) {
                    label[7].setText(resultset.getString("name"));
                    label[8].setText(resultset.getString("phone"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "NO Element Found");
                }
                connection.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == label[4]) {
            textfield.setText("");
            label[7].setText("");
            label[8].setText("");
        }
        if (me.getSource() == label[9]) {
            try{
                Class.forName("org.sqlite.JDBC");
                connection=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                sql = "SELECT * FROM customer WHERE phone=?";
                preparedstatement = connection.prepareStatement(sql);
                preparedstatement.setString(1,textfield.getText());
                resultset = preparedstatement.executeQuery();
                if (resultset.next()) {
                    label[12].setText(resultset.getString("subscrption"));
                }else{
                    JOptionPane.showMessageDialog(null, "NO Element Found");
                }
                connection.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (me.getSource() == label[11]) {
            try{
                Class.forName("org.sqlite.JDBC");
                connection=DriverManager.getConnection("JDBC:sqlite:tlecome.db");
                System.out.println("Connected");
                sql = "INSERT INTO customer VALUES("+label[7].getText()+","+label[8].getText()+",?,datetime())";
                preparedstatement = connection.prepareStatement(sql);
                preparedstatement.setString(1, textfield1.getText());
                preparedstatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Palance Added!");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            int x = Integer.valueOf(textfield1.getText())-74;
            textarea.setText("\n=============== Bill ==============="
            +"\n\nCustomer Name: "+label[7].getText()
            +"\n\nCustomer Number: "+label[8].getText()
            +"\n\nCustomer Subscrption: "+label[12].getText()
            +"\n\nAmount: "+textfield1.getText()
            +"\n\nReturned: "+x);
        }
        if (me.getSource() == label[13]) {
            try{
            textarea.setText(textarea.getText());
            textarea.print();
        } catch (PrinterException e) {
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
        if (me.getSource() == label[10]) {
            this.setVisible(false);
            employee log = new employee();
            log.setVisible(true);
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
            label[1].setBackground(color);
        }
        if (me.getSource() == label[2]) {
            label[2].setBackground(color);
        }
    }
    
}
