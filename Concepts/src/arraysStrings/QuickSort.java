package arraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private static int[] sort(int[] a, int start, int end) {
		if (start < end) {
			int pivot = a[start];
			int i = start  + 1;
			for(int j = i; j<=end; j++) {
				if(a[j] < pivot) {
					swap(a, i, j);
					i++;
				}
			}
			swap(a, i - 1, start);
			sort(a, start, i - 2);
			sort(a, i, end);
		}
		return a;
	}

	private static int[] quickSort(int[] a) {
		int start = 0;
		int end = a.length - 1;
		return sort(a, start, end);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int[] ans = quickSort(a);
		System.out.println(Arrays.toString(ans));
		sc.close();
	}
}
