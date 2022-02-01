package Lab9;

// import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Lab9_2 extends JFrame {
    public static void main(String[] args) {
        new Lab9_2();
    }

    public Lab9_2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        JPanel con = new JPanel();
        // con.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(con);
        con.setLayout(null);

        JTextArea text = new JTextArea();
        text.setBounds(10, 10, 400, 200);
        con.add(text);

        JButton write = new JButton("write");
        write.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File file = new File("src/Lab9/MyFile.txt");
                try {
                    FileWriter out = new FileWriter(file);
                    String s = text.getText();
                    out.write(s);
                    out.close();
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        });
        write.setBounds(10, 240, 80, 40);
        con.add(write);

        JButton read = new JButton("read");
        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File file = new File("src/Lab9/MyFile.txt");
                try {
                    FileReader in = new FileReader(file);
                    char bytes[] = new char[1024];
                    int len = in.read(bytes);
                    text.setText(new String(bytes, 0, len));
                    in.close();
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }

        });
        read.setBounds(140, 240, 80, 40);
        con.add(read);

        setVisible(true);
    }

}
