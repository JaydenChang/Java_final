package Lab9;

import java.io.*;

public class Lab9_3 {
    public static void main(String[] args) {
        new Lab9_3();
    }

    public Lab9_3() {
        try {
            FileOutputStream fs = new FileOutputStream("src/Lab9/MyText.txt");
            DataOutputStream ds = new DataOutputStream(fs);
            ds.writeUTF("write with writeUTF");
            ds.writeChars("write with writeChars");
            ds.writeBytes("write with writeBytes");
            ds.close();

            FileInputStream fis = new FileInputStream("src/Lab9/MyText.txt");
            DataInputStream dis = new DataInputStream(fis);

            System.out.println(dis.readUTF());

            dis.close();

        } catch (Exception err) {
            err.printStackTrace();
        }

    }
}
