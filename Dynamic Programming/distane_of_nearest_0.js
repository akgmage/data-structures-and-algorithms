// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell in Java


// Solution
// // This solution uses a breadth-first search (BFS) approach to calculate the distance of the nearest 0 for each cell in the matrix. 
// // The idea is to initialize a distances matrix with all values set to the maximum integer value, except for the cells that contain 0s,
// // which are set to 0 and added to a queue. We then perform a BFS on the queue, updating the distances of neighboring cells as we go.
// // Finally, we return the updated distances matrix.


// Time Complexity:

// We traverse the entire matrix in the worst case to fill the distances matrix with initial values, which takes O(m * n) time.
// We use Breadth-First Search (BFS) to update the distances matrix, which in the worst case can visit each cell once, taking O(m * n) time.
// Therefore, the total time complexity of this solution is O(m * n).

// Space Complexity:

// We store the distances matrix, which requires O(m * n) space.
// We use a queue to implement the BFS algorithm, which can store at most m * n cells in the worst case, taking O(m * n) space.
// Therefore, the total space complexity of this solution is O(m * n).

function updateMatrix(mat) {
  const m = mat.length;
  const n = mat[0].length;
  const queue = [];
  
  // Initialize distance matrix with maximum possible values
  const dist = new Array(m).fill().map(() => new Array(n).fill(Number.MAX_VALUE));
  
  // Initialize the queue with all cells containing 0
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (mat[i][j] === 0) {
        dist[i][j] = 0;
        queue.push([i, j]);
      }
    }
  }
  
  // Perform a BFS starting from the cells containing 0
  while (queue.length > 0) {
    const [i, j] = queue.shift();
    
    // Check the neighbors of the current cell
    const neighbors = [[i - 1, j], [i + 1, j], [i, j - 1], [i, j + 1]];
    for (const [ni, nj] of neighbors) {
      // Check if the neighbor is within bounds
      if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
        // If the distance to the neighbor can be updated
        if (dist[ni][nj] > dist[i][j] + 1) {
          dist[ni][nj] = dist[i][j] + 1;
          queue.push([ni, nj]);
        }
      }
    }
  }
  
  return dist;
}


The updateMatrix function takes a binary matrix mat as input and returns a matrix dist with the distance of the nearest 0 for each cell.
The algorithm first initializes the dist matrix with maximum possible values and adds all cells containing 0 to a queue. 
Then, it performs a BFS starting from the cells in the queue and updates the distances of the neighboring cells if they can be improved. 
Finally, it returns the dist matrix with the updated distances.
