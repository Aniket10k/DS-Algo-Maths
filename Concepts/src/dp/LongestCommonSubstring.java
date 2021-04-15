package dp;

/*package whatever //do not write package name here */
import java.util.Scanner;

public class LongestCommonSubstring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[] c1 = sc.next().toCharArray();
			char[] c2 = sc.next().toCharArray();
			int[][] adj = new int[n][m];
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (c1[i] == c2[j]) {
						if (i == 0 || j == 0) {
							adj[i][j] = 1;
						} else {
							adj[i][j] = adj[i - 1][j - 1] + 1;
						}
						ans = Math.max(ans, adj[i][j]);
					}
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
