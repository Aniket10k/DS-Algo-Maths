package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AllPermutations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		List<String> ans = new ArrayList<>();
		backTrack(s, 0, s.length, ans);
		Collections.sort(ans);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i)+" ");
		}
	}

	static void swap(char[] c, int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}

	static void backTrack(char[] c, int index, int n, List<String> list) {
		if(index==n) {
			list.add(new String(c));
		}
		for (int i = index; i < n; i++) {
			swap(c, i, index);
			backTrack(c, index+1, n, list);
			swap(c, i, index);
		}
	}
}
