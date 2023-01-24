import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a matrix A, you have to return another matrix which is the transpose of A.
 *
 * NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row. The tranpose of a matrix switches the element at (i, j)th index to (j, i)th index, and the element at (j, i)th index to (i, j)th index.
 *
 *
 * Problem Constraints
 *
 * 1 <= A.size() <= 1000
 *
 * 1 <= A[i].size() <= 1000
 *
 * 1 <= A[i][j] <= 1000
 *
 *
 *
 * Input Format
 *
 * First argument is a 2D matrix of integers.
 *
 *
 *
 * Output Format
 *
 * You have to return the Transpose of this 2D matrix.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 * Input 2:
 *
 * A = [[1, 2],[1, 2],[1, 2]]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
 * Output 2:
 *
 * [[1, 1, 1], [2, 2, 2]]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Clearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 *  we will get
 *  [[1, 4, 7],
 *  [2, 5, 8],
 *  [3, 6, 9]].
 */
public class TransposeMatrix {
    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 4, 7));
        array.add(Arrays.asList(2, 5, 8));
        array.add(Arrays.asList(3 ,6, 9));

        List<List<Integer>> result = solve(array);
        for (List<Integer> list: result) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> solve(List<List<Integer>> array) {
//        O(N *M) time | O(N * M) space
        List<List<Integer>> result = new ArrayList<>();
        int row = array.size();
        int col = array.get(0).size();
        for (int i = 0; i < col; i++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                int currentNum = array.get(j).get(i);
                currentRow.add(currentNum);
            }
            result.add(currentRow);
        }
        return result;
    }
}
