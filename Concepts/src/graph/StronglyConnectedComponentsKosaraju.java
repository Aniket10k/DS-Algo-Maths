package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnectedComponentsKosaraju {
	
		public static void dfs(List<Integer>[] adj, int start, int n, boolean[] visited, Stack<Integer> stack) {
			visited[start] = true;
			for (Integer i : adj[start]) {
				if (!visited[i]) {
					dfs(adj, i, n, visited, stack);
				}
			}
			stack.push(start);
		}

		public static void dfs1(List<Integer>[] adj, int start, int n, boolean[] visited, List<Integer> list) {
			visited[start] = true;
			list.add(start);
			for (Integer i : adj[start]) {
				if (!visited[i]) {
					dfs1(adj, i, n, visited, list);
				}
			}
		}

		public static int kosaraju(ArrayList<ArrayList<Integer>> a, int n) {
			List<Integer>[] adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < a.size(); i++) {
				adj[a.get(i).get(0)].add(a.get(i).get(1));
			}
			Stack<Integer> stack = new Stack<>();
			boolean[] visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					dfs(adj, i, n, visited, stack);
				}
			}
			adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < a.size(); i++) {
				adj[a.get(i).get(1)].add(a.get(i).get(0));
			}
			visited = new boolean[n];
			List<List<Integer>> ans = new ArrayList<>();
			int index = 0;
			while (!stack.isEmpty()) {

				int p = stack.pop();
				if (!visited[p]) {
					List<Integer> list = new ArrayList<>();
					dfs1(adj, p, n, visited, list);
					ans.add(list);
				}

			}

			return ans.size();

		}
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

		for (int i = 0; i < e; i++) {
			ArrayList<Integer> l = new ArrayList<>();
			int p = sc.nextInt();
			int q = sc.nextInt();
			l.add(p);
			l.add(q);
			edges.add(l);
		}
		System.out.println(kosaraju(edges, n));
		sc.close();

	}

}
