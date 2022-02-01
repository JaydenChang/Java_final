package Lab14;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.*;

import javax.imageio.*;

public class Lab14_2 extends JFrame {
    private int sx1, sx2, sy1, sy2;
    private int width = 440, height = 440;
    public Image img;
    public JButton jb1 = null;
    public Graphics2D gg;
    public FileDialog dialogOpen;
    public FileDialog dialogClose;
    public can canvasPanel = null;
    static int flag = 1;

    public Lab14_2() {
        sx1 = 0;
        sy1 = 0;

        sx2 = width;
        sy2 = height;
        sx1 = sy1 = 0;
        initialize();
    }

    public void initialize() {
        try {
            img = ImageIO.read(new File("src/Lab14/a.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel bottom = new JPanel();
        jb1 = getButton();
        bottom.add(jb1);

        Container con = getContentPane();
        con.add(bottom, BorderLayout.NORTH);
        canvasPanel = new can();
        con.add(canvasPanel, BorderLayout.CENTER);

        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("aaa");

    }

    private JButton getButton() {
        if (jb1 == null) {
            jb1 = new JButton();
            jb1.setText("rotate");

            jb1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (flag == 1) {
                        flag++;
                        flag %= 4;
                        sx1 += width;
                        sx2 -= width;
                    } else if (flag == 2) {
                        flag++;
                        flag %= 4;
                        sy1 += height;
                        sy2 -= height;
                    } else if (flag == 3) {
                        flag++;
                        flag %= 4;
                        sx1 -= width;
                        sx2 += width;
                    } else if (flag == 0) {
                        flag++;
                        flag %= 4;
                        sy1 -= height;
                        sy2 += height;
                    }
                    // System.out.println(flag + " " + sx1 + " " + sy1 + " " + sx2 + " " + sy2);
                    canvasPanel.repaint();
                }
            });
        }
        return jb1;
    }

    public static void main(String[] args) {
        new Lab14_2().setVisible(true);
    }

    class can extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(img, sx1, sy1, sx2, sy2, 0, 0, width, height, this);

        }
    }
}
