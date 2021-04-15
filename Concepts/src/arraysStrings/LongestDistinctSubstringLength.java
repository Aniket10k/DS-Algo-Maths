package arraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class LongestDistinctSubstringLength {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			char[] c = sc.next().toCharArray();
			int startIndex = 0;
			int[] lastIndex = new int[256];
			Arrays.fill(lastIndex, -1);
			int maxLength = 0;
			for (int i = 0; i < c.length; i++) {
				// Find startindex for current char in distinct string
				startIndex = Math.max(startIndex, lastIndex[c[i]] + 1);

				maxLength = Math.max(maxLength, i - startIndex + 1);

				lastIndex[c[i]] = i;
			}
			System.out.println(maxLength);
		}
		sc.close();
	}

}
