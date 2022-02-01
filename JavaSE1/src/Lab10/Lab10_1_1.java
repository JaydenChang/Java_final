package Lab10;

import java.awt.*;
import javax.swing.*;
import java.net.*;

public class Lab10_1_1 extends JFrame {
    public static void main(String[] args) {
        new Lab10_1_1();
    }

    private JLabel jl = new JLabel();
    private static Thread t;
    private int count = 0;
    private Container con = getContentPane();

    public Lab10_1_1() {
        setBounds(300, 200, 250, 100);
        con.setLayout(null);
        URL url = Lab10_1_1.class.getResource("./1.gif");
        Icon icon = new ImageIcon(url);
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10, 10, 200, 50);
        jl.setOpaque(true);
        t = new Thread(new Runnable() {
            public void run() {
                while (count <= 200) {
                    jl.setBounds(count, 10, 200, 50);
                    try {
                        Thread.sleep(100);
                    } catch (Exception err) {
                        err.printStackTrace();
                    }
                    count += 4;
                    if (count == 200) {
                        count = 10;
                    }
                }
            }
        });
        t.start();
        con.add(jl);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
