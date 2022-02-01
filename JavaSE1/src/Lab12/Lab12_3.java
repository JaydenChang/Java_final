package Lab12;

import java.net.*;
import java.io.*;

public class Lab12_3 {
    public static void main(String[] args) {
        new Lab12_3();
    }

    public Lab12_3() {
        try {
            URL page = new URL("https://www.qq.com");
            HttpURLConnection conn = (HttpURLConnection) page.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader buff = new BufferedReader(in);
            String s = buff.readLine();
            while (s != null) {
                System.out.println(s);
                s = buff.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
