/*Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 10^4
1 <= m * n <= 10^4
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.


explanation: 

stepwise explanation of the code: 

1. We start by initializing the dimensions of the input matrix mat as m (number of rows) and n (number of columns). This will be used later in the code.

2. We create a result matrix called result of size m x n to store the distance of the nearest 0 for each cell. Initially, we set all the values in result to a large value (in this case, INT_MAX) to represent an unreachable distance.

3. We create a queue called q to store the cell indices that need to be processed during the breadth-first search.

4. We iterate through the input matrix mat and enqueue the indices of all the cells with value 0 into the queue. Additionally, we mark the distance of these cells in the result matrix as 0. This initialization step ensures that the cells with value 0 are considered as starting points for the breadth-first search.

5. Now, we perform the breadth-first search using the queue q. While the queue is not empty, we process the cells in a breadth-first manner.

6. For each cell (row, col) popped from the queue, we check its neighboring cells in four directions: up, down, left, and right. We define the directions as a vector of pairs called directions, where each pair represents the change in row and column indices to move in a specific direction.

7. If the neighboring cell indices (newRow, newCol) are within the valid range of the matrix and the current distance in the result matrix for (newRow, newCol) is greater than the distance of the current cell plus 1, we update the distance in the result matrix and enqueue the neighboring cell (newRow, newCol) into the queue for further processing.

8. Once the breadth-first search is completed, the result matrix will contain the distance of the nearest 0 for each cell in the input matrix.

9. Finally, we return the result matrix.

*/

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution
{
public:
    vector<vector<int>> updateMatrix(vector<vector<int>> &mat)
    {
        int m = mat.size();
        int n = mat[0].size();

        // Create a result matrix and initialize with large values
        vector<vector<int>> result(m, vector<int>(n, INT_MAX));

        // Create a queue to store cell indices
        queue<pair<int, int>> q;

        // Initialize the queue with 0 cells and mark their distance as 0
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 0)
                {
                    result[i][j] = 0;
                    q.push({i, j});
                }
            }
        }

        // Perform breadth-first search
        vector<pair<int, int>> directions{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.empty())
        {
            int row = q.front().first;
            int col = q.front().second;
            q.pop();

            for (const auto &dir : directions)
            {
                int newRow = row + dir.first;
                int newCol = col + dir.second;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n)
                {
                    if (result[newRow][newCol] > result[row][col] + 1)
                    {
                        result[newRow][newCol] = result[row][col] + 1;
                        q.push({newRow, newCol});
                    }
                }
            }
        }

        return result;
    }
};

int main()
{
    // Example usage
    vector<vector<int>> mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

    Solution s;
    vector<vector<int>> result = s.updateMatrix(mat);

    // Print the result
    for (const auto &row : result)
    {
        for (int val : row)
        {
            cout << val << " ";
        }
        cout << endl;
    }

    return 0;
}
