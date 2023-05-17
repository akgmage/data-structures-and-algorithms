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
