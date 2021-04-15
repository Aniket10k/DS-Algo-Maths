package backtracking;
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NQueens {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());

			Solution ob = new Solution();
			ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
			if (ans.size() == 0)
				System.out.println("-1");
			else {
				for (int i = 0; i < ans.size(); i++) {
					System.out.print("[");
					for (int j = 0; j < ans.get(i).size(); j++)
						System.out.print(ans.get(i).get(j) + " ");
					System.out.print("] ");
				}
				System.out.println();
			}
		}
	}
}

class Solution {
	static ArrayList<ArrayList<Integer>> ans;

	static ArrayList<ArrayList<Integer>> nQueen(int n) {
		int[][] adj = new int[n][n];
		ans = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			rec(adj, 0, i, n, list);
		}
		return ans;
	}

	static void rec(int[][] adj, int x, int y, int n, ArrayList<Integer> list) {
		if (x == n - 1) {
			list.add(y + 1);
			ans.add(new ArrayList<>(list));
			list.remove((Integer) (y + 1));
			return;
		}
		adj[x][y] = 1;
		list.add(y + 1);
		for (int j = 0; j < n; j++) {
			if (isSafe(adj, x + 1, j, n)) {
				rec(adj, x + 1, j, n, list);
			}
		}
		adj[x][y] = 0;
		list.remove((Integer) (y + 1));
	}

	static boolean isSafe(int[][] adj, int x, int y, int n) {
		for (int i = x + 1; i < n; i++) {
			if (adj[i][y] == 1)
				return false;
		}
		for (int i = x - 1; i >= 0; i--) {
			if (adj[i][y] == 1)
				return false;
		}
		for (int i = y + 1; i < n; i++) {
			if (adj[x][i] == 1)
				return false;
		}
		for (int i = y - 1; i >= 0; i--) {
			if (adj[x][i] == 1)
				return false;
		}
		for (int i = x + 1, j = y + 1; i < n && j < n; i++, j++) {
			if (adj[i][j] == 1)
				return false;
		}
		for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			if (adj[i][j] == 1)
				return false;
		}
		for (int i = x + 1, j = y - 1; i < n && j >= 0; i++, j--) {
			if (adj[i][j] == 1)
				return false;
		}
		for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
			if (adj[i][j] == 1)
				return false;
		}
		return true;
	}
}