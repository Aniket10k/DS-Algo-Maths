package greedy.questions;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class GeekCollectsTheBall {
	public static void main (String[] args) {
		Scanner sc=  new Scanner(System.in);
		int t= sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int[] a = new int[n];
		    int[] b = new int[m];
		    for(int i=0;i<n;i++){
		        a[i] = sc.nextInt();
		    }
		    for(int i=0;i<m;i++){
		        b[i] = sc.nextInt();
		    }
		    
		    int a1 = 0;
		    int b1 = 0;
		    int maxA = 0;
		    int maxB = 0;
		    while(a1<n && b1<m){
		        if(a[a1] == b[b1]){
		            while(a1+1 < n && a[a1] == a[a1+1]){
		                maxA+=a[a1];
		                a1++;
		            }
		            while(b1+1 < m && b[b1] == b[b1+1]){
		                maxB+=b[b1];
		                b1++;
		            }
		            int max = Math.max(maxA, maxB) + a[a1];
		            maxA = max;
		            maxB = max;
		            a1++;
		            b1++;
		        } else if(a[a1] > b[b1]){
		            maxB +=b[b1];
		            b1++;
		        } else{
		            maxA += a[a1];
		            a1++;
		        }
		    }
		    while(a1<n){
		        maxA+=a[a1];
		        a1++;
		    }
		    while(b1<m){
		        maxB+=b[b1];
		        b1++;
		    }
		    System.out.println(Math.max(maxA,maxB));
		    
		    
	    }
	}
}