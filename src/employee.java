import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 class employee extends JFrame implements MouseListener{
    JPanel panel;
    JLabel[] label;
    Color color1,color2;
    Font font1,font2;

    public employee() {
        
        this.setLocation(460, 160);
        this.setSize(400, 380);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        label = new JLabel[10];
        color1 = new Color(0, 102, 102);
        color2 = new Color(211, 84, 0);
        font1 = new Font("seirf", Font.BOLD, 22);
        font2 = new Font("seirf", Font.BOLD, 25);
        
        panel.setBackground(color1);
        panel.setLayout(null);
        this.add(panel);
        
        label[0] = new JLabel("Employee");
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(5, 0, 120, 30);
        label[0].setFont(font2);
        panel.add(label[0]);
        
        label[1] = new JLabel("   X");
        label[1].setBackground(color1);
        label[1].setOpaque(true);
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(350, 0, 50, 30);
        label[1].setFont(font1);
        panel.add(label[1]);
        label[1].addMouseListener(this);
        
        label[2] = new JLabel("  ---");
        label[2].setBackground(color1);
        label[2].setOpaque(true);
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(300, 0, 50, 30);
        label[2].setFont(font1);
        panel.add(label[2]);
        label[2].addMouseListener(this);
        
        label[3] = new JLabel("           Bill's History");
        label[3].setBackground(color2);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(80, 110, 250, 30);
        label[3].setFont(font1);
        panel.add(label[3]);
        label[3].addMouseListener(this);
        
        label[4] = new JLabel("              Pay Bill");
        label[4].setBackground(color2);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(80, 180, 250, 30);
        label[4].setFont(font1);
        panel.add(label[4]);
        label[4].addMouseListener(this);
        
        label[5] = new JLabel("    Add New Customer");
        label[5].setBackground(color2);
        label[5].setOpaque(true);
        label[5].setForeground(Color.WHITE);
        label[5].setBounds(80, 250, 250, 30);
        label[5].setFont(font1);
        panel.add(label[5]);
        label[5].addMouseListener(this);
        
        label[6] = new JLabel("  Logout");
        label[6].setBackground(color2);
        label[6].setOpaque(true);
        label[6].setForeground(Color.WHITE);
        label[6].setBounds(280, 340, 100, 30);
        label[6].setFont(font1);
        panel.add(label[6]);
        label[6].addMouseListener(this);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == label[1]) {
        System.exit(0);
        }
        if (me.getSource() == label[2]) {
            this.setState(JFrame.ICONIFIED);
        }
        if (me.getSource() == label[6]) {
            this.setVisible(false);
            login log = new login();
            log.setVisible(true);
        }
        if (me.getSource() == label[3]){
            this.setVisible(false);
            history ha = new history();
            ha.setVisible(true);
        }
        if (me.getSource() == label[4]){
            this.setVisible(false);
            pay ha = new pay();
            ha.setVisible(true);
        }
        if (me.getSource() == label[5]){
            this.setVisible(false);
            addcustomer ha = new addcustomer();
            ha.setVisible(true);
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
