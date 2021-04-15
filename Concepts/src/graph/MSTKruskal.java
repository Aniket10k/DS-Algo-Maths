package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MSTKruskal {

	static int root(int[] parent, int i) {
		while (parent[i] != i) {
			parent[i] = parent[parent[i]];
			i = parent[i];
		}
		return i;
	}

	static void union(int[] parent, int[] size, int a, int b) {
		int root_A = root(parent, a);
		int root_B = root(parent, b);
		if (size[root_A] < size[root_B]) {
			parent[root_B] = root_A;
			size[root_A] += size[root_B];
		} else {
			parent[root_A] = root_B;
			size[root_B] += size[root_A];
		}
	}

	static class Node {
		int start, end, dist;

		Node(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
	}

	static int spanningTree(int n, int E, ArrayList<ArrayList<Integer>> graph) {
		int[] parent = new int[n];
		int[] size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		List<Node> list = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				if (graph.get(i).get(j) > 0) {
					list.add(new Node(i, j, graph.get(i).get(j)));
				}
			}
		}

		int ans = 0;
		List<Node> ansList = new ArrayList<>();
		Collections.sort(list, (p1, p2) -> (p1.dist - p2.dist));
		for (Node i : list) {
			if (root(parent, i.start) != root(parent, i.end)) {
				union(parent, size, i.start, i.end);
				ans = ans + graph.get(i.start).get(i.end);
				ansList.add(new Node(i.start, i.end, graph.get(i.start).get(i.end)));
			}
		}

		return ans;

	}
}
