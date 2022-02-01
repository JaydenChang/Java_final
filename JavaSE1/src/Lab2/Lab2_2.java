package Lab2;

import java.util.Scanner;

public class Lab2_2 {
    public static void main(String[] args) {
        // (new Lab2_2()).judge_qq();
        (new Lab2_2()).judge_username();
    }

    public void judge_qq() {
        Scanner scanner = new Scanner(System.in);
        String qq = scanner.next();
        String regex = "[1-9][0-9]{3,8}";
        if (qq.matches(regex)) {
            System.out.println("a valid qq number");
        } else {
            System.out.println("not a valid qq number");
        }
        scanner.close();
    }

    public void judge_username() {
        Scanner scanner = new Scanner(System.in);
        String regex = "[a-z[A-Z][0-9]_]{1,20}";
        String username = scanner.next();
        if (username.matches(regex)) {
            System.out.println("a valid username");
        } else {
            System.out.println("not a valid username");
        }
        scanner.close();
    }
}
