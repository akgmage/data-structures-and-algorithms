/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
package Hashing;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
//        boolean res = solve(board, 9);
//        System.out.println(res);

        boolean res = cleverSolution(board, 9);
        System.out.println(res);
    }

    public static boolean cleverSolution(char[][] board, int n) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char currentChar = board[i][j];
                if (currentChar != '.') {
                    if (!seen.add(currentChar + " found in row " + i) ||
                            !seen.add(currentChar + " found in col " + j) ||
                            !seen.add(currentChar + " found in sub box " + i / 3 + "-" + j / 3))
                        return false;
                }
            }
        }
        return true;
    }





    public static boolean solve(char[][] board, int n) {
        // O(N * N) time | O(1) space
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                //If current row or current column or
                // current 3x3 box is not valid, return false.
                if (!isValid(board, i, j)) return false;
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int row, int col) {
        return notInRow(board, row) &&
               notInCol(board, col) &&
               notInBox(board, row - row % 3, col - col % 3);
    }
    public static boolean notInRow(char[][] board, int row) {

        //Set to store characters seen so far.
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {

            //If already seen before, return false,
            if(seen.contains(board[row][i])) return false;

            // If is not an empty cell, insert value
            // at the current cell in the set
            if (board[row][i] != '.')
                seen.add(board[row][i]);
        }
        return true;
    }
    public static boolean notInCol(char[][] board, int col) {

        //Set to store characters seen so far.
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {

            //If already seen before, return false,
            if(seen.contains(board[i][col])) return false;

            // If is not an empty cell, insert value
            // at the current cell in the set
            if (board[i][col] != '.')
                seen.add(board[i][col]);
        }
        return true;
    }
    public static boolean notInBox(char[][] board, int startRow, int startCol) {
        HashSet<Character> seen = new HashSet<>();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char currentChar = board[row + startRow][col + startCol];

                // If already seen, return false
                if (seen.contains(currentChar)) return false;

                // If it is not an empty cell, add
                if (currentChar != '.') seen.add(currentChar);
            }
        }
        return true;
    }

}
