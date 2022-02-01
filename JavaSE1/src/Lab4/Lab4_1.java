package Lab4;

import java.util.*;

public class Lab4_1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = (new Lab4_1()).produce();
        str = str.substring(0, 99);
        System.out.println(str);
        long endTime = System.currentTimeMillis();
        System.out.println("the program runs: " + (endTime - startTime) + "ms");
    }

    public String produce() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            int mode = rand.nextInt(3);
            switch (mode) {
                case 0:
                    // Upper
                    int temp1 = rand.nextInt(26) + 'A';
                    sb.append((char) temp1);
                    break;
                case 1:
                    // Lower
                    int temp2 = rand.nextInt(26) + 'a';
                    sb.append((char) temp2);
                    break;
                case 2:
                    int temp3 = rand.nextInt(10) + '0';
                    sb.append((char) temp3);
                    break;

            }
        }
        return sb.toString();
    }
}
