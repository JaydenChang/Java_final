package Lab7;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Lab7_2 extends JFrame {
    public static void main(String[] args) {
        new Lab7_2();
    }

    public Lab7_2() {
        JFrame jf = new JFrame();
        Container container = jf.getContentPane();
        jf.setVisible(true);
        jf.setSize(500, 500);
        jf.setTitle("九九乘法表");
        JLabel jl = new JLabel();
        String[] str = new String[10];
        for (int i = 1; i <= 9; i++) {
            str[i] = "<tr>";
            for (int j = 1; j <= i; j++) {
                str[i] = "<td>" + str[i] + i + "*" + j + "=" + i * j + " " + "</td>";
            }
            str[i] = str[i] + "</tr>";
        }
        StringBuilder sb = new StringBuilder("<html><table>");
        for (int i = 1; i < 10; i++) {
            sb.append(str[i]);
        }
        sb.append("</table></html>");
        // JLabel jl = new JLabel();
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setBounds(10, 50, 100, 30);
        jl.setText(sb.toString());
        container.add(jl);
    }
}
