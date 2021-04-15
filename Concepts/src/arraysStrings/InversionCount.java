package arraysStrings;

import java.util.Scanner;

class InversionCount {
	// arr[]: Input Array
	// N : Size of the Array arr[]
	static long divide(long[] a, long[] helper, int start, int end) {
		long count = 0;
		if (start < end) {
			int mid = start + (end - start) / 2;
			count += divide(a, helper, start, mid);
			count += divide(a, helper, mid + 1, end);
			count += merge(a, helper, start, mid, end);
		}
		return count;
	}

	static long merge(long[] a, long[] helper, int start, int mid, int end) {
		long count = 0;
		for (int i = start; i <= end; i++) {
			helper[i] = a[i];
		}
		int index = start;
		int i = start;
		int j = mid + 1;
		for (; i <= mid && j <= end;) {
			if (helper[i] > helper[j]) {
				count += (mid + 1) - (i);
				a[index++] = helper[i++];
			} else {
				a[index++] = helper[j++];
			}
		}
		while (i <= mid) {
			a[index++] = helper[i++];
		}
		return count;
	}

	static long inversionCount(long a[], int n) {
		long[] helper = new long[n];
		return divide(a, helper, 0, n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(inversionCount(a, n));
		sc.close();
	}
}
