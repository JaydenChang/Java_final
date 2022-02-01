package Lab14;

import java.awt.*;
import javax.swing.*;

public class Lab14_1 extends JFrame {
    private final int oval_weight = 80;
    private final int oval_width = 80;

    public Lab14_1() {
        super();
        initialize();
    }

    private void initialize() {
        this.setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new draw());
        this.setTitle("sun");
    }

    public static void main(String[] args) {
        new Lab14_1().setVisible(true);
    }

    class draw extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            // g.drawOval(100, 100, oval_width, oval_weight);
            Graphics g1 = (Graphics) g;
            g1.setColor(Color.red);
            g1.drawOval(100, 100, oval_width, oval_weight);
            Graphics g2 = (Graphics) g;
            g2.setColor(Color.black);
            g2.drawString("sun", 130, 140);

            BasicStroke bs1 = new BasicStroke(
                    1, BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_MITER,
                    10.0f, new float[] { 5, 10 }, 0.0f);

            Graphics2D g3 = (Graphics2D) g;
            g3.setColor(Color.black);
            g3.setStroke(bs1);
            g3.drawOval(75, 75, oval_width + 50, oval_weight + 50);
            // g3.drawString("★",75,75);
            Graphics g4 = (Graphics) g;
            g4.setColor(Color.blue);
            g4.drawString("★", 75, 120);
        }
    }
}
