package dp;

public class MaximumCutSegment {
	public int maximizeCuts(int n, int x, int y, int z) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			dp[i] = -1;
			if (i - x >= 0)
				dp[i] = Math.max(dp[i], dp[i - x]);
			if (i - y >= 0)
				dp[i] = Math.max(dp[i], dp[i - y]);
			if (i - z >= 0)
				dp[i] = Math.max(dp[i], dp[i - z]);
			if (dp[i] != -1)
				dp[i]++;
		}
		// System.out.println(Arrays.toString(dp));
		return (dp[n] == -1) ? 0 : dp[n];
	}
}
