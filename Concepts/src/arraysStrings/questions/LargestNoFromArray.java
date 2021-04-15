package arraysStrings.questions;

import java.util.Arrays;

public class LargestNoFromArray {
	String printLargest(String[] a) {
		Arrays.sort(a, (p, q) -> (q + p).compareTo(p + q));
		return String.join("", a);
	}
}
