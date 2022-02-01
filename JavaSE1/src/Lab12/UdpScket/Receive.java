package Lab12.UdpScket;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class Receive extends JFrame implements Runnable, ActionListener {
    public static void main(String[] args) {
        Receive rec = new Receive();
        rec.setSize(460, 200);
    }

    int port;
    InetAddress group = null;
    MulticastSocket socket = null;
    JButton ince = new JButton("start to receive");
    JButton stop = new JButton("stop to receive");
    JTextArea inceArea = new JTextArea(10, 10);
    JTextArea inced = new JTextArea(10, 10);
    Thread thread;
    boolean flag = false;

    public Receive() {
        super("cast");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        thread = new Thread(this);
        ince.addActionListener(this);
        stop.addActionListener(this);
        inceArea.setForeground(Color.blue);
        JPanel center = new JPanel();
        JPanel north = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        north.add(ince);
        north.add(stop);
        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        center.add(inceArea);
        center.add(inced);
        validate();
        port = 8998;
        try {
            group = InetAddress.getByName("224.255.10.0");
            socket = new MulticastSocket(port);
            socket.joinGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setBounds(100, 50, 360, 380);
        setVisible(true);
    }

    public void run() {
        while (true) {
            byte data[] = new byte[1024];
            DatagramPacket packet = null;
            packet = new DatagramPacket(data, data.length, group, port);
            try {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                inceArea.setText("receiving: " + message);
                inced.append(message + '\n');
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (flag == true)
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ince) {
            ince.setBackground(Color.RED);
            stop.setBackground(Color.yellow);
            if (!(thread.isAlive())) {
                thread = new Thread(this);
            }
            thread.start();
            flag = false;
        }
        if (e.getSource() == stop) {
            ince.setBackground(Color.yellow);
            stop.setBackground(Color.red);
            flag = true;
        }
    }
}
