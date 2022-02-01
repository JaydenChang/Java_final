package Lab2;

import java.util.Scanner;

public class Lab2_4 {
    public static void main(String[] args) {
        (new Lab2_4()).calc();
    }

    public void calc() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = 1, temp = 1, count = 1;
        for (int i = 1; i < num; i++) {
            if (arr[i] > arr[i - 1]) {
                count++;
            } else {
                temp = count;
                count = 1;
            }
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
