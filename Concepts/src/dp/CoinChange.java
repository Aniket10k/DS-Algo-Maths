package dp;

public class CoinChange {

	public long count(int a[], int m, int n) {
		long[][] dp = new long[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				dp[i][j] = -1;
			}
		}
		return recursion(a, m, n, dp);
	}

	public long recursion(int[] a, int m, int n, long[][] dp) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		if (m <= 0 && n > 0) {
			return 0;
		}
		if (dp[m][n] != -1) {
			return dp[m][n];
		} else {
			dp[m][n] = recursion(a, m - 1, n, dp) + recursion(a, m, n - a[m - 1], dp);
		}
		return dp[m][n];
	}
}
