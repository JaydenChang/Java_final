package Lab10;

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.util.*;

public class Lab10_1_3 extends Thread {
    public static void main(String[] args) {
        new Lab10_1_3();
    }

    public JFrame jf = new JFrame();
    public JLabel jl = new JLabel();
    public int count = 0;
    public Container con = jf.getContentPane();

    public Lab10_1_3() {
        jf.setBounds(300, 200, 410, 400);
        con.setLayout(null);
        URL url = Lab10_1_1.class.getResource("./1.gif");
        Icon icon = new ImageIcon(url);
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10, 10, 200, 200);
        jl.setOpaque(true);
        start();
        con.add(jl);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void run() {
        Random rand = new Random();
        int temp = rand.nextInt(400);
        while (count <= 200) {
            jl.setBounds(temp, count, 200, 200);
            try {
                Thread.sleep(10);
            } catch (Exception err) {
                err.printStackTrace();
            }
            count += 4;
            if (count >= 200) {
                count = 10;
                temp = rand.nextInt(370);
            }
        }
    }
}
