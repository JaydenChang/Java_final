package Lab6;

import java.util.*;

public class Lab6_1 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        Lab6_1 ll = new Lab6_1();
        ll.menu();

    }

    ArrayList<String> arr = new ArrayList<String>();

    public void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input the first element:");
        String ss = scanner.nextLine();
        arr.add(ss);
    }

    public void insert() {
        Scanner scanner = new Scanner(System.in);
        String ss = scanner.nextLine();
        for (int i = 0; i < arr.size(); i++) {
            if (ss.equals(arr.get(i))) {
                continue;
            } else {
                arr.add(ss);
            }
        }
        // scanner.close();
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        String ss = scanner.nextLine();
        for (int i = 0; i < arr.size(); i++) {
            if (ss.equals(arr.get(i))) {
                arr.remove(i);
                // scanner.close();
                return;
            }
        }
        System.out.println("not found");
        // scanner.close();
    }

    public void show() {
        System.out.print("   the result: \n");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        System.out.println();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        init();
        while (true) {
            System.out.println("1.insert");
            System.out.println("2.remove");
            System.out.println("3.show");
            System.out.println("0.break");
            int mode = scanner.nextInt();
            if (mode == 1) {
                insert();
            } else if (mode == 2) {
                remove();
            } else if (mode == 0) {
                break;
            } else if (mode == 3) {
                show();
            } else {
                System.out.println("sgement fault");
            }
        }
    }
}
