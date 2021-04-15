package graph.questions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostPathOnGrid {
	static class Node {
	    int x, y, dist;
	    Node (int x, int y, int d) {
	        this.x = x;
	        this.y = y;
	        this.dist = d;
	    }
	}
	private static int shortest(int grid[][], int n) {
		int[][] visited = new int[n][n];
		PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2) -> (p1.dist - p2.dist));
		pq.add(new Node(0, 0, 0));

		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = grid[0][0];
		int[] x1 = new int[] { 1, 0, -1, 0 };
		int[] y1 = new int[] { 0, 1, 0, -1 };
		int index = 0;
		while (index != n * n) {
			Node p = pq.remove();
			if (p.x == n - 1 && p.y == n - 1) {
				return dist[n - 1][n - 1];
			}
			if (visited[p.x][p.y] == 1) {
				continue;
			}
			visited[p.x][p.y] = 1;
			index++;
			for (int i = 0; i < 4; i++) {
				int x = p.x + x1[i];
				int y = p.y + y1[i];
				if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] == 1) {
					continue;
				}
				dist[x][y] = Math.min(dist[x][y], dist[p.x][p.y] + grid[x][y]);
				pq.add(new Node(x, y, dist[x][y]));
			}
		}
		return -1;
	}
}
