package arraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	static int binarySearch(int[] a, int start, int end, int key) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		// System.out.println(start + " " + end);
		if (end == -1) {
			System.out.println("Key is less than first element");
		} else if (start == a.length) {
			System.out.println("Key is greater than last element");
		} else {
			System.out.println("Smaller No.: " + a[end] + " Larger No.: " + a[start]);
		}
		return -1;
	}

	int binary(int[] a, int n, int start, int end, int key) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] > key) {
				return binary(a, n, start, mid - 1, key);
			} else {
				return binary(a, n, mid + 1, end, key);
			}
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int key = sc.nextInt();
		int index = binarySearch(a, 0, n - 1, key);
		System.out.println(index);
		System.out.println(Arrays.binarySearch(a, key));
		sc.close();
	}
}
