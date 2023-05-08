/**
 * Problem Description
 * Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
 *
 * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
 *
 * NOTE:
 *
 * Rows are numbered from top to bottom, and columns are numbered from left to right.
 * Sum may be large, so return the answer mod 109 + 7.
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * 1 <= Q <= 100000
 * 1 <= B[i] <= D[i] <= N
 * 1 <= C[i] <= E[i] <= M
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 * The second argument given is the integer array B.
 * The third argument given is the integer array C.
 * The fourth argument given is the integer array D.
 * The fifth argument given is the integer array E.
 * (B[i], C[i]) represents the top left corner of the i'th query.
 * (D[i], E[i]) represents the bottom right corner of the i'th query.
 *
 *
 *
 * Output Format
 * Return an integer array containing the submatrix sum for each query.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [   [1, 2, 3]
 *          [4, 5, 6]
 *          [7, 8, 9]   ]
 *  B = [1, 2]
 *  C = [1, 2]
 *  D = [2, 3]
 *  E = [2, 3]
 * Input 2:
 *
 *  A = [   [5, 17, 100, 11]
 *          [0, 0,  2,   8]    ]
 *  B = [1, 1]
 *  C = [1, 4]
 *  D = [2, 2]
 *  E = [2, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [12, 28]
 * Output 2:
 *
 *  [22, 19]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 *  For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
 * Explanation 2:
 *
 *  For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 *  For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 */

package TwoDimensional;

import java.util.Arrays;

public class SubMatrixSumQueries {
    static long mod = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) {

        int[][] array = {{1, 2, 3},
                         {4, 5, 6},
                         {7, 8, 9}};

        // top left
        int[] b = {1, 2};
        int[] c = {1, 2};

        // bottom right
        int[] d = {2, 3};
        int[] e = {2, 3};

        int[] ans = solve(array, b, c, d, e);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solve(int[][] array, int[] b, int[] c, int[] d, int[] e) {

        int[] ans = new int[b.length];

        // sum = ps[bottom_row][bottom_col] - ps[bottom_row][top_col - 1] - ps[top_row - 1][bottom_col] + ps[top_row - 1][top_col - 1]

        long[][] ps = getPrefixSum(array);

        for (int i = 0; i < b.length; i++) {

            int[] topLeft = {b[i], c[i]};
            int[] bottomRight = {d[i], e[i]};

            int topRow = topLeft[0] - 1;
            int topCol = topLeft[1] - 1;

            int bottomRow = bottomRight[0] - 1;
            int bottomCol = bottomRight[1] - 1;

            long sum = ps[bottomRow][bottomCol];

            if (topCol != 0) {
                sum -= ps[bottomRow][topCol - 1];
            }

            if (topRow != 0) {
                sum -= ps[topRow - 1][bottomCol];
            }

            if (topRow != 0 && topCol != 0) {
                sum += ps[topRow - 1][topCol - 1];
            }

            ans[i] = (int) ((sum + (mod * mod)) % mod);

        }
        return ans;
    }


    public static long[][] getPrefixSum(int[][] array) {
        // O(N*M) time | O(N*M) space
        int endRow = array.length, endCol = array[0].length;

        /**
         * prefix[i][j] = sum from arr[0][0] to arr[i][j]
         */

        /**
         * Find 1. Row sum
         *      2. column sum  to get prefix sum
         */

        // row sum
//      long[][] prefixSum = new long[endRow][endCol];
//        for (int row = 0; row < endRow; row++) {
//            prefixSum[row][0] = array[row][0];
//            for (int col = 1; col < endCol; col++) {
//                prefixSum[row][col] += prefixSum[row][col-1] + array[row][col] ;
//
//                prefixSum[row][col] %= mod;
//            }
//        }
//
//        // col sum
//        for (int row = 1; row < endRow; row++) {
//            for (int col = 0; col < endCol; col++) {
//                prefixSum[row][col] += prefixSum[row - 1][col];
//                prefixSum[row][col] %= mod;
//            }
//        }
//        return prefixSum;

        /**
         * OPTIMIZED WAY
         */
        long[][] dp = new long[endRow + 1][endCol + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = array[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        return dp;
    }
}
