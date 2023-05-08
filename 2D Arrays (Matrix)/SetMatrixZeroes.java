package Matrices; /**
 * You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.
 *
 * Problem Constraints
 * 1 <= A.size() <= 103
 *
 * 1 <= A[i].size() <= 103
 *
 * 0 <= A[i][j] <= 103
 *
 *
 *
 * Input Format
 * First argument is a vector of vector of integers.(2D matrix).
 *
 *
 *
 * Output Format
 * Return a vector of vector after doing required operations.
 *
 *
 * Example Input
 * Input 1:
 *
 * [1,2,3,4]
 * [5,6,7,0]
 * [9,2,0,4]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1,2,0,0]
 * [0,0,0,0]
 * [0,0,0,0]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
 */


import java.util.*;
public class SetMatrixZeroes {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2, 3, 4));
        matrix.add(Arrays.asList(5, 6, 7, 0));
        matrix.add(Arrays.asList(9, 2, 0, 4));

        solve(matrix);
        System.out.println(matrix);
    }
    public static void solve(List<List<Integer>> matrix) {
        // O(N*M) time | O(1) space
        int col0 = 1, rows = matrix.size(), cols = matrix.get(0).size();

        for (int i = 0; i < rows; i++) {
            if (matrix.get(i).get(0) == 0) col0 = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrix.get(i).set(0, 0);
                    matrix.get(0).set(j, 0);
                }
            }
        }
        //traverse reverse order
        for (int i = rows - 1; i > -1; i--) {
            for (int j = cols - 1; j > 0; j--) {
                if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                    matrix.get(i).set(j, 0);
                }
            }
            if (col0 == 0) matrix.get(rows).set(0, 0);
        }

    }
}
