package greedy.questions;

/*package whatever //do not write package name here */
import java.util.Arrays;
import java.util.Scanner;

class CoinPiles {
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
			Arrays.sort(a);
			int ans = 0;
			for (int j = n - 1; j >= 0; j--) {
				if (a[j] - a[0] > k) {
					ans = ans + a[j] - a[0] - k;
				} else {
					break;
				}
			}
			int lastSum = 0;
			for (int i = 1; i < n; i++) {
				int p = 0;
				lastSum = lastSum + a[i - 1];
				for (int j = n - 1; j >= i; j--) {
					if (a[j] - a[i] >= k) {
						p = p + a[j] - a[i] - k;
					} else {
						break;
					}
				}
				if (ans > p + lastSum) {
					ans = p + lastSum;
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}