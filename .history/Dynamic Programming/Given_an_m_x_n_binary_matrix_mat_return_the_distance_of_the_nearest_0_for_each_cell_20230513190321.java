// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell in Java


// Solution
// // This solution uses a breadth-first search (BFS) approach to calculate the distance of the nearest 0 for each cell in the matrix. 
// // The idea is to initialize a distances matrix with all values set to the maximum integer value, except for the cells that contain 0s,
// // which are set to 0 and added to a queue. We then perform a BFS on the queue, updating the distances of neighboring cells as we go.
// // Finally, we return the updated distances matrix.


class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] distances = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    distances[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            for (int[] direction : DIRECTIONS) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                if (distances[x][y] <= distances[i][j] + 1) {
                    continue;
                }
                distances[x][y] = distances[i][j] + 1;
                queue.offer(new int[]{x, y});
            }
        }
        return distances;
    }
}
