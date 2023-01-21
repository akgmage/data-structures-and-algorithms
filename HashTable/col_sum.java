import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.
 *
 *
 *
 * Problem Constraints
 * 1 <= A.size() <= 103
 *
 * 1 <= A[i].size() <= 103
 *
 * 1 <= A[i][j] <= 103
 *
 *
 *
 * Input Format
 * First argument is a 2D array of integers.(2D matrix).
 *
 *
 *
 * Output Format
 * Return an array conatining column-wise sums of original matrix.
 *
 *
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
 * {15,10,13,16}
 *
 *
 * Example Explanation
 * Explanation 1
 *
 * Column 1 = 1+5+9 = 15
 * Column 2 = 2+6+2 = 10
 * Column 3 = 3+7+3 = 13
 * Column 4 = 4+8+4 = 16
 */
public class ColSum {
    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 2, 3, 4));
        array.add(Arrays.asList(5, 6, 7, 8));
        array.add(Arrays.asList(9, 2, 3, 4));

        System.out.println((solve(3, 4, array)));
    }
    public static ArrayList<Integer> solve (int row, int col, List<List<Integer>> array) {
        // O(row*col) time | O(col) space
        ArrayList<Integer> result = new ArrayList<>();

        for (int colIdx = 0; colIdx < col; colIdx++) {
            int currentSum = 0;
            for (int rowIdx = 0; rowIdx < row; rowIdx++) {
                int currentNum = array.get(rowIdx).get(colIdx);
                currentSum += currentNum;
            }
            result.add(currentSum);
        }
        return result;
    }

}
