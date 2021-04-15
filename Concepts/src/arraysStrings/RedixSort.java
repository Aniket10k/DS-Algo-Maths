package arraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class RedixSort {
	static int[] redixSort(int[] a) {
		int max  = a[0];
		for(int i=1;i<a.length;i++) {
			max = Math.max(max, a[i]);
		}
		int place = 1;
		int base = 10;
		while(max > 0) {
			sort(a, place, base);
			max = max / 10;
			place*=10;
		}
		return a;
	}
	static void sort(int[] arr, int place, int base) {
		
		int[] freq = new int[base];
		int[] output = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			freq[(arr[i]/place)%base]++;
		}
		//System.out.println(Arrays.toString(freq));
		for(int i=1;i<base;i++) {
			freq[i] += freq[i-1];
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			output[freq[(arr[i]/place)%base]-1] = arr[i];
			freq[(arr[i]/place)%base] --;
		}
		for(int i=0;i<arr.length;i++) {
			arr[i] = output[i];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int[] ans = redixSort(a);
		System.out.println(Arrays.toString(ans));
		sc.close();
	}

}
