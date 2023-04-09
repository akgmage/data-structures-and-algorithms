function rotateClockwise(matrix) {
  // Get the number of rows and columns in the matrix
  const rows = matrix.length;
  const cols = matrix[0].length;

  // Create a new matrix to store the rotated matrix
  const rotated = [];

  // Iterate over the columns in reverse order and create a new row in the rotated matrix
  for (let j = cols - 1; j >= 0; j--) {
    const newRow = [];
    // Iterate over each row in the matrix and add the corresponding element to the new row
    for (let i = 0; i < rows; i++) {
      newRow.push(matrix[i][j]);
    }
    // Add the new row to the rotated matrix
    rotated.push(newRow);
  }

  // Return the rotated matrix
  return rotated;
}
