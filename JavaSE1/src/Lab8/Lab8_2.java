package Lab8;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Lab8_2 extends JFrame {
    public static void main(String[] args) {
        new Lab8_2();
    }

    int i1 = 0, i2 = 0, i3 = 0, i4 = 0;
    Container con = getContentPane();

    public Lab8_2() {
        setTitle("vote");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);

        JPanel jp1 = new JPanel();
        jp1.setBounds(100, 20, i1, 20);
        jp1.setBackground(Color.red);
        jp1.setOpaque(true);
        JLabel label1 = new JLabel(" " + i1);
        label1.setBounds(120 + i1, 20, 50, 50);

        JPanel jp2 = new JPanel();
        jp2.setBounds(100, 100, i2, 20);
        jp2.setBackground(Color.green);
        jp2.setOpaque(true);
        JLabel label2 = new JLabel(" " + i2);
        label2.setBounds(120 + i2, 100, 50, 50);

        JPanel jp3 = new JPanel();
        jp3.setBounds(100, 180, i3, 20);
        jp3.setBackground(Color.gray);
        jp3.setOpaque(true);
        JLabel label3 = new JLabel(" " + i3);
        label3.setBounds(120 + i3, 180, 50, 50);

        JPanel jp4 = new JPanel();
        jp4.setBounds(100, 260, i4, 20);
        jp4.setBackground(Color.blue);
        jp4.setOpaque(true);
        JLabel label4 = new JLabel(" " + i4);
        label4.setBounds(120 + i4, 260, 50, 50);

        JButton btn1 = new JButton("1");
        btn1.setBounds(20, 20, 60, 50);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i1++;
                jp1.setBounds(100, 20, i1, 40);
                label1.setBounds(120 + i1, 20, 50, 50);
                label1.setText(" " + i1);
            }
        });

        JButton btn2 = new JButton("2");
        btn2.setBounds(20, 100, 60, 50);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i2++;
                jp2.setBounds(100, 100, i2, 40);
                label2.setBounds(120 + i2, 100, 50, 50);
                label2.setText(" " + i2);
            }
        });

        JButton btn3 = new JButton("3");
        btn3.setBounds(20, 180, 60, 50);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i3++;
                jp3.setBounds(100, 180, i3, 40);
                label3.setBounds(120 + i3, 180, 50, 50);
                label3.setText(" " + i3);
            }
        });

        JButton btn4 = new JButton("4");
        btn4.setBounds(20, 260, 60, 50);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i4++;
                jp4.setBounds(100, 260, i4, 40);
                label4.setBounds(120 + i4, 260, 50, 50);
                label4.setText(" " + i4);
            }
        });

        add(jp1);
        add(jp2);
        add(jp3);
        add(jp4);
        add(label1);
        add(label2);
        add(label3);
        add(label4);

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);

        setVisible(true);
    }
}
