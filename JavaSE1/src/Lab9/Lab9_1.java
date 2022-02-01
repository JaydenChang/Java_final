package Lab9;

import java.io.*;

public class Lab9_1 {
    public static void main(String[] args) {
        new Lab9_1();
    }

    public Lab9_1() {
        File text = new File("src/Lab9/MyFile.txt");
        boolean flag = false;
        try {
            flag = text.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "Java balabala222    ";
        // byte[] b = str.getBytes();
        OutputStream out = null;

        try {
            out = new FileOutputStream(text, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            try {
                str += "\n";
                str += i;
                byte[] b = str.getBytes();
                out.write(b);
                // out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // int len = 0;
        // InputStream in = null;
        // try {
        // in = new FileInputStream(text);
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // }

        // try {
        // len = in.read(b);
        // in.close();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // System.out.println(new String(b, 0, len));
    }
}
