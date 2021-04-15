package greedy.questions;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

	static class Node {
		int start;
		int end;
		int dist;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
			this.dist = end - start;
		}
	}

	static int activitySelection(int start[], int end[], int n) {
		Node[] a = new Node[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Node(start[i], end[i]);
		}
		Arrays.sort(a, new Comparator<Node>() {
			@Override
			public int compare(Node p1, Node p2) {
				return Integer.compare(p1.end, p2.end);
			}
		});
		int count = 0;
		int startPosition = -1;
		for (int i = 0; i < n; i++) {
			if (a[i].start >= startPosition) {
				count++;
				startPosition = a[i].end;
			}
		}
		return count;
	}
}