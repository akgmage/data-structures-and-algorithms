/**
 * Problem Description
 * Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
 *
 * This matrix A has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 * Return 1 if B is present in A, else return 0.
 *
 * NOTE: Rows are numbered from top to bottom, and columns are from left to right.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 * 1 <= A[i][j], B <= 106
 *
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return 1 if B is present in A else, return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [
 *       [1,   3,  5,  7]
 *       [10, 11, 16, 20]
 *       [23, 30, 34, 50]
 *     ]
 * B = 3
 * Input 2:
 *
 * A = [
 *       [5, 17, 100, 111]
 *       [119, 120, 127, 131]
 *     ]
 * B = 3
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  3 is present in the matrix at A[0][1] position so return 1.
 * Explanation 2:
 *
 *  3 is not present in the matrix so return 0.
 */
package Searching;

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
                };
        int ans = solve(matrix, 50);
        System.out.println(ans);
    }
    public static int solve(int[][] matrix, int target) {
        // O(LogN) time | O(1) space
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col > -1) {
            if (matrix[row][col] == target) return 1;

            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return 0;
    }
}
