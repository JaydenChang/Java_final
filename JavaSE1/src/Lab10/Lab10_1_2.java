package Lab10;

import java.awt.*;
import javax.swing.*;
import java.net.*;

public class Lab10_1_2 extends Thread {
    public static void main(String[] args) {
        new Lab10_1_2();
    }

    public JFrame jf = new JFrame();
    public JLabel jl = new JLabel();
    public int count = 0;
    public Container con = jf.getContentPane();

    public Lab10_1_2() {
        jf.setBounds(300, 200, 250, 100);
        con.setLayout(null);
        URL url = Lab10_1_1.class.getResource("./1.gif");
        Icon icon = new ImageIcon(url);
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10, 10, 200, 50);
        jl.setOpaque(true);
        start();
        con.add(jl);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void run() {
        while (count <= 200) {
            jl.setBounds(count, 10, 200, 50);
            try {
                Thread.sleep(10);
            } catch (Exception err) {
                err.printStackTrace();
            }
            count += 4;
            if (count >= 200) {
                count = 10;
            }
        }
    }
}
