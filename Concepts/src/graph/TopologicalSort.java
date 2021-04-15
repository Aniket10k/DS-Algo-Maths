package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {
	public static void dfs(int start, List<Integer>[] adj, boolean[] visited, Stack<Integer> stack) {
		visited[start] = true;
		for(Integer i : adj[start]) {
			if(!visited[i]) {
				dfs(i, adj, visited, stack);
			}
		}
		stack.push(start);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int e = sc.nextInt();
			int n = sc.nextInt();
			List<Integer>[] adj = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < e; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
			}
			List<Integer> ans = new ArrayList<>();
			boolean[] visited = new boolean[n];
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					dfs(i, adj, visited, stack);
				}
			}
			while(!stack.isEmpty()) {
				ans.add(stack.pop());
			}
			System.out.println(ans.toString());
		}
		sc.close();

	}

}
