package Lab12.TcpScket;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        Server ser = new Server();
        ser.getServer();
    }

    private BufferedReader reader;
    private ServerSocket server;
    private Socket socket;

    void getServer() {
        try {
            server = new ServerSocket(8998);
            System.out.println("create server successfully");
            while (true) {
                System.out.println("wait for connection from client");
                socket = server.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getClientMessage() {
        try {
            InputStream inputStream = socket.getInputStream();
            String s;
            int c;
            while (true) {
                c = inputStream.read();
                if (reader.ready()) {
                    s = reader.readLine();
                    System.out.println("client: " + (char) c + s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("disconnected");
        }
        try {
            if (reader != null) {
                reader.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
