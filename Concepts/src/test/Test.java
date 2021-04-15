package test;

import java.util.PriorityQueue;
import java.util.Scanner;

class Test {

	static class Entry {
		int x, y;
		int distance;

		public Entry(int a, int b, int c) {
			x = a;
			y = b;
			distance = c;
		}
	}

	public static void minDistance(int[][] grid, int start_i, int start_j, int end_i, int end_j) {
		PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

		int n = grid.length, m = grid[0].length;
		// add source node
		pq.add(new Entry(start_i, start_j, 0));
		boolean[][] vis = new boolean[n][m];
		while (pq.size() > 0) {

			Entry curr = pq.remove();
			int i = curr.x, j = curr.y;
			if (vis[i][j])
				continue;
			vis[i][j] = true;

			if (i == end_i && j == end_j) {
				System.out.println(curr.distance);
				return;
			}

			if (i + 1 < n && grid[i][j] != 0) {
				pq.add(new Entry(i + 1, j, curr.distance + 1));
			}

			if (j + 1 < m && grid[i][j] != 0) {
				pq.add(new Entry(i, j + 1, curr.distance + 1));
			}

			if (i - 1 >= 0 && grid[i][j] != 0) {
				pq.add(new Entry(i - 1, j, curr.distance + 1));
			}

			if (j - 1 >= 0 && grid[i][j] != 0) {
				pq.add(new Entry(i, j - 1, curr.distance + 1));
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] adj = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					adj[i][j] = sc.nextInt();
				}
			}
			int x0 = sc.nextInt();
			int y0 = sc.nextInt();
			minDistance(adj, 0, 0, x0, y0);
		}

	}
}