package arraysStrings.questions;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseString {
	static String  reverseWords(String str) {
		String[] s = str.split("\\.");
		System.out.println(Arrays.toString(s));
		StringBuilder ans = new StringBuilder();
		for (int i = s.length -1; i >= 0  ; i--) {
			System.out.println(s[i]);
			ans.append(s[i]);
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(reverseWords(s));
	}

	
}
