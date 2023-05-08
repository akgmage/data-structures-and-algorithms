/**
 * Problem Description
 * Given a matrix of integers A of size N x M and an integer B.
 * In the given matrix every row and column is sorted in non-decreasing order. Find and return the position of B in the matrix in the given form:
 * If A[i][j] = B then return (i * 1009 + j)
 * If B is not present return -1.
 *
 * Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
 * Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
 * Note 3: Expected time complexity is linear
 * Note 4: Use 1-based indexing
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * -100000 <= B <= 100000
 *
 *
 * Input Format
 * The first argument given is the integer matrix A.
 * The second argument given is the integer B.
 *
 *
 * Output Format
 * Return the position of B and if it is not present in A return -1 instead.
 *
 *
 * Example Input
 * Input 1:-
 * A = [[1, 2, 3]
 *      [4, 5, 6]
 *      [7, 8, 9]]
 * B = 2
 * Input 2:-
 * A = [[1, 2]
 *      [3, 3]]
 * B = 3
 *
 *
 * Example Output
 * Output 1:-
 * 1011
 * Output 2:-
 * 2019
 *
 *
 * Example Explanation
 * Expanation 1:-
 * A[1][2] = 2
 * 1 * 1009 + 2 = 1011
 * Explanation 2:-
 * A[2][1] = 3
 * 2 * 1009 + 1 = 2019
 * A[2][2] = 3
 * 2 * 1009 + 2 = 2020
 * The minimum value is 2019
 */

package TwoDimensional;

public class SearchInARowAndColumnWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] array = { {2, 8, 8, 8},
                          {2, 8, 8, 8},
                          {2, 8, 8, 8} };
        int b = 8;
        int ans = solve(array, b);
        System.out.println(ans);
    }
    public static int solve(int[][] array, int b) {
        // O(N+M) time | O(1) space
        int row = 0, col = array[0].length - 1;

        while (row < array.length && col > -1) {
            int num = array[row][col];
            if (num > b) {
                col--;
            } else if (num < b) {
                row++;
            } else {
                if (col == 0 || array[row][col - 1] != array[row][col] ){
                    return ( ( (row + 1) * 1009 ) + col + 1);
                } else col--;
                }
            }
        return -1;
    }
}