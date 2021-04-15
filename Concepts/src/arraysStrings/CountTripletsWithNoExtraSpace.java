package arraysStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountTripletsWithNoExtraSpace {

	public static void main(String args[]) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {

			int n = Integer.parseInt(read.readLine());
			String input[] = read.readLine().split(" ");

			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}

			Solution ob = new Solution();
			System.out.println(ob.countTriplet(arr, n));
		}
	}
}// } Driver Code Ends

// User function Template for Java

class Solution {
	int countTriplet(int a[], int n) {
		Arrays.sort(a);
		int i = n - 1;
		int count = 0;
		while (i > 1) {

			int j = 0;
			int k = i - 1;

			while (j < k) {

				if (a[j] + a[k] == a[i]) {
					count++;
					j++;
					k--;
				} else if (a[j] + a[k] > a[i]) {
					k--;
				} else {
					j++;
				}
			}

			i--;

		}
		return count;

	}

}
