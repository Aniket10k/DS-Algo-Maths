package graph.questions;

import java.util.ArrayList;

class IslandsInMatrix {

	// Function to find the number of island in the given list A
	// N, M: size of list row and column respectively
	static int findIslands(ArrayList<ArrayList<Integer>> A, int n, int m) {

		int[][] visited = new int[n][m];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A.get(i).get(j) == 1 && visited[i][j] == 0) {
					count++;
					dfs(i, j, A, visited, n, m);
				}
			}
		}
		return count;
	}

	static void dfs(int i, int j, ArrayList<ArrayList<Integer>> adj, int[][] visited, int n, int m) {
		visited[i][j] = 1;
		int[] x1 = new int[] { 0, 1, 0, -1, 1, -1, 1, -1 };
		int[] y1 = new int[] { 1, 0, -1, 0, 1, -1, -1, 1 };
		for (int t = 0; t < 8; t++) {
			int x = i + x1[t];
			int y = j + y1[t];
			if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] == 1) {
				continue;
			}
			if (adj.get(x).get(y) == 1) {
				dfs(x, y, adj, visited, n, m);
			}
		}
	}
}