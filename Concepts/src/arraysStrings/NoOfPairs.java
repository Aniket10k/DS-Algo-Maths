package arraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class NoOfPairs {

	// Function to count number of pairs of x, y
	// x[], y[]: input array elements
	// n, m: size of arrays x[] and y[] respectively
	static long countPairs(int x[], int y[], int n, int m) {
		int[] pre = new int[5];
		for (int i = 0; i < m; i++) {
			if (y[i] < 5) {
				pre[y[i]]++;
			}
		}

		Arrays.sort(y);
		long total = 0;
		for (int i = 0; i < n; i++) {
			total = total + count(x[i], y, m, pre);
		}
		return total;
	}

	static long count(int x, int[] y, int n, int[] pre) {
		if (x == 1)
			return 0;
		int index = binarySearch(y, 0, n-1, x);
        index++;
        while(index<n && y[index]==x){
            index++;
        }
        
        /*int index = Arrays.binarySearch(y,x);
        if(index<0){
            index = Math.abs(index+1);
            
        } else{
            while(index<n && y[index]==x){
                index++;
            }
        }*/
        
		long ans = y.length - index;
		ans += pre[1];
		if (x == 2)
			ans -= (pre[3] + pre[4]);
		if (x == 3)
			ans += pre[2];
		return ans;

	}

	static int binarySearch(int[] y, int start, int end, int key) {
		if (start <= end) {
			int mid = (start + (end - start)/ 2); 
			if (y[mid] == key) {
				return mid;
			} else if (y[mid] > key) {
				return binarySearch(y, start, mid - 1, key);
			} else {
				return binarySearch(y, mid + 1, end, key);
			}
		} else {
			if (end == -1) {
				return -1;
			} else {
				return end;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[m];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i=0;i<m;i++) {
			b[i] = sc.nextInt();
		}
		System.out.print(countPairs(a, b, n, m));
		sc.close();
	}
}