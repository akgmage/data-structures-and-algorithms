function solveNQueens(n) {
  const board = new Array(n).fill().map(() => new Array(n).fill('.')); // Create an empty NxN chessboard
  
  const solutions = [];
  
  function isSafe(row, col) {
    // Check if no other queens are in the same column
    for (let i = 0; i < row; i++) {
      if (board[i][col] === 'Q') {
        return false;
      }
    }
    
    // Check upper-left diagonal
    for (let i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] === 'Q') {
        return false;
      }
    }
    
    // Check upper-right diagonal
    for (let i = row, j = col; i >= 0 && j < n; i--, j++) {
      if (board[i][j] === 'Q') {
        return false;
      }
    }
    
    return true;
  }
  
  function solve(row) {
    if (row === n) {
      // Found a valid solution, push a copy of the board to the solutions array
      solutions.push(board.map(row => row.join('')));
      return;
    }
    
    for (let col = 0; col < n; col++) {
      if (isSafe(row, col)) {
        board[row][col] = 'Q'; // Place a queen
        solve(row + 1); // Recursively move to the next row
        board[row][col] = '.'; // Backtrack by removing the queen
      }
    }
  }
  
  solve(0); // Start solving from the first row
  
  return solutions;
}

// Example usage:
const n = 4; // Change this to the desired board size
const solutions = solveNQueens(n);

console.log(`Solutions for ${n}-Queens:`);
for (const solution of solutions) {
  console.log(solution);
}
