package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

	public DFS() {

	}

	public static void dfsIterative(int start, List<Integer>[] adj, boolean[] visited, List<Integer> ans) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		ans.add(start);
		visited[start] = true;
		while (!stack.isEmpty()) {
			int p = stack.pop();
			if(!visited[p]){
			    ans.add(p);
			    visited[p] = true;
			}
			for (int i = adj[p].size()-1; i>=0;i--) {
				if (!visited[adj[p].get(i)]) {
					stack.push(adj[p].get(i));
				}
			}
		}
	}

	public static void dfsRecursive(int start, List<Integer>[] adj, boolean[] visited, List<Integer> ans) {
		ans.add(start);
		visited[start] = true;
		for (int i : adj[start]) {
			if (!visited[i]) {
				dfsRecursive(i, adj, visited, ans);
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
				adj[i] = new ArrayList<Integer>();
			}
			int e = sc.nextInt();
			for (int i = 0; i < e; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
				//adj[b].add(a);
			}
			List<Integer> ans = new ArrayList<>();
			boolean[] visited = new boolean[n];
			dfsRecursive(0, adj, visited, ans);
			printArray(ans);
			 ans = new ArrayList<>();
			 visited = new boolean[n];
			 dfsIterative(0, adj, visited, ans);
			 System.out.println(ans.toString());
		}
		sc.close();
	}

}
