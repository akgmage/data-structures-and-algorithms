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
var knightProbability = function (n, k, row, column) {
  // Create a 3D grid to store the probabilities
  let dp = new Array(n)
    .fill(0)
    .map(() => new Array(n).fill(0).map(() => new Array(k + 1).fill(0)));

  // Define the eight possible knight moves
  const moves = [
    [-2, -1],
    [-2, 1],
    [-1, -2],
    [-1, 2],
    [1, -2],
    [1, 2],
    [2, -1],
    [2, 1],
  ];

  // Set the initial probability of the knight being on the starting cell to 1
  dp[row][column][0] = 1.0;

  // Calculate the probabilities for each move
  for (let s = 1; s <= k; s++) {
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        for (const move of moves) {
          const x = i + move[0];
          const y = j + move[1];

          // Check if the move is within the chessboard
          if (x >= 0 && x < n && y >= 0 && y < n) {
            // Accumulate the probability for the current cell
            dp[i][j][s] += dp[x][y][s - 1] / 8.0;
          }
        }
      }
    }
  }

  // Calculate the total probability of the knight remaining on the board
  let probability = 0.0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      probability += dp[i][j][k];
    }
  }

  return probability;
};
