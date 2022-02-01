package Lab12.UdpScket;

import java.net.*;
// import java.awt.event.*;

public class Cast extends Thread {
    public static void main(String[] args) {
        Cast c = new Cast();
        c.start();
    }

    String cast = "useless text";
    InetAddress address = null;
    MulticastSocket socket = null;

    Cast() {
        try {
            address = InetAddress.getByName("224.255.10.0");
            socket = new MulticastSocket(8998);
            socket.setTimeToLive(1);
            socket.joinGroup(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            DatagramPacket packet = null;
            byte data[] = cast.getBytes();
            packet = new DatagramPacket(data, data.length, address, 8998);
            System.out.println(new String(data, 0, data.length));
            try {
                socket.send(packet);
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
