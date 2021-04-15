package greedy.questions;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class LRUf {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
		    a[i] = sc.nextInt();
		}
		int fault=0;
		int k = sc.nextInt();
		Set<Integer> set = new HashSet<>(k);
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		int time = 0 ;
		for(;set.size()!=k && i<n;i++){
		    if(!set.contains(a[i])){
		        map.put(a[i], time);
		        time++;
		        set.add(a[i]);
		        fault++;
		    } else{
		        map.put(a[i], time);
		        time++;
		    }
		}
		
		for(;i<n;i++){
		    if(!set.contains(a[i])){
		        int min = Integer.MAX_VALUE;
		        int minIndex = 0;
		        for(Map.Entry<Integer, Integer> p : map.entrySet()){
		            if(p.getValue() < min){
		                min = p.getValue();
		                minIndex = p.getKey();
		            }
		        }
		        map.remove(minIndex);
		        set.remove(minIndex);
		        map.put(a[i], time);
		        time++;
		        set.add(a[i]);
		        fault++;
		    } else{
		        map.put(a[i], time);
		        time++;
		    }
		}
		System.out.println(fault);
		}
		sc.close();
	}
}