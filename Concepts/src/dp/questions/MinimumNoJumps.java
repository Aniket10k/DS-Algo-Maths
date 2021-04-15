package dp.questions;

public class MinimumNoJumps {

	static int minJumps(int[] arr) {
		if (arr[0] == 0)
			return -1;
		int jump = 1;
		int step = arr[0];
		int maxReach = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length - 1) {
				return jump;
			}

			maxReach = Math.max(maxReach, arr[i] + i);
			step--;
			if (step == 0) {
				jump++;
				if (i >= maxReach) {
					return -1;
				}
				step = maxReach - i;
			}
		}
		return -1;

	}
}