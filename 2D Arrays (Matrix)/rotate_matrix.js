// Rotate clockwise and anti-clockwise
/*
    Here, we first get the number of rows and columns in the matrix. Then, for rotating the matrix clockwise, 
    we iterate over the columns in reverse order and create a new row in the rotated matrix by iterating 
    over each row in the original matrix and adding the corresponding element to the new row. 
    Finally, we add the new row to the rotated matrix.

    For rotating the matrix anti-clockwise, we again iterate over the columns but this time in the 
    forward order and create a new row in the rotated matrix by iterating over each row in the original 
    matrix in reverse order and adding the corresponding element to the new row. Finally, we add the 
    new row to the rotated matrix.
*/
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

function rotateAntiClockwise(matrix) {
  // Get the number of rows and columns in the matrix
  const rows = matrix.length;
  const cols = matrix[0].length;

  // Create a new matrix to store the rotated matrix
  const rotated = [];

  // Iterate over the columns in reverse order and create a new row in the rotated matrix
  for (let j = 0; j < cols; j++) {
    const newRow = [];
    // Iterate over each row in the matrix in reverse order and add the corresponding element to the new row
    for (let i = rows - 1; i >= 0; i--) {
      newRow.push(matrix[i][j]);
    }
    // Add the new row to the rotated matrix
    rotated.push(newRow);
  }

  // Return the rotated matrix
  return rotated;
}
