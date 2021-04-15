package heap;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int[] heap = new int[n];
		createHeap(a, heap, n);
		for (int i = 0; i < n; i++) {
			a[n-i-1] = deleteMax(heap, n - i - 1);
			// System.out.println("Heap1 : "+Arrays.toString(heap));
			heapify(heap, n - i - 2);
			// System.out.println("Heap2 : "+Arrays.toString(heap));
		}
		System.out.println(Arrays.toString(a));
		sc.close();
	}

	private static void insert(int[] heap, int index, int value) {
		heap[index] = value;
		while (index > 0 && heap[(index - 1) / 2] < value) {
			swap(heap, (index - 1) / 2, index);
			index = (index - 1) / 2;
		}
	}

	private static void createHeap(int[] a, int[] heap, int n) {
		heap[0] = a[0];
		for (int i = 1; i < n; i++) {
			insert(heap, i, a[i]);
		}
		// System.out.println(Arrays.toString(heap));
	}

	private static void heapify(int[] heap, int i) {
		int index = 0;
		while (index * 2 + 2 <= i) {
			if (heap[index * 2 + 1] >= heap[index * 2 + 2]) {
				swap(heap, index, index * 2 + 1);
				index = index * 2 + 1;
			} else {
				swap(heap, index, index * 2 + 2);
				index = index * 2 + 2;
			}
		}
	}

	private static int deleteMax(int[] heap, int i) {
		int ret = heap[0];
		swap(heap, 0, i);
		heap[i] = 0;
		return ret;
	}

	private static void swap(int[] heap, int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
}
