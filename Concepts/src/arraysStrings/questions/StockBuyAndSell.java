package arraysStrings.questions;

import java.util.ArrayList;

public class StockBuyAndSell {
	ArrayList<ArrayList<Integer>> stockBuySell(int a[], int n) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int i = 0;
		while (i < n) {
			// minima
			while (i < n - 1 && a[i] >= a[i + 1]) {
				i++;
			}

			int buy = i;
			if (i == n - 1) {
				break;
			}
			i++;

			while (i < n && a[i] >= a[i - 1]) {
				i++;
			}

			int sell = i - 1;

			ArrayList<Integer> list = new ArrayList<>();
			list.add(buy);
			list.add(sell);
			ans.add(list);
		}
		return ans;
	}
}
