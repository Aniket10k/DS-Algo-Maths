package arraysStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestPalindromeN2 {

	static class Node {
		int count;
		int left;
		int right;

		Node(int count, int left, int right) {
			this.count = count;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			char[] c = sc.next().toCharArray();
			// odd lenegth palindrome
			int n = c.length;
			List<Node> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int count = 0;
				int left = i;
				int right = i;
				while (left >= 0 && right < n && c[left] == c[right]) {
					if (left == right) {
						count++;
					} else {
						count += 2;
					}
					left--;
					right++;
				}
				list.add(new Node(count, left + 1, right - 1));
			}
			//even length palindrome
			for (int i = 0; i < n - 1; i++) {
				int count = 0;
				int left = i;
				int right = i + 1;
				while (left >= 0 && right < n && c[left] == c[right]) {
					count += 2;
					left--;
					right++;
				}
				list.add(new Node(count, left + 1, right - 1));
			}
			int max = 0;
			int index = 0;
			for (int i = 0; i < list.size(); i++) {
				if (max < list.get(i).count) {
					max = list.get(i).count;
					index = i;
				}
			}
			System.out.println(new String(Arrays.copyOfRange(c, list.get(index).left, list.get(index).right + 1)));
		}
	}
}