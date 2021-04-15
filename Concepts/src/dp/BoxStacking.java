package dp;

import java.util.Arrays;

public class BoxStacking {

	static class Node {
		int l, w, h;

		public Node(int l, int w, int h) {
			this.l = l;
			this.w = w;
			this.h = h;
		}

	}

	public static int maxHeight(int height[], int width[], int length[], int n) {
		Node[] node = new Node[3 * n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			Node a1 = new Node(Math.max(length[i], width[i]), Math.min(length[i], width[i]), height[i]);
			node[index++] = a1;
			Node a2 = new Node(Math.max(width[i], height[i]), Math.min(width[i], height[i]), length[i]);
			node[index++] = a2;
			Node a3 = new Node(Math.max(height[i], length[i]), Math.min(height[i], length[i]), width[i]);
			node[index++] = a3;
		}
		Arrays.sort(node, (p1, p2) -> (p2.l * p2.w - p1.l * p1.w));
		int[] dp = new int[3 * n];
		for (int i = 0; i < 3 * n; i++) {
			dp[i] = node[i].h;
		}

		int max = -1;
		for (int i = 1; i < 3 * n; i++) {
			for (int j = 0; j < i; j++) {
				if (node[i].l < node[j].l && node[i].w < node[j].w) {
					dp[i] = Math.max(dp[i], dp[j] + node[i].h);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
