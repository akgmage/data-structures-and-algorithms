/*
	Write a function that takes in an n x m two-dimensional array (that can be square-shaped when n == m) and
	returns a one-dimensional array of all the array's elements in spiral order.

	Spiral order starts at the top left corner of the two-dimensional array, goes to the right, and proceeds
	in a spiral pattern all the way until every element has been visited.

	Explanation:

	The SpiralTraverse function takes a 2D integer array array and returns a 1D integer slice that contains the
	elements of array traversed in a spiral order, starting from the top-left corner and moving clockwise.

	The function first initializes an empty slice result to hold the elements of the spiral traversal.
	If the input array is empty, the function immediately returns the empty result.

	Next, the function initializes variables startRow, endRow, startCol, and endCol to keep track of the
	boundaries of the matrix. These variables will be updated as the function traverses the matrix.

	The function then enters a loop that traverses the matrix in a spiral order. The loop continues
	as long as startRow <= endRow and startCol <= endCol, which means that there are still elements
	in the matrix to be traversed.

	The first step in the loop is to traverse the top row of the matrix from left to right, and append
	each element to the result slice. The next step is to traverse the rightmost column of the matrix from top to bottom,
	and append each element to the result slice. If there is more than one row in the matrix, the function then traverses
	the bottom row of the matrix from right to left, and appends each element to the result slice. If there is only one row left,
	the loop is broken to avoid duplicating the elements. Finally, if there is more than one column in the matrix,
	the function traverses the left

	O(n) time | O(n) space - where n is the total number of elements in the array
*/
import java.util.*;
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
