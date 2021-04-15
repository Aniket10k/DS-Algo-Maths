package graph.questions;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SnakeAndLadder {
    static class Node{
        int index;
        int value;
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    List<Integer>[] adj = new ArrayList[31];
		    for(int i=0;i<31;i++){
		        adj[i] = new ArrayList<>();
		    }
		    for(int i=1;i<31;i++){
		        for(int j=1;j<=6;j++){
		            if(i+j<=30){
		                adj[i].add(i+j);
		            }
		        }
		    }
		    for(int i=0;i<n;i++){
		        int p = sc.nextInt();
		        int q = sc.nextInt();
		        for(int j=1;j<=6;j++){
		            if(p-j > 0){
		                adj[p-j].add(q);      
		            }
		        }
		    }
		    int[] dist = new int[31];
		    Arrays.fill(dist, Integer.MAX_VALUE);
		    int[] visited = new int[31];
		    PriorityQueue<Node> pq = new PriorityQueue<>((p1,p2)->(p1.value-p2.value));
		    pq.add(new Node(1,0));
		    int index = 0;
		    int found = 0;
		    dist[1] = 0;
		    while(index!=30){
		        Node p = pq.remove();
		        if(visited[p.index]==1){
		            continue;
		        }
		        if(p.index==30){
		            System.out.println(p.value);
		            found = 1;
		            break;
		        }
		        
		        index++;
		        visited[p.index] = 1;
		        for(int i : adj[p.index]){
		            if(visited[i]==0){
		                dist[i] = Math.min(dist[i], dist[p.index] + 1);
		                pq.add(new Node(i, dist[i]));
		            }
		        }
		    }
		    if(found==0){
		        System.out.println(-1);
		    }
		}
	}
}