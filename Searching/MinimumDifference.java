/**
 * Problem Description
 * You are given a 2-D matrix C of size A × B.
 * You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly built array is minimized.
 *
 * The cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.
 *
 * So if the newly built array is X, the element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.
 *
 * Determine the minimum cost of the newly built array.
 *
 *
 *
 * Problem Constraints
 * 2 <= A <= 1000
 * 2 <= B <= 1000
 * 1 <= C[i][j] <= 106
 *
 *
 *
 * Input Format
 * The first argument is an integer A denoting number of rows in the 2-D array.
 * The second argument is an integer B denoting number of columns in the 2-D array.
 * The third argument is a 2-D array C of size A x B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum cost of the newly build array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 *  B = 2
 *  C = [ [8, 4]
 *       [6, 8] ]
 * Input 2:
 *
 *  A = 3
 *  B = 2
 *  C = [ [7, 3]
 *        [2, 1]
 *        [4, 9] ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
 * Explanation 2:
 *
 *  Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2).
 */
package Searching;

import java.util.Arrays;

public class MinimumDifference {
    public static void main(String[] args) {
        int[][] matrix = { {7, 3}, {2, 1}, {4, 9} };
        int row = 3;
        int col = 2;

        int ans = solve(matrix, row, col);
        System.out.println(ans);
    }
    public static int solve(int[][] matrix, int rows, int cols) {

        /**
         *   -----  BRUTE FORCE ------
         * int ans = Integer.MAX_VALUE;
         *
         *         for (int i = 0; i < rows-1; i++) {
         *                for (int k = 0; k < cols; k++) {
         *                    for (int p = 0; p < cols; p++){
         *                        int diff = Math.abs(matrix[i][p] - matrix[i+1][k]);
         *                        ans = Math.min(ans, diff);
         *                    }
         *                }
         *            }
         *         return ans;
         */

        // O(row*col*Log(col)) time | O(1) space
        int ans = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            Arrays.sort(row);
        }

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols; j++) {
                ans = Math.min(getMin(matrix[i+1], matrix[i][j]), ans);
            }
        }
        return ans;
    }
    public static int getMin(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - left)/2;
            int potentialMatch = arr[middle];

            if (potentialMatch == target) {
                return 0;
            } else if (target > potentialMatch) {
                ans = Math.min(Math.abs(potentialMatch - target), ans);
                left = middle + 1;
            } else {
                ans = Math.min(Math.abs(potentialMatch - target), ans);
                right = middle - 1;
            }
        }
        return ans;
    }
}
