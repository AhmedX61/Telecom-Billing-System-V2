import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class admin extends JFrame implements MouseListener{
    
    JPanel p;
    JLabel[] l;
    Color c,c1;
    Font f,f1;

    public admin() {
        
        this.setLocation(460, 160);
        this.setSize(400, 380);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new JPanel();
        l = new JLabel[10];
        c = new Color(0, 102, 102);
        c1 = new Color(211, 84, 0);
        f = new Font("seirf", Font.BOLD, 22);
        f1 = new Font("seirf", Font.BOLD, 25);
        
        p.setBackground(c);
        p.setLayout(null);
        this.add(p);
        
        l[0] = new JLabel("Admin");
        l[0].setForeground(Color.WHITE);
        l[0].setBounds(5, 0, 120, 30);
        l[0].setFont(f1);
        p.add(l[0]);
        
        l[1] = new JLabel("   X");
        l[1].setBackground(c);
        l[1].setOpaque(true);
        l[1].setForeground(Color.WHITE);
        l[1].setBounds(350, 0, 50, 30);
        l[1].setFont(f);
        p.add(l[1]);
        l[1].addMouseListener(this);
        
        l[2] = new JLabel("  ---");
        l[2].setBackground(c);
        l[2].setOpaque(true);
        l[2].setForeground(Color.WHITE);
        l[2].setBounds(300, 0, 50, 30);
        l[2].setFont(f);
        p.add(l[2]);
        l[2].addMouseListener(this);
        
        l[3] = new JLabel("           Bill's History");
        l[3].setBackground(c1);
        l[3].setOpaque(true);
        l[3].setForeground(Color.WHITE);
        l[3].setBounds(80, 130, 250, 30);
        l[3].setFont(f);
        p.add(l[3]);
        l[3].addMouseListener(this);
        
        l[4] = new JLabel("           Embloyees");
        l[4].setBackground(c1);
        l[4].setOpaque(true);
        l[4].setForeground(Color.WHITE);
        l[4].setBounds(80, 200, 250, 30);
        l[4].setFont(f);
        p.add(l[4]);
        l[4].addMouseListener(this);
        
        l[5] = new JLabel("  Logout");
        l[5].setBackground(c1);
        l[5].setOpaque(true);
        l[5].setForeground(Color.WHITE);
        l[5].setBounds(280, 340, 100, 30);
        l[5].setFont(f);
        p.add(l[5]);
        l[5].addMouseListener(this);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == l[1]) {
        System.exit(0);
        }
        if (me.getSource() == l[2]) {
            this.setState(JFrame.ICONIFIED);
        }
        if (me.getSource() == l[5]) {
            this.setVisible(false);
            login log = new login();
            log.setVisible(true);
        }
        if (me.getSource() == l[3]){
            this.setVisible(false);
            historyadmin ha = new historyadmin();
            ha.setVisible(true);
        }
        if (me.getSource() == l[4]){
            this.setVisible(false);
            employeeadmin ha = new employeeadmin();
            ha.setVisible(true);
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
