package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class Lab7_3answer extends JFrame {
    public static void main(String[] args) {
        new Lab7_3answer();
    }

    int w, h, i;
    Container con = getContentPane();

    public Lab7_3answer() {
        setTitle("img broswer");
        w = 450;
        h = 400;
        i = 1;
        URL url = Lab7_3answer.class.getResource("img/" + i + ".jpg");
        ImageIcon icon = new ImageIcon(url);
        icon = new ImageIcon(icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        final JLabel label1 = new JLabel();
        label1.setIcon(icon);
        label1.setBounds(20, 20, w, h);

        setLayout(null);
        con.add(label1);

        JButton btn1 = new JButton("previous");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i--;
                if (i < 1)
                    i = 4;
                URL url = Lab7_3answer.class.getResource("img/" + i + ".jpg");
                ImageIcon icon = new ImageIcon(url);
                icon = new ImageIcon(icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
                label1.setIcon(icon);
            }
        });
        btn1.setBounds(50, 430, 100, 40);
        con.add(btn1);

        JButton btn2 = new JButton("next");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                if (i > 4)
                    i = 1;
                URL url = Lab7_3answer.class.getResource("img/" + i + ".jpg");
                ImageIcon icon = new ImageIcon(url);
                icon = new ImageIcon(icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
                label1.setIcon(icon);
            }
        });
        btn2.setBounds(350, 430, 100, 40);
        con.add(btn2);

        setBounds(300, 200, 500, 520);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
