package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import javax.swing.ImageIcon.*;

public class Lab7_3 {
    public static void main(String[] args) {
        new Lab7_3();
    }

    public int i = 1;

    public Lab7_3() {
        JFrame jf = new JFrame();
        // String path ="f:"
        Container container = jf.getContentPane();

        jf.setBounds(10, 50, 100, 50);
        jf.setSize(800, 800);
        container.setLayout(null);
        JButton jbtn1 = new JButton("previous");
        JButton jbtn2 = new JButton("next");

        JLabel label = new JLabel("");
        ImageIcon img = new ImageIcon("src/Lab7/img/" + i + ".jpg");
        // label.setIcon(new ImageIcon("src/Lab7/img/" + i + ".jpg"));

        // Image tt = img.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        // img = new ImageIcon(tt);
        label.setIcon(img);
        label.setBounds(111, 44, 217, 200);

        jbtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jbtn2.setEnabled(true);
                i--;
                ImageIcon img = new ImageIcon("src/Lab7/img/" + i + ".jpg");

                label.setIcon(img);
                if (i <= 1) {
                    i = 1;
                    jbtn1.setEnabled(false);
                    // JOptionPane.showMessageDialog(Lab7_3.this, "the current pic is the first
                    // pic");
                    JOptionPane.showMessageDialog(null, "the current pic is the first pic");

                }
            }
        });
        jbtn1.setBounds(111, 585, 93, 35);

        jbtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jbtn1.setEnabled(true);
                i++;
                ImageIcon img = new ImageIcon("src/Lab7/img/" + i + ".jpg");
                label.setIcon(img);
                if (i >= 4) {
                    i = 4;
                    jbtn2.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "the current pic is the last pic");
                }
            }
        });

        jbtn2.setBounds(232, 585, 93, 35);
        container.add(label);
        container.add(jbtn1);
        container.add(jbtn2);
        jf.setVisible(true);
    }
}
