package arraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort2 {
	public static void merge(int[] arr, int[] helper, int start, int mid, int end) {
		for(int i = start; i <=end ; i++) {
			helper[i] = arr[i];
		}
		int i=start;
		int j=mid+1;
		int index = start;
		while(i<=mid && j<=end) {
			if(helper[i] <= helper[j]) {
				arr[index++] = helper[i++];
			} else {
				arr[index++] = helper[j++];
			}
		}
		while(i<=mid) {
			arr[index++] =  helper[i++];
		}
	}
	public static void divide(int[] arr, int[] helper, int start, int end) {
		if(start < end) {
			int mid = start + (end - start)/2;
			divide(arr, helper, start, mid);
			divide(arr, helper, mid+1, end);
			merge(arr, helper, start, mid, end);
		}
	}
	public static void mergeSort(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int[] helper= new int[arr.length];
		divide(arr, helper, start, end);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		mergeSort(a);
		System.out.println(Arrays.toString(a));
		sc.close();
	}
}
