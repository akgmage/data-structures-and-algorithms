/*
On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.

Return the probability that the knight remains on the board after it has stopped moving.

 

Example 1:

Input: n = 3, k = 2, row = 0, column = 0
Output: 0.06250
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
Example 2:

Input: n = 1, k = 0, row = 0, column = 0
Output: 1.00000
*/
public class KnightProbability {
    public double knightProbability(int n, int k, int row, int column) {
        // Create a 3D array for memoization
        double[][][] dp = new double[k + 1][n][n];
        
        // Call the recursive function to compute the probability
        return dfs(n, k, row, column, dp);
    }

    private double dfs(int n, int k, int row, int column, double[][][] dp) {
        // Base case: Check if the knight goes off the board
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0;
        }
        
        // Base case: If no more moves left, knight remains on the board
        if (k == 0) {
            return 1.0;
        }
        
        // If result is already computed, return it
        if (dp[k][row][column] != 0.0) {
            return dp[k][row][column];
        }

        double probability = 0.0;
        int[][] directions = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {2, 1}, {1, 2}};

        // Try all 8 possible knight moves
        for (int i = 0; i < 8; ++i) {
            int newRow = row + directions[i][0];
            int newColumn = column + directions[i][1];
            probability += 0.125 * dfs(n, k - 1, newRow, newColumn, dp);
        }

        // Memoize the result and return it
        dp[k][row][column] = probability;
        return probability;
    }

    public static void main(String[] args) {
        KnightProbability solution = new KnightProbability();

        // Example 1
        int n1 = 3, k1 = 2, row1 = 0, column1 = 0;
        System.out.println("Output 1: " + solution.knightProbability(n1, k1, row1, column1));

        // Example 2
        int n2 = 1, k2 = 0, row2 = 0, column2 = 0;
        System.out.println("Output 2: " + solution.knightProbability(n2, k2, row2, column2));
    }
}
