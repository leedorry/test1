package test;

import java.util.Scanner;

public class test5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int M = sc.nextInt();

		System.out.println(getTime(H, M));
	}

	public static String getTime(int H, int M) {
		if (M - 45 >= 0) {
			M -= 45;
		} else {
			M = M - 45 + 60;
			H--;
			if (H == -1) {
				H = 23;
			}
		}
		return String.format("%d %d", H, M);

	}

}
