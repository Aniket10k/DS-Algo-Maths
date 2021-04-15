package arraysStrings.questions;

public class ZigZagArray {
	void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	void zigZag(int a[], int n) {
		boolean flag = false;
		for (int i = 0; i < n - 1; i++) {
			if (!flag) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
				}
				flag = true;
			} else {
				if (a[i] < a[i + 1]) {
					swap(a, i, i + 1);
				}
				flag = false;
			}
		}
	}

}