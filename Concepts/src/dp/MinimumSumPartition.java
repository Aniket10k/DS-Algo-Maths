package dp;

import java.util.Arrays;

public class MinimumSumPartition {
	public int minDiffernce(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
		}
		int[][] dp = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}
		return rec(arr, n, 0, 0, dp);

	}

	public int rec(int[] arr, int n, int sum1, int sum2, int[][] dp) {
		if (n == 0) {
			dp[n][Math.abs(sum1 - sum2)] = Math.abs(sum1 - sum2);
			return Math.abs(sum1 - sum2);
		}
		if (dp[n][Math.abs(sum1 - sum2)] != -1) {
			return dp[n][Math.abs(sum1 - sum2)];
		}
		dp[n][Math.abs(sum1 - sum2)] = Math.min(rec(arr, n - 1, sum1 + arr[n - 1], sum2, dp),
				rec(arr, n - 1, sum1, sum2 + arr[n - 1], dp));

		return dp[n][Math.abs(sum1 - sum2)];
	}
}
