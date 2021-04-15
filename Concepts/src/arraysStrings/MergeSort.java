package arraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i=0;
		int j=0;
		int index = 0;
		while(i<a.length && j<b.length) {
			if(a[i] <= b[j]) {
				c[index++] = a[i++];
			} else {
				c[index++] = b[j++];
			}
		}
		while(i<a.length) {
			c[index++] =  a[i++];
		}
		while(j<b.length) {
			c[index++] = b[j++];
		}
		return c;
	}
	public static int[] divide(int[] arr, int start, int end) {
		if(start < end) {
			int mid = start + (end - start)/2;
			int[] a = divide(arr, start, mid);
			int[] b = divide(arr, mid+1, end);
			return merge(a, b);
		} else {
			return new int[] {arr[start]};
		}
	}
	public static int[] mergeSort(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		return divide(arr, start, end);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		int[] ans = mergeSort(a);
		System.out.println(Arrays.toString(ans));
		
		sc.close();
	}
}
