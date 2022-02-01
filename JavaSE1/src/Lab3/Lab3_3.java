package Lab3;

import java.util.*;

public class Lab3_3 {
    public static void main(String[] args) {
        (new Lab3_3()).show();
    }

    public void show() {
        Random rand = new Random();
        int[] arr = new int[6];
        for (int i = 0; i < 10000; i++) {
            arr[rand.nextInt(6)]++;
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(i + 1 + " " + arr[i]);
        }
        System.out.print("big: ");
        System.out.println(arr[0] + arr[1] + arr[2]);
        System.out.print("small: ");
        System.out.println(arr[3] + arr[4] + arr[5]);
    }
}
