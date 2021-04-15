package arraysStrings.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSortedArrayWithoutExtraSpace {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			String inputLine[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inputLine[0]);
			int m = Integer.parseInt(inputLine[1]);
			int arr1[] = new int[n];
			int arr2[] = new int[m];
			inputLine = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr1[i] = Integer.parseInt(inputLine[i]);
			}
			inputLine = br.readLine().trim().split(" ");
			for (int i = 0; i < m; i++) {
				arr2[i] = Integer.parseInt(inputLine[i]);
			}

			new MergeSort();
			MergeSort.merge(arr1, arr2, n, m);

			StringBuffer str = new StringBuffer();
			for (int i = 0; i < n; i++) {
				str.append(arr1[i] + " ");
			}
			for (int i = 0; i < m; i++) {
				str.append(arr2[i] + " ");
			}
			System.out.println(str);
		}
	}
}
// } Driver Code Ends

// User function Template for Java

class MergeSort {
	public static void swap(int[] arr1, int[] arr2, int i, int j) {
		int x = arr1[i];
		arr1[i] = arr2[j];
		arr2[j] = x;
	}

	public static void merge(int arr1[], int arr2[], int n, int m) {
		int i = n - 1;
		int j = 0;
		while (i >= 0 && j < m) {
			if (arr1[i] > arr2[j]) {
				swap(arr1, arr2, i, j);
				i--;
				j++;
			} else {
				i--;
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}

}
