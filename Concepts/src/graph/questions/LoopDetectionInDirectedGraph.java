package graph.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LoopDetectionInDirectedGraph {
	public static boolean loopDetectionRecursion(int start, List<Integer>[] adj, boolean[] visited, List<Integer> ans) {
		visited[start] = true;
		for (Integer i : adj[start]) {
			if (ans.contains(i)) {
				return true;
			}
			if (!visited[i]) {
				ans.add(i);
				boolean isLoop = loopDetectionRecursion(i, adj, visited, ans);
				ans.remove(i);
				if (isLoop)
					return true;
			}
		}
		return false;
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
				// adj[b].add(a);
			}
			boolean[] visited = new boolean[n];
			List<Integer> ans = new ArrayList<>();
			boolean isLoop = false;
			for (int i = 0; i < n; i++) {
				if (visited[i])
					continue;
				ans.add(i);
				isLoop = loopDetectionRecursion(i, adj, visited, ans);
				ans.remove((Integer) i);
				if (isLoop) {
					break;
				}
			}
			System.out.println(isLoop);
		}
		sc.close();

	}

}
