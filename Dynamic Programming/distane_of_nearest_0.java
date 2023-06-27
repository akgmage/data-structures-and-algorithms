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

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] distances = new int[m][n]; // Initialize a distances matrix
        Queue<int[]> queue = new LinkedList<>(); // Initialize a queue for BFS

         // Loop through the matrix and set distances to MAX_VALUE except for cells with 0
        for (int i = 0; i < m; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    distances[i][j] = 0;
                    queue.offer(new int[]{i, j});  // Add the cell to the queue 
                }
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            for (int[] direction : DIRECTIONS) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (x < 0 || x >= m || y < 0 || y >= n) { // Check if cell is out of bounds
                    continue;
                }
                if (distances[x][y] <= distances[i][j] + 1) {// Check if distance is already smaller
                    continue;
                }
                distances[x][y] = distances[i][j] + 1; // Update the distance
                queue.offer(new int[]{x, y});// Add the cell to the queue
            }
        }
        return distances; // Return the updated distances matrix 
    }
}


//Input
// mat =
// [[0,0,0],[0,1,0],[0,0,0]]

// Output
// [[0,0,0],[0,1,0],[0,0,0]]