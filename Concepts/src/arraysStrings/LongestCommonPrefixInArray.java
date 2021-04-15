package arraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonPrefixInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String[] a = new String[n];
			int minLength = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				a[i] = sc.next();
				minLength = Math.min(minLength, a[i].length());
			}
			//n2(a, minLength, n);
			Arrays.sort(a);
			int len = Math.min(a[0].length(), a[n-1].length());
			int i = 0;
			while(i<len) {
				if(a[0].charAt(i)==a[n-1].charAt(i)) {
					i++;
				} else {
					break;
				}
			}
			if(i==0) {
				System.out.println(-1);
			} else
				System.out.println(a[0].substring(0,i));
		}
	}
	static void n2(String[] a, int minLength, int n){
		int lastIndex = 0;
		int index = 0;
		for (; index < minLength; index++) {
			boolean k = false;
			for (int i = 1; i < n; i++) {
				// System.out.println( a[i].charAt(index) + " "+ a[i-1].charAt(index) );
				if (a[i].charAt(index) == a[i - 1].charAt(index)) {
					continue;
				} else {
					k = true;
					lastIndex = index;
					break;
				}
			}
			if (k) {
				break;
			}
		}
		// System.out.println(index);
		if (index == minLength) {
			System.out.println(a[0].substring(0, index));
		} else if (lastIndex == 0) {
			System.out.println(-1);
		} else {
			System.out.println(a[0].substring(0, lastIndex));
		}
	}

}
