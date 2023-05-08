/**
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 1000
 *
 *
 *
 * Input Format
 * First and only argument is integer A
 *
 *
 * Output Format
 * Return a 2-D matrix which consists of the elements added in spiral order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * 1
 * Input 2:
 *
 * 2
 * Input 3:
 *
 * 5
 *
 *
 * Example Output
 * Output 1:
 *
 * [ [1] ]
 * Output 2:
 *
 * [ [1, 2], [4, 3] ]
 * Output 2:
 *
 * [ [1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Only 1 is to be arranged.
 * Explanation 2:
 *
 * 1 --> 2
 *       |
 *       |
 * 4<--- 3
 * Explanation 3:
 */

package Matrices;

import java.util.Arrays;

public class SpiralOrder2 {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        final long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int size = 1;
        int[][] matrix = solve(size);
        System.out.println(Arrays.deepToString(matrix));


        final long endTime = System.currentTimeMillis();
        final long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        final long actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Runtime " + (endTime - startTime) + " ms");
        System.out.println("Space " + actualMemUsed + " B");
    }

    public static int[][] solve(int size) {
        // O(N^2) | time O(N^2) space where N is size.
        int[][] matrix = new int[size][size];

        int startRow = 0,
                startCol = 0,
                endRow = size - 1,
                endCol = size - 1;
        int currentNum =1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int col = startCol; col <= endCol; col++)
                    matrix[startRow][col] = currentNum++;

            for (int row = startRow + 1; row <= endRow; row++)
                matrix[row][endCol] = currentNum++;

            for (int col = endCol - 1; col >= startCol; col--)
                matrix[endRow][col] = currentNum++;

            for (int row = endRow - 1; row > startRow; row--)
                matrix[row][startCol] = currentNum++;

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return matrix;
    }

}
