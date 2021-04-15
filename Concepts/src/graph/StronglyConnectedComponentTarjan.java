package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class StronglyConnectedComponentTarjan {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

		for (int i = 0; i < e; i++) {
			ArrayList<Integer> l = new ArrayList<>();
			int p = sc.nextInt();
			int q = sc.nextInt();
			l.add(p);
			l.add(q);
			edges.add(l);
		}
		System.out.println(tarjan(edges, n));
		sc.close();

	}
}
