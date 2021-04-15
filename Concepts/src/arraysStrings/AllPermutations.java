package arraysStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AllPermutations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		List<String> ans = new ArrayList<>();
		List<StringBuilder>[] list = new ArrayList[s.length];
		list[0] = new ArrayList<StringBuilder>();
		list[0].add(new StringBuilder(""+s[0]));
		ans.add(""+s[0]);
		for (int i = 1; i < s.length; i++) {
			List<StringBuilder> jList = new ArrayList<>();
			for (int j = 0; j < list[i - 1].size(); j++) {
				StringBuilder sb1 = list[i - 1].get(j);
				for (int k = 0; k <= i; k++) {
					StringBuilder sb = sb1.insert(k, s[i]);
					jList.add(new StringBuilder(sb));
					ans.add(sb.toString());
					sb1.deleteCharAt(k);
				}
				
			}
			list[i] = jList;
		}
		Collections.sort(list[s.length - 1]);
		for (int i = 0; i < list[s.length - 1].size(); i++) {
			System.out.print(list[s.length - 1].get(i) + " ");
		}
	}
}