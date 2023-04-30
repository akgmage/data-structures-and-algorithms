import java.util.*;

/**
 *

 Write a function that takes in an n x m two-dimensional array (that can be square-shaped when n == m) and returns a one-dimensional array of all the array's elements in spiral order.

 Spiral order starts at the top left corner of the two-dimensional array, goes to the right, and proceeds in a spiral pattern all the way until every element has been visited.
 Sample Input

 array = [
 [1,   2,  3, 4],
 [12, 13, 14, 5],
 [11, 16, 15, 6],
 [10,  9,  8, 7],
 ]

 Sample Output

 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]


 */
public class SpiralTraverse {

    public static void main(String[] args) {
        int[][] array = { {1, 2, 3},
                {12, 13, 4},
                {11, 14, 5},
                {10, 15, 6},
                {9, 8, 7} };
        System.out.println(spiralFillUsingLoop(array));

//        spiralFillUsingRecursion(array, 0, array.length - 1, 0, array[0].length - 1, result);
    }
    public static List<Integer> spiralFillUsingLoop(int[][] array) {
        // O(n) time | O(n) space;
        if(array.length == 0) return new ArrayList<>();

        var result = new ArrayList<Integer>();
        var startRow = 0;
        var endRow = array.length - 1;
        var startCol = 0;
        var endCol = array[0].length - 1;

        while(startRow <= endRow && startCol <= endCol) {

            for(int col = startCol; col <= endCol; col++)
                result.add(array[startRow][col]);

            for(int row = startRow + 1; row <= endRow; row++)
                result.add(array[row][endCol]);

            for(int col = endCol - 1; col >= startCol; col--) {
                /**
                 * Handle the edge case when there's a single row
                 * in the middle of the matrix, In this case. we don't
                 * want to double-count the values in this row, which
                 * we've already counted in the first for loop above.
                 * Test case for this edge case :
                 *                              [
                 *                                 [1, 2, 3, 4],
                 *                                 [10, 11, 12, 5],
                 *                                 [9, 8, 7, 6]
                 *                               ]
                 *
                 *
                 */
                if(startRow == endRow) break;
                result.add(array[endRow][col]);
            }

            for(int row = endRow - 1; row > startRow; row--) {
                /**
                 * Handle the edge case when there's a single column
                 * in the middle of the matrix, In this case. we don't
                 * want to double-count the values in this row, which
                 * we've already counted in the first for loop above.
                 * Test case for this edge case :
                 *                              [
                 *                                 [1, 2, 3],
                 *                                 [12, 13, 4],
                 *                                 [11, 14, 5],
                 *                                 [10, 15, 6],
                 *                               ]
                 *
                 */
                if(startCol == endCol) break;
                result.add(array[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }
    public static void spiralFillUsingRecursion(
            int[][] array,
            int startRow,
            int endRow,
            int startCol,
            int endCol,
            ArrayList<Integer> result) {
        // O(n) time | O(n) space;
        if(startRow > endRow || startCol > endCol) return;

        for(int col = startCol; col <= endCol; col++)
            result.add(array[startRow][col]);
        for(int row = startRow + 1; row <= endRow; row++)
            result.add(array[row][endCol]);
        for(int col = endCol - 1; col >= startCol; col--) {
            if(startRow == endRow) break;
            result.add(array[endRow][col]);
        }
        for(int row = endRow - 1; row > startRow; row--) {
            if(startCol == endCol) break;
            result.add(array[row][startCol]);
        }
        spiralFillUsingRecursion(array, startRow + 1, endRow -1, startCol + 1, endCol - 1, result);
    }
}
