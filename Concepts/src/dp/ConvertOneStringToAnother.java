package dp;

public class ConvertOneStringToAnother {
	/*
	 * Given two strings s and t. Find the minimum number of operations that need to
	 * be performed on str1 to convert it to str2. The possible operations are:
	 * 
	 * Insert Remove Replace
	 */

	public int editDistance(String s, String t) {

		char[] c1 = s.toCharArray();
		char[] c2 = t.toCharArray();
		int n = s.length();
		int m = t.length();
		int[][] dp = new int[n + 1][m + 1];
		dp[0][0] = 0;
		for (int i = 1; i < n + 1; i++) {
			dp[i][0] = dp[i - 1][0] + 1;
		}
		for (int i = 1; i < m + 1; i++) {
			dp[0][i] = dp[0][i - 1] + 1;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (c1[i - 1] == c2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
				}
			}
		}
		return dp[n][m];
	}
}