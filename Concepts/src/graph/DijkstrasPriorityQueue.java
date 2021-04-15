package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class DijkstrasPriorityQueue {

	static class Pair {
		int value;
		int dist;

		public Pair(int value, int dist) {
			this.value = value;
			this.dist = dist;
		}
	}

	static int[] dikstras(List<Pair>[] adj, int source) {
		int n = adj.length;
		Set<Integer> set = new HashSet<>();
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[source] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> (p1.dist - p2.dist));
		/*
		 * PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
		 * 
		 * @Override public int compare(Pair p1, Pair p2) { return
		 * Integer.compare(p1.dist, p2.dist); } });
		 */
		pq.add(new Pair(0, 0));
		while (set.size()!=n) {
			Pair p = pq.remove();
			set.add(p.value);
			for(Pair i : adj[p.value]) {
				if(!set.contains(i.value)) {
					dist[i.value] = Math.min(dist[i.value], dist[p.value] + i.dist);
					pq.add(new Pair(i.value, dist[i.value]));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int e = sc.nextInt();
		List<Pair>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < e; i++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int d = sc.nextInt();
			adj[p].add(new Pair(q, d));
		}
		int source = sc.nextInt();
		int[] dist = dikstras(adj, source);
		System.out.println(Arrays.toString(dist));
		sc.close();

	}

}
