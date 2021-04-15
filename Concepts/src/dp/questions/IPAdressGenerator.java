package dp.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IPAdressGenerator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();	
		while (t-- > 0) {
			String s = sc.next();	
			Solution sln = new Solution();
			ArrayList<String> str = sln.genIp(s);
			Collections.sort(str);
			for (String u : str) {
				System.out.println(u);
			}
		}
	}
}
class Solution {
	public boolean isValid(String s) {
		String[] a = s.split("[.]");
		for (int i = 0; i < a.length; i++) {
			if (a[i].trim().length() == 0) {
				return false;
			}
			int k = Integer.parseInt(a[i]);
			if (a[i].length() > 3 || k < 0 || k > 255) {
				return false;
			}
			if (a[i].length() > 1 && k == 0) {
				return false;
			}
			if (a[i].length() > 1 && k != 0 && a[i].charAt(0) == '0') {
				return false;
			}
		}
		return true;
	}

	public ArrayList<String> genIp(String s) {
		int n = s.length();
		if (n < 3 || n > 12) {
			return new ArrayList<>();
		}
		ArrayList<String> ans = new ArrayList<>();
		String snew = new String(s);
		for (int i = 1; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					snew = snew.substring(0, k) + "." + snew.substring(k);
					snew = snew.substring(0, j) + "." + snew.substring(j);
					snew = snew.substring(0, i) + "." + snew.substring(i);
					if (isValid(snew)) {
						ans.add(snew);
					}
					snew = new String(s);
				}
			}
		}
		return ans;
	}
}