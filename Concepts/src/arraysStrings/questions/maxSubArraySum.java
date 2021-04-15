package arraysStrings.questions;

public class maxSubArraySum {
	int maxSubarraySum(int arr[], int n) {

		int max = arr[0];
		int sum = 0;
		if (arr[0] >= 0) {
			sum = arr[0];
		} else {
			sum = 0;
		}
		for (int i = 1; i < n; i++) {
			sum = sum + arr[i];

			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;

	}
}
