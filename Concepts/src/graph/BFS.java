package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	public static void bfs2(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int p = queue.remove();
			if(!visited[p]){
			    ans.add(p);
			    visited[p] = true;
			}
			for (int i : adj.get(p)) {
				if (!visited[i]) {
					queue.add(i);
				}
			}
		}
	}
	public static void bfs(int start, List<Integer>[] adj, boolean[] visited, List<Integer> ans) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		ans.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int p = queue.remove();
			for (int i : adj[p]) {
				if (!visited[i]) {
					queue.add(i);
					ans.add(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void printArray(List<Integer> ans) {
		for (int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

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
				adj[b].add(a);
			}
			boolean[] visited = new boolean[n];
			List<Integer> ans = new ArrayList<>();
			bfs(0, adj, visited, ans);
			printArray(ans);
		}
		sc.close();
	}

}
