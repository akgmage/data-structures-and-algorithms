/*

	Write a function that takes in an n x m two-dimensional array (that can be square-shaped when n == m)
	and returns a one-dimensional array of all the array's elements in zigzag order.

	Sample Input:= [
		[1,  3,  4, 10],
		[2,  5,  9, 11],
		[6,  8, 12, 15],
		[7, 13, 14, 16],
	]
	Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]

	Explanation:
	The given code snippet implements the ZigzagTraverse algorithm, which traverses a 2D array in a zigzag pattern and
	returns the elements in a 1D array.

	Here's an explanation of the code:

	1. `ZigzagTraverse`: This is the main function that takes a 2D array `array` as input and returns a 1D array containing
	   the elements traversed in zigzag order.

	2. `height` and `width`: These variables store the height and width of the 2D array, respectively.
	   The `height` represents the number of rows (minus 1 as it is 0-based indexing), and the `width` represents the number of columns (minus 1 as it is 0-based indexing).

	3. `row` and `col`: These variables keep track of the current position while traversing the 2D array.

	4. `goingDown`: This boolean variable determines the direction of traversal. When `goingDown` is `true`, the traversal
	   is in the downward direction; otherwise, it is in the upward direction.

	5. `result`: This array stores the elements of the 2D array in zigzag order, which will be returned as the final result.

	6. The main loop: The loop runs until the current position is within bounds (not out of the 2D array).

	7. Append element to result: The code appends the current element at position `(row, col)` to the `result` array.

	8. Traversal logic: The algorithm decides the next position for traversal based on the current position and the `goingDown` flag.
	   If `goingDown` is `true`, it will traverse diagonally downwards (towards the bottom-right or the bottom-left corner, depending on the position). Otherwise, it will traverse diagonally upwards (towards the top-right or the top-left corner, depending on the position).

	9. `isOutOfBounds`: This is a helper function that checks if the current position `(row, col)` is out of bounds of the
	   2D array (i.e., if `row` or `col` is less than 0 or greater than the height or width, respectively).

	10. Return result: After the traversal is complete, the function returns the `result` array, which contains the elements of
	   the 2D array in zigzag order.

	The ZigzagTraverse algorithm efficiently zigzags through the 2D array by changing the direction of traversal whenever it reaches
	the boundary or the corners of the array, allowing it to cover all elements in zigzag order.

	O(n) time | O(n) space - where n is the total number of elements in the two-dimensional array
*/
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> ZigzagTraverse(int[][] array) {
        // Get the height (number of rows) and width (number of columns) of the array.
        int height = array.length;
        int width = array[0].length;

        // Initialize the row and column pointers to start from the top-left element (0,0).
        int row = 0;
        int col = 0;

        // Initialize a flag to track the direction of traversal (goingDown).
        // true means moving down, false means moving up.
        boolean goingDown = true;

        // Initialize a list to store the elements in zigzag order.
        List<Integer> result = new ArrayList<>();

        // Loop until the current position is within the bounds of the array.
        while (!isOutOfBounds(row, col, height, width)) {
            // Append the current element to the result list.
            result.add(array[row][col]);

            // If moving down, check if we reached the bottom row or leftmost column.
            if (goingDown) {
                if (col == 0 || row == height - 1) {
                    // Change direction if we reached the bottom row or leftmost column.
                    goingDown = false;
                    if (row == height - 1) {
                        // Move right if we reached the bottom row.
                        col++;
                    } else {
                        // Move down if we reached the leftmost column.
                        row++;
                    }
                } else {
                    // Move diagonally down-left.
                    row++;
                    col--;
                }
            } else {
                // If moving up, check if we reached the top row or rightmost column.
                if (row == 0 || col == width - 1) {
                    // Change direction if we reached the top row or rightmost column.
                    goingDown = true;
                    if (col == width - 1) {
                        // Move down if we reached the rightmost column.
                        row++;
                    } else {
                        // Move right if we reached the top row.
                        col++;
                    }
                } else {
                    // Move diagonally up-right.
                    row--;
                    col++;
                }
            }
        }

        // Return the list containing the elements in zigzag order.
        return result;
    }

    public static boolean isOutOfBounds(int row, int col, int height, int width) {
        // Check if the current position is outside the bounds of the array.
        return row < 0 || col < 0 || row >= height || col >= width;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 3, 4, 10},
                {2, 5, 9, 11},
                {6, 8, 12, 15},
                {7, 13, 14, 16}
        };

        List<Integer> result = ZigzagTraverse(array);
        System.out.println(result);
    }
}
