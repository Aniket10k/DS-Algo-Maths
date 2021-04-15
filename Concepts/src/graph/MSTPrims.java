package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Matrix input
public class MSTPrims {
	// User function Template for Java
	static class Node {
		int start;
		int node;
		int dist;

		public Node(int start, int node, int dist) {
			this.start = start;
			this.node = node;
			this.dist = dist;
		}
	}

	static int spanningTree(int n, int E, ArrayList<ArrayList<Integer>> graph) {
		int[] visited = new int[n];
		int index = 0;
		int ans = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2) -> (p1.dist - p2.dist));
		pq.add(new Node(0, 0, 0));
		List<Node> tree = new ArrayList<>();
		while (index != n) {
			Node p = pq.remove();
			if (visited[p.node] == 1) {
				continue;
			}
			if (p.node != 0) {
				ans += p.dist;
				tree.add(new Node(p.start, p.node, p.dist));
			}
			index++;
			visited[p.node] = 1;
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0 && graph.get(p.node).get(i) > 0) {
					pq.add(new Node(p.node, i, graph.get(p.node).get(i)));
				}
			}

		}
		return ans;

	}

}
