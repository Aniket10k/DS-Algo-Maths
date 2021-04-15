package arraysStrings.questions;

import java.util.Scanner;

public class SubArraySum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			int[] sum = new int[n];
			sum[0] = a[0];
			int start = 0;
			boolean b = false;
			for (int i = 1; i < n; i++) {
				sum[i] = sum[i - 1] + a[i];
				if (sum[i] == k) {
					System.out.println((start + 1) + " " + (i + 1));
					b = true;
					break;
				}
				if (sum[i] > k) {

					while (sum[i] > k) {
						sum[i] = sum[i] - a[start];
						start++;
						if (sum[i] == k) {
							System.out.println((start + 1) + " " + (i + 1));
							b = true;
							break;
						}
					}
					if (b) {
						break;
					}
				}

			}
			if (!b)
				System.out.println(-1);
		}
		sc.close();
	}
}