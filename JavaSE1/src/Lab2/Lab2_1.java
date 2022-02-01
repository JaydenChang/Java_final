package Lab2;

import java.util.Scanner;

public class Lab2_1 {
    public static void main(String[] args) {
        (new Lab2_1()).count();
    }

    // StringBuilder String
    public void count() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder chars = new StringBuilder();
        int[] num = new int[130];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char cc = str.charAt(i);
            String tt = String.valueOf(cc);
            if (chars.indexOf(tt) == -1) {
                chars.insert(index, tt);
                index++;
                num[chars.indexOf(tt)]++;
            } else {
                num[chars.indexOf(tt)]++;
            }
        }
        String ss = chars.toString();
        char[] cs = ss.toCharArray();
        for (int k = 0; k < chars.length(); k++) {
            System.out.println(cs[k] + " " + num[k]);
        }
        scanner.close();
    }
}