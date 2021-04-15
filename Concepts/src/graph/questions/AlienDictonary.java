package graph.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class AlienDictonary {

	public String findOrder(String[] dict, int n, int k) {
		int i = 0;
		List<Integer>[] adj = new ArrayList[k];
		for (int j = 0; j < k; j++) {
			adj[j] = new ArrayList<>();
		}
		while (i < dict.length - 1) {
			if (dict[i].equals(dict[i + 1])) {
				i++;
				continue;
			}

			int j = 0;
			while (j < dict[i].length() && j < dict[i + 1].length()) {
				if (dict[i].charAt(j) == dict[i + 1].charAt(j)) {
					j++;
				} else {
					adj[(int) (dict[i].charAt(j) - 'a')].add((int) (dict[i + 1].charAt(j) - 'a'));
					break;
				}
			}
			i++;
		}

		Set<Integer> set = new HashSet<>();

		Stack<Integer> stack = new Stack<>();

		for (int j = 0; j < k; j++) {
			if (!set.contains(j)) {
				dfs(adj, set, j, stack);
			}
		}

		StringBuilder ans = new StringBuilder("");
		while (!stack.isEmpty()) {
			ans.append((char) (stack.pop() + 'a'));
		}
		return ans.toString();

	}

	void dfs(List<Integer>[] adj, Set<Integer> set, int start, Stack<Integer> stack) {
		set.add(start);
		for (Integer p : adj[start]) {
			if (!set.contains(p)) {
				dfs(adj, set, p, stack);
			}
		}
		stack.push(start);
	}
}