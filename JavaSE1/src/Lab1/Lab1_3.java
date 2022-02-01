package Lab1;
// import java.util.Scanner;

public class Lab1_3 {
	public static void main(String[] args) {
		Lab1_3 temp = new Lab1_3();

		for (int i = 1; i < 1001; i++) {
			temp.show(i);
		}
	}

	public void show(int n) {
		long sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		if (sum == n) {
			System.out.println(n);
		}
	}
}
