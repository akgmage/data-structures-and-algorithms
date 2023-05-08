/**
 * Problem Description
 * Given a matrix of integers A of size N x M in which each row is sorted.
 *
 * Find and return the overall median of matrix A.
 *
 * NOTE: No extra memory is allowed.
 *
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 10^5
 *
 * 1 <= N*M <= 10^6
 *
 * 1 <= A[i] <= 10^9
 *
 * N*M is odd
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer matrix A.
 *
 *
 *
 * Output Format
 * Return the overall median of matrix A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [   [1, 3, 5],
 *         [2, 6, 9],
 *         [3, 6, 9]   ]
 * Input 2:
 *
 * A = [   [5, 17, 100]    ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  5
 * Output 2:
 *
 *  17
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 * Median is 5. So, we return 5.
 * Explanation 2:
 *
 * Median is 17.
 */
package Searching;

public class MatrixMedian {
    public static void main(String[] args) {
        int[][] matrix = { {1, 3, 5},
                           {2, 6, 9},
                           {3, 6, 9}};

        int ans = solve(matrix);
        System.out.println(ans);
    }
    public static int solve(int[][] matrix) {
        // O(Log(Max-Min)*NLogM) time | O(1) space
        // where N and M are numOfRows and numOfCols

        int[] minMax = getMinMax(matrix);
        int min = minMax[0];
        int max = minMax[1];

        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int left = min;
        int right = max;
        int ans = 0;
        int k = numRows * numCols/2;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int[] row : matrix) {
                count += getCountOfSmallerElements(row, mid);
            }
            if (count <= k) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    public static int[] getMinMax(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            min = Math.min(min, row[0]);
            max = Math.max(max, row[numCols - 1]);
        }
        return new int[] {min, max};
    }
    public static int getCountOfSmallerElements(int[] array, int k) {
        // apply binary search
        int count = 0;

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int currentNum = array[mid];

            if (currentNum <= k) {
                if (currentNum == k) {
                    count = mid; // [1, 2, 3, 4 , 4, 5, 6, 6]
                    right = mid - 1;
                } else {
                    count = mid + 1;
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return count;
    }
}
