package Lab7;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyDialog extends JDialog {
    public MyDialog(Lab7_1 frame) {
        super(frame, "a window", true);
        Container con = getContentPane();
        con.add(new JLabel("this is a dialog"));
        setSize(200, 150);
        setBounds(120, 120, 100, 100);
        setVisible(true);
    }
}

public class Lab7_1 extends JFrame {
    public static void main(String[] args) {
        new Lab7_1();
    }

    public Lab7_1() {
        JFrame jf = new JFrame();
        Container con = jf.getContentPane();
        jf.setVisible(true);
        jf.setSize(400, 300);
        con.setLayout(null);
        JLabel jl = new JLabel("this is a JFrame window");
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        con.add(jl);
        jl.setBounds(10, 50, 150, 30);
        JButton btn = new JButton("pop the dialog");
        btn.setBounds(10, 10, 100, 21);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MyDialog(Lab7_1.this).setVisible(true);
            }
        });
        con.add(btn);
    }

}
