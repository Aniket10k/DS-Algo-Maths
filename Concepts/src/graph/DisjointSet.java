package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisjointSet {

	public static void union(int[] parent, int[] size, int i, int j) {
		int x = root(parent, i);
		int y = root(parent, j);

		if (size[x] > size[y]) {
			parent[x] = y;
			size[x] += size[y];
		} else {
			parent[y] = x;
			size[y] += size[x];
		}

	}

	public static int root(int[] parent, int i) {
		while (i != parent[i]) {
			parent[i] = parent[parent[i]];
			i = parent[i];
		}
		return i;
	}

	public static boolean isCycle(List<Integer>[] adj, int n) {
		int[] parent = new int[n];
		int[] size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		for (int i = 0; i < adj.length; i++) {
			for (int j : adj[i]) {
				int x = root(parent, i);
				int y = root(parent, j);
				if (x == y)
					return true;
				union(parent, size, i, j);
			}
		}
		return false;
	}
	//Answer to detection of loop in undirected graph
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			List<Integer>[] adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
			}
			int e = sc.nextInt();
			for (int i = 0; i < e; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
			}
			boolean ans = isCycle(adj, n);
			System.out.println(ans);
		}
		sc.close();

	}

}
