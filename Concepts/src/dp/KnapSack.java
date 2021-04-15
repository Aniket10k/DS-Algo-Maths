package dp;

import java.util.Arrays;

class Knapsack {
	static int knapSack(int W, int wt[], int val[], int n) {
		int[][] dp = new int[n + 1][W + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}
		return sack2(W, wt, val, n, dp);
	}

	// Returns the maximum value that can be put in a knapsack of capacity W
	static int sack1(int W, int wt[], int val[], int n, int[][] dp) {
		// System.out.println(n +" "+W);
		if (dp[n][W] != -1) {
			return dp[n][W];
		}
		if (W == 0 || n == 0) {
			dp[n][W] = 0;
		} else if (wt[n - 1] > W) {
			dp[n][W] = sack1(W, wt, val, n - 1, dp);
		} else {
			dp[n][W] = Math.max(val[n - 1] + sack1(W - wt[n - 1], wt, val, n - 1, dp), sack1(W, wt, val, n - 1, dp));
		}
		return dp[n][W];
	}

	static int sack2(int W, int[] wt, int[] val, int n, int[][] dp) {
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (wt[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				}
			}
		}
		return dp[n][W];
	}
}