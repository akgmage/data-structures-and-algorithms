/**
 * Problem Description
 * Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1, such that the sum of all the elements in the submatrix is maximum.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 103.
 *
 * 1 <= B <= N
 *
 * -102 <= A[i][j] <= 102.
 *
 *
 *
 * Input Format
 * First arguement is an 2D integer matrix A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the maximum sum of submatrix of size B x B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *         [1, 1, 1, 1, 1]
 *         [2, 2, 2, 2, 2]
 *         [3, 8, 6, 7, 3]
 *         [4, 4, 4, 4, 4]
 *         [5, 5, 5, 5, 5]
 *      ]
 *  B = 3
 * Input 2:
 *
 *  A = [
 *         [2, 2]
 *         [2, 2]
 *     ]
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  48
 * Output 2:
 *
 *  8
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *     Maximum sum 3 x 3 matrix is
 *     8 6 7
 *     4 4 4
 *     5 5 5
 *     Sum = 48
 * Explanation 2:
 *
 *  Maximum sum 2 x 2 matrix is
 *   2 2
 *   2 2
 *   Sum = 8
 */
package Linear.Arrays.TwoDimensional;

public class MaximumSumSquareSubmatrix {
    public static void main(String[] args) {
        int[][] array = { 	{1, 1, 1, 1, 1},
                            {2, 2, 2, 2, 2},
                            {3, 8, 6, 7, 3},
                            {4, 4, 4, 4, 4},
                            {5, 5, 5, 5, 5}  };

        int ans = solve(array, 3);
        System.out.println(ans);
    }
    public static int solve(int[][] array, int b) {

        int ans = Integer.MIN_VALUE;

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//
//                if (i + b <= row && j + b <= col) {
//                    int sum = 0;
//                    for (int k = i; k < i + b; k++) {
//                        for (int l = j; l < j + b; l++) {
//                            sum += array[k][l];
//                        }
//                    }
//                    ans = Integer.max(sum, ans);
//                }
//            }
//        }

        // Solve using prefix sum

        int[][] pf = getPrefixSum (array);

        for (int i = 1; i < pf.length; i++) {
            for (int j = 1; j < pf[0].length; j++) {
                int sum;
                if (i - b > -1 && j - b > -1) {
                    sum = pf[i][j] - pf[i-b][j] - pf[i][j-b] + pf[i-b][j-b];
                    ans = Integer.max(sum, ans);
                }
            }
        }
        return ans;
    }
    public static int[][] getPrefixSum(int[][] array) {
        int endRow = array.length, endCol = array[0].length;
        int[][] dp = new int[endRow + 1][endCol + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = array[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        return dp;
    }
}
