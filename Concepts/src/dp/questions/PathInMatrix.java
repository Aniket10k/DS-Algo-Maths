package dp.questions;

import java.util.Arrays;
import java.util.Scanner;

public class PathInMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[][] adj = new int[n][n];
		int[][] dp = new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(dp[i], -1);
			for(int j=0;j<n;j++) {
				adj[i][j]=sc.nextInt();
			}
		}
		boolean[][] visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					dfs(i, j, adj, visited, n, dp);
				}
			}
		}
		int max = 0;
		for(int i=0;i<n;i++) {

			System.out.println(Arrays.toString(dp[i]));
			for(int j=0;j<n;j++) {
				max = Math.max(dp[i][j], max);
			}
		}
		System.out.println(max);
		sc.close();
	}
	public static int dfs(int x, int y, int[][] adj, boolean[][] visited, int n, int[][] dp) {
		int[] x1 = new int[] {1,0,-1,0};
		int[] y1 = new int[] {0,1,0,-1};
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		int count = 0;
		for(int i=0;i<4;i++) {
			int x0 = x + x1[i];
			int y0 = y + y1[i];
			if(x0<0 || x0>=n || y0<0 || y0>=n || adj[x0][y0] - adj[x][y] !=1) {
				continue;
			}
			count = Math.max(count, dfs(x0, y0, adj, visited, n, dp));
		}
		dp[x][y] = count + 1;
		return count + 1;
	}
}
