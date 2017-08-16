import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.*;

// O(n)

public class Solution {
	public static long sum;
	public static long nr; // of elem
	public static int[] elem;

	public static void main(String args[]) throws Exception {

		Scanner scan = new Scanner(new File("in1.txt"));
		int T = scan.nextInt();
		long profit = 0;
		int i, N, prevMaxIndex;
		int[] indexes;

		while (T-- != 0) {

			N = scan.nextInt();
			elem = new int[N];
			indexes = new int[N]; // will point to the maximum
			i = 0;

			while (i < N) {
				elem[i++] = scan.nextInt();
			}

			prevMaxIndex = N - 1;
			indexes[N - 1] = N - 1;

			for (i = N - 2; i >= 0; i--) {
				if (elem[prevMaxIndex] < elem[i])
					prevMaxIndex = i;
				indexes[i] = prevMaxIndex;
			}

			for (i = 0; i < N; i++)
				if (elem[indexes[i]] - elem[i] > 0)
					profit += elem[indexes[i]] - elem[i];

			System.out.println(profit);
			profit = 0;
		}
	}
}
