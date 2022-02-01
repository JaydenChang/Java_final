package Lab10;

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.util.*;

public class Lab10_1_4 extends Thread {
    public static void main(String[] args) {
        new Lab10_1_4();

    }

    static public JFrame jf = new JFrame();
    static public int count = 0;
    static public Container con = jf.getContentPane();
    // static public Thread th[] = new Thread[40];
    Random rand = new Random();

    public Lab10_1_4() {
        jf.setBounds(300, 200, 800, 500);
        con.setLayout(null);
        for (int i = 0; i < 40; i++) {
            makeSnow();
        }
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void makeSnow() {
        Thread t;
        URL url = Lab10_1_4.class.getResource("./1.gif");

        System.out.println(url);
        Icon icon = new ImageIcon(url);

        JLabel jl = new JLabel();
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10, 10, 50, 50);
        jl.setOpaque(true);

        t = new Thread(new Runnable() {
            int move = rand.nextInt(800);

            // int flag = 0;
            @Override
            public void run() {
                while (count <= 500) {
                    jl.setBounds(move, count, 30, 50);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count += 4;
                    if (count >= 500) {
                        count = 10;
                    }

                }
            }
        });
        t.start();
        con.add(jl);

    }

}
