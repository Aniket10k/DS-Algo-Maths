package dp.questions;

import java.util.Arrays;
import java.util.Comparator;

class Pair {
	int x;
	int y;

	public Pair(int a, int b) {
		x = a;
		y = b;
	}
}

class CompareByFirst implements Comparator<Pair> {
	public int compare(Pair a, Pair b) {
		return a.x - b.x;
	}
}

public class MaxLengthChain {
	int maxChainLength(Pair arr[], int n) {
		Arrays.sort(arr, new CompareByFirst());
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			int currMax = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i].x > arr[j].y) {
					currMax = Math.max(dp[j] + 1, currMax);
				}
			}
			dp[i] = currMax;
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
}
