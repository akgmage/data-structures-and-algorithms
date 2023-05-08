package Matrices;

import java.util.*;
/**
 * You are given a 2D integer matrix A, return a 1D integer array containing row-wise sums of original matrix.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A.size() <= 103
 *
 * 1 <= A[i].size() <= 103
 *
 * 1 <= A[i][j] <= 103
 *
 *
 *
 * Input Format
 * First argument A is a 2D array of integers.(2D matrix).
 *
 *
 *
 * Output Format
 * Return an array conatining row-wise sums of original matrix.
 *
 * Example Input
 * Input 1:
 *
 * [1,2,3,4]
 * [5,6,7,8]
 * [9,2,3,4]
 *
 *
 * Example Output
 * Output 1:
 *
 * [10,26,18]
 *
 *
 * Example Explanation
 * Explanation 1
 *
 * Row 1 = 1+2+3+4 = 10
 * Row 2 = 5+6+7+8 = 26
 * Row 3 = 9+2+3+4 = 18
 */

public class RowSum {
    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 2, 3, 4));
        array.add(Arrays.asList(5, 6, 7, 8));
        array.add(Arrays.asList(9, 2, 3, 4));

        System.out.println((solve(3, 4, array)));
    }
    public static ArrayList<Integer> solve (int row, int col, List<List<Integer>> array) {
        // O(row*col) time | O(row) space
        ArrayList<Integer> result = new ArrayList<>();

        for (int rowIdx = 0; rowIdx < row; rowIdx++) {
            int currentSum = 0;
            for (int colIdx = 0; colIdx < col; colIdx++) {
                int currentNum = array.get(rowIdx).get(colIdx);
                currentSum += currentNum;
            }
            result.add(currentSum);
        }
        return result;
    }

}
