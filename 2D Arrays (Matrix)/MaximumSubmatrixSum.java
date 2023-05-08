/**
 * Problem Description
 * Given a row-wise and column-wise sorted matrix A of size N * M.
 * Return the maximum non-empty submatrix sum of this matrix.
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 * -109 <= A[i][j] <= 109
 *
 *
 * Input Format
 * The first argument is a 2D integer array A.
 *
 *
 * Output Format
 * Return a single integer that is the maximum non-empty submatrix sum of this matrix.
 *
 *
 * Example Input
 * Input 1:-
 *     -5 -4 -3
 * A = -1  2  3
 *      2  2  4
 * Input 2:-
 *     1 2 3
 * A = 4 5 6
 *     7 8 9
 *
 *
 * Example Output
 * Output 1:-
 * 12
 * Output 2:-
 * 45
 *
 *
 * Example Explanation
 * Expanation 1:-
 * The submatrix with max sum is
 * -1 2 3
 *  2 2 4
 *  Sum is 12.
 * Explanation 2:-
 * The largest submatrix with max sum is
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * The sum is 45.
 */

package Linear.Arrays.TwoDimensional;

public class MaximumSubmatrixSum {

    static long mod = (int) Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        int[][] array = { {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9} };

        long ans = solve(array);

        System.out.println(ans);
    }
    public static long solve(int[][] array) {
        // O(N*M + M) time | O(M) space
        long[] sum = new long[array[0].length];
        long ans = Long.MIN_VALUE;

        for (int end = array.length - 1; end > -1; end--) {
            // Add all elements of current row in sum[]

            for (int j = 0; j < array[end].length; j++) {
                sum[j] += array[end][j];
            }

            ans = Math.max(ans, kadanes(sum));
        }
        return ans;
    }

    public static long kadanes(long[] array) {
        long currentSum = 0, bestSum = Long.MIN_VALUE;

        for (long num : array) {
            currentSum += num;

            bestSum = Math.max(bestSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return bestSum;
    }
}
