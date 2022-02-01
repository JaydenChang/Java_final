package Lab1;

import java.util.Scanner;

public class Lab1_2 {
	public static void main(String[] args) {
		show();
	}

	public static void show() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n < 1) {
			// return -1;
			System.out.println(0);
		} else if (n == 1 || n == 2) {
			System.out.println(1);
		} else {
			System.out.println(1);
			System.out.println(1);
			long a = 1l, b = 1l, c = 1l;
			for (int i = 1; i <= n; i++) {
				c = a + b;
				a = b;
				b = c;
				System.out.println(c);
			}
		}
		scanner.close();
	}
}
