package backtracking;

import java.util.Scanner;

public class Sudoku {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int grid[][] = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					grid[i][j] = sc.nextInt();
			}

			if (Sudoku1.SolveSudoku(grid) == true)
				Sudoku1.printGrid(grid);
			else
				System.out.print("NO solution exists");
			System.out.println();

		}
		sc.close();
	}
}

class Sudoku1 {
	static boolean SolveSudoku(int grid[][]) {
		return rec(grid);
	}

	static boolean rec(int[][] a) {

		int j = 0;
		int i = 0;
		boolean b = false;
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				// System.out.println(i+" "+j+" "+a[i][j]);
				if (a[i][j] == 0) {
					b = true;
					break;
				}
			}
			if (b) {
				break;
			}
		}
		if (!b) {
			return true;
		}
		// System.out.println(i+" "+j);
		for (int val = 1; val <= 9; val++) {
			if (isSafe(a, i, j, val)) {
				a[i][j] = val;
				if (rec(a))
					return true;
				a[i][j] = 0;
			}
		}

		return false;
	}

	static boolean isSafe(int a[][], int x, int y, int val) {
		for (int i = 0; i < 9; i++) {
			if (a[i][y] == val)
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (a[x][i] == val)
				return false;
		}
		int startX = x / 3;
		int startY = y / 3;
		for (int i = startX * 3; i < (startX + 1) * 3; i++) {
			for (int j = startY * 3; j < (startY + 1) * 3; j++) {
				if (a[i][j] == val) {
					return false;
				}
			}
		}
		return true;
	}

	static void printGrid(int a[][]) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(a[i][j] + " ");
			}

		}
	}
}
