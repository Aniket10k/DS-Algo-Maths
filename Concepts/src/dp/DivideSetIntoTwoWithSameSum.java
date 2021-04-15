package dp;

import java.util.Arrays;

public class DivideSetIntoTwoWithSameSum {
	static int equalPartition(int n, int arr[]) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
		}
		if (sum % 2 != 0) {
			return 0;
		}
		sum /= 2;
		int[][] dp = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}
		return recurse(0, arr, 0, n, sum, dp);
	}

	static int recurse(int sum, int[] arr, int i, int n, int maxSum, int[][] dp) {
		if (sum == maxSum) {
			return 1;
		} else if (i == n || sum > maxSum) {
			return 0;
		} else if (dp[n][sum] != -1) {
			return dp[n][sum];
		}
		dp[n][sum] = recurse(sum + arr[i], arr, i + 1, n, maxSum, dp) | recurse(sum, arr, i + 1, n, maxSum, dp);
		return dp[n][sum];

	}
}
