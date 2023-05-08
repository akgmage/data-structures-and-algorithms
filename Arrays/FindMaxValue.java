// Given N array elements. find the max value of (A[i] - A[j]) + (i - j )

package Linear.Arrays.OneDimensional;

public class FindMaxValue {
    public static void main(String[] args) {
        int[] A = { 8, 2, 7, 4, -2 };

        int ans = solve(A);
        System.out.println(ans);
    }

    public static int solve(int[] A) {
        /**
         * 1. (A[i] - A[j]) + (i - j ) == A[i] + i - (A[j] - j)
         *
         *
         * For every element compute A[i] + i, and maxElement - minElement
         */

        // O(N) time | O(1) space if the input is mutable
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] + i;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int val : A) {
            max = Integer.max(val, max);
            min = Integer.min(val, min);
        }
        return max - min;

    }
}