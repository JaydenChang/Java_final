package Lab3;

// import java.util.*;

public class Lab3_4 {
    public static void main(String[] args) {
        (new Lab3_4()).fun(12, 5);
    }

    public void fun(int a, int b) {
        System.out.print("sum: ");
        System.out.println(a + b);
        System.out.print("minus: ");
        System.out.println(a - b);
        for (int i = 2; i <= a; i++) {
            if (a % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
