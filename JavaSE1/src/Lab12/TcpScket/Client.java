package Lab12.TcpScket;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Client extends JFrame {
    public static void main(String[] args) {
        Client cl = new Client("send data to server");
        cl.setSize(200, 200);
        cl.setVisible(true);
        cl.connect();
    }

    private PrintWriter writer;
    Socket socket;
    private JTextArea ta = new JTextArea();
    private JTextField tf = new JTextField();

    public Client(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cc = this.getContentPane();
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        cc.add(tf, "South");
        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writer.println(tf.getText());
                ta.append(tf.getText() + '\n');
                ta.setSelectionEnd(ta.getText().length());
                tf.setText("");
            }
        });
    }

    private void connect() {
        ta.append("try to connect\n");
        try {
            socket = new Socket("127.0.0.1", 8998);
            writer = new PrintWriter(socket.getOutputStream(), true);
            ta.append("connection finished\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
