/*
 * 
 */
package maths;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Maths.
 */
public class Maths {

	/** The y. */
	static int gcd, x, y;

	/**
	 * Binary exponential.
	 *
	 * @param x the x
	 * @param n the n
	 * @return the long
	 */
	static long binaryExponential(int x, int n) {
		long result = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				result = result * x;
			}
			x = x * x;
			n = n / 2;
		}
		return result;
	}

	/**
	 * Modular exponential. Complexity O(log(n))
	 *
	 * @param x the x
	 * @param n the n
	 * @param M the m
	 * @return the int
	 */
	static int modularExponential(int x, int n, int M) {
		int result = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				result = (result * x) % M;
			}
			x = (x * x) % M;
			n = n / 2;
		}
		return result;
	}

	/*
	 * static int gcd(int a, int b) { if (b == 0) { return a; } else { return gcd(b,
	 * a % b); } }
	 */

	/**
	 * GCD function Extended euclid. If a and b are coprime ({a,b,c,d} are coprime
	 * if gcd of all numbers is 1.) then x represents multiplicative inverse of a
	 * under modulo b and y represents multiplicative inverse of b under modulo a.
	 * 
	 * Multiplicative inverse of p will be q such that p*q=1;
	 * 
	 * Modular multiplicativeInverse of p under modulo M will be q such that (p*q)%M
	 * = 1;
	 * 
	 * Complexity O(log(max(A, B))).
	 * 
	 * @param a the a
	 * @param b the b
	 */
	static void extendedEuclid(int a, int b) {
		if (b == 0) {
			gcd = a;
			x = 1;
			y = 0;
		} else {
			extendedEuclid(b, a % b);
			int temp = x;
			x = y;
			y = temp - (a / b) * y;
		}
	}

	/**
	 * Modular inverse. Complexity O(M)
	 *
	 * @param a the a
	 * @param M the m
	 * @return the int
	 */
	static int modularInverse(int a, int M) {

		a = a % M;
		for (int b = 1; b < M; b++) {
			if ((a * b) % M == 1) {
				return b;
			}
		}
		return 0;
	}

	/**
	 * Modular inverse coprime. Complexity O(log(max(A,M)))
	 *
	 * @param a the a
	 * @param M the m
	 * @return the int
	 */
	static int modularInverseCoprime(int a, int M) {
		extendedEuclid(a, M);
		return (x % M + M) % M;
	}

	/**
	 * Modular inverse prime. Complexity O(log(M))
	 *
	 * @param a the a
	 * @param M the m
	 * @return the int
	 */
	static int modularInversePrime(int a, int M) {
		return modularExponential(a, M - 2, M);
	}

	/**
	 * No Of Divisors. Complexity O(root(n))
	 *
	 * @param n the n
	 * @return the int
	 */
	static int noOfDivisors(int n) {
		int count = 0;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				count += 2;
				if (i * i == n) {
					count--;
				}
			}
		}
		return count;
	}

	/**
	 * Prime factors.
	 *
	 * @param n the n
	 * @return the list
	 */
	static List<Integer> primeFactors(int n) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				ans.add(i);
				n = n / i;
			}
		}
		if (n != 1) {
			ans.add(n);
		}

		return ans;
	}

	/**
	 * No of divisors.
	 *
	 * @return the int[]
	 */
	static int[] noOfDivisors() {
		int[] divisors = new int[1000_001];
		for (int i = 1; i < 1000_001; i++) {
			for (int j = i; j < 1000_001; j = j + i) {
				divisors[j]++;
			}
		}
		return divisors;
	}

	/**
	 * Check prime.
	 *
	 * @param n the n
	 * @return true, if successful
	 */
	static boolean checkPrime(int n) {
		int count = noOfDivisors(n);
		if (count > 2) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if is prime.
	 *
	 * @param n the n
	 * @return true, if is prime
	 */
	boolean isPrime(int n) {
		for (int i = 2; i * i <= n; ++i) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Sieve. Complexity O(NloglogN)
	 *
	 * @return the int[]
	 */
	static int[] sieve() {
		int n = Integer.MAX_VALUE - 1;
		int[] prime = new int[n];
		Arrays.fill(prime, 1);
		prime[0] = 0;
		prime[1] = 0;
		for (int i = 2; i * i <= n; i++) {
			if (prime[i] == 1) {
				for (int j = i * i; j <= n; j = j + i) {
					prime[i] = 0;
				}
			}
		}
		return prime;
	}

	/**
	 * Sieve 2. Prime number of least value at any n. e.g. for n = 6 , 2 is least
	 * prime factor.
	 *
	 * @param n the n
	 * @return the int[]
	 */
	static int[] sieve2(int n) {
		int[] minPrime = new int[n + 1];
		Arrays.fill(minPrime, -1);
		for (int i = 2; i * i <= n; i++) {
			if (minPrime[i] == -1) {
				for (int j = i * i; j < n; j += i) {
					if (minPrime[j] == -1) {
						minPrime[j] = i;
					}
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			if (minPrime[i] == -1) {
				minPrime[i] = i;
			}
		}
		return minPrime;
	}

	/**
	 * Segmented sieve. Read on this.
	 *
	 * @param l the l
	 * @param r the r
	 * @return the int[]
	 */
	static int[] segmentedSieve(int l, int r) {
		boolean[] isPrime = new boolean[r - l + 1];
		int[] prime = new int[r - l + 1];
		Arrays.fill(isPrime, true); // filled by true
		for (int i = 2; i * i <= r; ++i) {
			for (int j = Math.max(i * i, (l + (i - 1)) / i * i); j <= r; j += i) {
				isPrime[j - l] = false;
			}
		}
		for (int i = Math.max(l, 2); i <= r; ++i) {
			if (isPrime[i - l]) {
				prime[i - l] = 1;
			}
		}
		return prime;
	}

	/**
	 * Prime factors optimal. Complexity O(log(n)) Only for smaller numbers.
	 * otherwise use root(n).
	 * 
	 * @param n the n
	 * @return the list
	 */
	static List<Integer> primeFactorsOptimal(int n) {
		int[] minPrime = sieve2(n);
		List<Integer> ans = new ArrayList<>();
		while (n != 1) {
			ans.add(minPrime[n]);
			n = n / minPrime[n];
		}
		return ans;
	}

	/**
	 * No of distinct divisors.
	 *
	 * @param n the n
	 * @return the long
	 */
	static long noOfDistinctDivisors(int n) {
		List<Integer> primeFactors = primeFactorsOptimal(n);
		// List<Integer> primeFactors = primeFactors(n);
		long ans = 1;
		for (Integer i : primeFactors) {
			ans *= (i + 1);
		}
		return ans;
	}

	/**
	 * Pascals triangle. dp[i][j] =  C(i+j,i) 
	 *
	 * @param n the n
	 * @return the int[][]
	 */
	static int[][] pascalsTriangle(int n) {
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
			dp[0][i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			}
		}
		return dp;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		List<Integer> factors = primeFactors(n);
		Collections.sort(factors);
		System.out.println(factors.toString());

	}

	/**
	 * The Class FastScanner.
	 */
	static class FastScanner {

		/** The m is. */
		private InputStream mIs;

		/** The buf. */
		private byte[] buf = new byte[1024];

		/** The cur char. */
		private int curChar;

		/** The num chars. */
		private int numChars;

		/**
		 * Instantiates a new fast scanner.
		 */
		public FastScanner() {
			this(System.in);
		}

		/**
		 * Instantiates a new fast scanner.
		 *
		 * @param is the is
		 */
		public FastScanner(InputStream is) {
			mIs = is;
		}

		/**
		 * Read.
		 *
		 * @return the int
		 */
		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = mIs.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		/**
		 * Next line.
		 *
		 * @return the string
		 */
		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		/**
		 * Next string.
		 *
		 * @return the string
		 */
		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		/**
		 * Next long.
		 *
		 * @return the long
		 */
		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		/**
		 * Next int.
		 *
		 * @return the int
		 */
		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		/**
		 * Checks if is space char.
		 *
		 * @param c the c
		 * @return true, if is space char
		 */
		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		/**
		 * Checks if is end of line.
		 *
		 * @param c the c
		 * @return true, if is end of line
		 */
		public boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;

		}

	}
}
