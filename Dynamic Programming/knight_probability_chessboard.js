/*Time Complexity: The time complexity of the code is O(n^2 * k) because, in the calculateProbability function, we have a loop that iterates over each cell on the chessboard (n x n) and for each cell, we make recursive calls for k moves. So, the total number of iterations would be proportional to n^2 * k.
Space Complexity: The space complexity of the code is O(n^2 * k) because we use a 3D array dp to store the calculated probabilities for each cell and the number of moves. The size of this array is n x n x k, which requires space proportional to n^2 * k.
*/

var knightProbability = function(n, k, row, column) {
    const moves = [[-2, -1], [-2, 1], [-1, -2], [-1, 2], [1, -2], [1, 2], [2, -1], [2, 1]];
    const dp = Array.from({ length: n }, () => Array.from({ length: n }, () => Array(k + 1).fill(0.0)));
    // 3D array to store calculated probabilities
    
    const calculateProbability = (n, k, row, column) => {
        // Base cases
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0; // Knight is out of the chessboard
        }
        
        if (k === 0) {
            return 1.0; // Knight has made all the moves, so it remains on the board
        }
        
        if (dp[row][column][k] > 0.0) {
            return dp[row][column][k]; // Return already calculated probability
        }
        
        let probability = 0.0;
        
        for (const knightMove of moves) {
            const nextRow = row + knightMove[0];
            const nextColumn = column + knightMove[1];
            
            probability += calculateProbability(n, k - 1, nextRow, nextColumn) / 8.0; // Recursively calculate probability for next moves
        }
        
        dp[row][column][k] = probability; // Store the calculated probability
        
        return probability;
    };
    
    return calculateProbability(n, k, row, column);
};
