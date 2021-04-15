package graph.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinSwapsToSort {
	static int dfs(List<Pair>[] adj, int[] visited, int start, int count) {
		visited[start] = 1;
		count++;
		for (Pair i : adj[start]) {
			if (visited[i.index] == 0) {
				count = dfs(adj, visited, i.index, count);
			}
		}
		return count;
	}

	static class Pair {
		int index, value;

		public Pair(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		List<Pair>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}
		Arrays.sort(b);
		for (int i = 0; i < n; i++) {
			if (a[i] != b[i]) {
				int j = Arrays.binarySearch(b, a[i]);
				adj[i].add(new Pair(j, b[i]));
			}
		}
		int[] visited = new int[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				int count = dfs(adj, visited, i, 0);
				ans += (count - 1);
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
