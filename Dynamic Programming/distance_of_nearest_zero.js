Example:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

It can be solved using a Breadth First Search Algorithm(BFS)

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
