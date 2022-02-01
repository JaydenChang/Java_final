package Lab14;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

// import org.w3c.dom.css.Rect;

public class Lab14_3 extends JFrame {
    private final int oval_width = 80;
    private final int oval_height = 80;

    public Lab14_3() {
        super();
        initialize();
    }

    private void initialize() {
        this.setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new draw());
        this.getContentPane().setBackground(Color.blue);
        setSize(800, 400);
        this.setTitle("draw");
    }

    public static void main(String[] args) {
        new Lab14_3().setVisible(true);
    }

    class draw extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g1 = (Graphics2D) g;
            g1.setColor(Color.white);
            Shape shape = new Rectangle2D.Double(40, 40, 500, 300);
            g1.fill(shape);
            g.setColor(Color.blue);
            g.drawOval(50, 50, oval_width, oval_height);
            g.setColor(Color.black);
            g.drawOval(120, 50, oval_width, oval_height);
            g.setColor(Color.red);
            g.drawOval(190, 50, oval_width, oval_height);
            g.setColor(Color.yellow);
            g.drawOval(90, 110, oval_width, oval_width);
            g.setColor(Color.green);
            g.drawOval(160, 110, oval_width, oval_height);
            g.setColor(Color.black);
            g.drawString("Olympic", 80, 230);
        }
    }
}
