package Linear.Arrays.TwoDimensional;

import java.util.Arrays;

public class TwoDimensionalArrayPrefixSum {
    public static void main(String[] args) {
        int[][] array = { {2, 4, 5},
                          {1, 3, 6},
                          {1, 5, 5} };

        int[][] prefixSum = solve(array);
        for (int[] arr : prefixSum) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] solve(int[][] array) {
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
//        int[][] prefixSum = new int[endRow][endCol];
//        for (int row = 0; row < endRow; row++) {
//            prefixSum[row][0] = array[row][0];
//            for (int col = 1; col < endCol; col++) {
//                    prefixSum[row][col] += prefixSum[row][col-1] + array[row][col];
//            }
//        }
//
//        // col sum
//        for (int row = 1; row < endRow; row++) {
//            for (int col = 0; col < endCol; col++) {
//                prefixSum[row][col] += prefixSum[row - 1][col];
//            }
//        }
//
//        return prefixSum;

        /**
         * OPTIMIZED WAY
         */
        int[][] dp = new int[endRow + 1][endCol + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = array[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        return dp;
    }
}
