/**
 * Problem :- N-Queens
  https://leetcode.com/problems/n-queens/description/
 
 
 Approach:-
 The approach uses backtracking to generate all possible configurations of queens on the board and checks the validity of each configuration.
  It maintains a boolean board to represent the placement of queens, where `true` indicates the presence of a queen in a particular cell. 
  The algorithm starts by placing a queen in the first row and proceeds recursively to the next row, checking all possible column positions for the queen. 
  If a valid position is found, the algorithm moves to the next row and repeats the process. If all N queens are placed on the board, 
  a valid solution is found and added to the list of solutions.


To check the validity of a queen's position, the algorithm verifies three conditions:
1. Vertical Check: It checks the columns of the previous rows to ensure that there are no queens in the same column.
2. Left Diagonal Check: It checks the diagonal elements on the left side of the current position to ensure that there are no queens present.
3. Right Diagonal Check: It checks the diagonal elements on the right side of the current position to ensure that there are no queens present.

The algorithm continues this process, backtracking whenever it encounters an invalid position or explores all possibilities. Once all valid configurations are found, they are converted into a list of strings representing the board configurations, and the list of solutions is returned.




Time Complexity: O(N!)
 In the worst case, the backtracking algorithm explores all possible configurations,. However, with pruning techniques, the actual runtime is significantly lower.

Space Complexity:  O(N^2)
 because the boolean board of size NxN is used to represent the placement of queens, and the list of solutions also occupies additional space.

 */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        
        // If the board size is 2 or 3, no solution is possible, so return an empty list
        if (n == 2 || n == 3) {
            return list;
        }
        
        // If the board size is 1, there is only one solution with a single queen in the only cell
        if (n == 1) {
            String ans = "Q";
            ArrayList<String> a = new ArrayList<>();
            a.add(ans);
            list.add(a);
            return list;
        }
        
        boolean arr[][] = new boolean[n][n]; // Create a boolean board to represent the placement of queens
        queens(arr, 0, list); // Solve the N-queens problem recursively
        return list; // Return the list of solutions
    }
    
    // Recursive function to solve the N-queens problem
    static void queens(boolean board[][], int row, List<List<String>> list) {
        if (row == board.length) {
            ArrayList<String> arr = new ArrayList<>();
            
            // Convert the boolean board to a list of strings representing the board configuration
            for (int j = 0; j < board.length; j++) {
                String ans = "";
                for (int i = 0; i < board[j].length; i++) {
                    if (board[j][i] == false) {
                        ans += ".";
                    } else {
                        ans += "Q";
                    }
                }
                arr.add(ans);
            }
            list.add(arr); // Add the board configuration to the list of solutions
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true; // Place a queen in the current position
                queens(board, row + 1, list); // Recursively solve the problem for the next row
                board[row][col] = false; // Backtrack and remove the queen from the current position
            }
        }
    }
    
    // Function to check if it is safe to place a queen in a given position
    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check the vertical column for any previously placed queens
        for (int i = 1; i <= row; i++) {
            if (board[row - i][col]) {
                return false;
            }
        }
        
        // Check the left diagonal for any previously placed queens
        int max = Math.min(row, col);
        for (int i = 1; i <= max; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        
        // Check the right diagonal for any previously placed queens
        int maxtimes = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxtimes; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        
        return true; // It is safe to place a queen in the given position
    }
}
