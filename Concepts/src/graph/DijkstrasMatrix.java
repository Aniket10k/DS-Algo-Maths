package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstrasMatrix {
	static int minDistance(int[] dist, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<visited.length;i++){
            if(!visited[i] && dist[i]<min){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
    static int[] dijkstra(List<Integer>[] adj, int start, int n){
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        for(int i=0;i<n-1;i++){
            int p = minDistance(dist, visited);
            visited[p] = true;
            for(int j=0;j<n;j++){
                if(!visited[j] && adj[p].get(j)>0){
                    dist[j] = Math.min(dist[j], dist[p]+adj[p].get(j));
                }
            }
        }
        return dist;
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
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					adj[i].add(sc.nextInt());
				}
			}
			int start = sc.nextInt();
			System.out.println(Arrays.toString(dijkstra(adj, start, n)));
		}
		sc.close();
	}
}
