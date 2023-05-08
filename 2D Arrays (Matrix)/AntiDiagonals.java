package Matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
 *
 *
 * Problem Constraints
 * 1<= N <= 1000
 * 1<= A[i][j] <= 1e9
 *
 *
 * Input Format
 * Only argument is a 2D array A of size N * N.
 *
 *
 * Output Format
 * Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
 * The vacant spaces in the grid should be assigned to 0.
 *
 *
 * Example Input
 * Input 1:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * Input 2:
 *
 * 1 2
 * 3 4
 *
 *
 * Example Output
 * Output 1:
 * 1 0 0
 * 2 4 0
 * 3 5 7
 * 6 8 0
 * 9 0 0
 * Output 2:
 *
 * 1 0
 * 2 3
 * 4 0
 *
 *
 * Example Explanation
 * For input 1:
 * The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
 * The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
 * The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
 * The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
 * The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].
 * For input 2:
 *
 * The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
 * The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
 * The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].
 */
public class AntiDiagonals {
    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 2, 3));
        array.add(Arrays.asList(4, 5, 6));
        array.add(Arrays.asList(7 ,8, 9));

        List<List<Integer>> result = solve(array);
        for (List<Integer> list: result) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> solve(List<List<Integer>> array) {
        // O(row * col) time | (row * col) space
        List<List<Integer>> result = new ArrayList<>();
        int row = array.size();

        // 0th row
        for (int col = 0; col < array.get(0).size(); col++) {
            printDiagonal(0, col, array, result); //row is fixed
        }

        // last col
        int col = array.get(0).size() - 1;
        for (int i = 1; i < row; i++) {
            printDiagonal(i, col, array, result); //col is fixed
        }
        return result;
    }
    public static void printDiagonal(int row, int col, List<List<Integer>> array, List<List<Integer>> result) {
        List<Integer> ans = new ArrayList<>();
        for (var num : array) {
            ans.add(0);
        }
        int i = 0;
        while (row < array.size() && col > -1) {
            int currentNum = array.get(row++).get(col--);
            ans.set(i++, currentNum);
        }
        result.add(ans);
    }
}
