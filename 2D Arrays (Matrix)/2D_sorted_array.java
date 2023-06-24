/*

The algorithm starts by initializing two pointers, left and right, which represent the start and end indices of the search range. The range spans from the first element (matrix[0][0]) to the last element (matrix[m - 1][n - 1]) in the matrix, where m is the number of rows and n is the number of columns.

The function then enters a while loop that continues as long as left is less than or equal to right. In each iteration, it calculates the middle index mid using the formula mid = left + (right - left) / 2. This ensures that mid is always rounded down to the lower integer if the range is odd.

The middle index mid is then mapped to its corresponding row and column indices in the matrix using the formulas row = mid / n and col = mid % n.

The number num at the middle position (matrix[row][col]) is retrieved and compared with the target. If num is equal to the target, the function returns true as the target is found in the matrix. If num is less than the target, the left pointer is updated to mid + 1 to search in the upper half of the range. If num is greater than the target, the right pointer is updated to mid - 1 to search in the lower half of the range.

If the while loop terminates without finding the target, the function returns false.

The algorithm achieves a time complexity of O(log(m * n)), where m is the number of rows and n is the number of columns in the matrix, as it uses binary search to efficiently search within the given range.

*/



#include <vector>
class Solution {
public:
    /**
     * Searches for a target integer in a matrix with specific properties.
     *
     * @param matrix The input matrix.
     * @param target The target integer to search for.
     * @return True if the target is found in the matrix, false otherwise.
     */
    bool searchMatrix(std::vector<std::vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();

        int left = 0;              // Start index of the search range
        int right = m * n - 1;     // End index of the search range

        while (left <= right) {
            int mid = left + (right - left) / 2;   // Calculate middle index
            int row = mid / n;                     // Calculate row index
            int col = mid % n;                     // Calculate column index
            int num = matrix[row][col];            // Get the number at the middle position

            if (num == target) {
                return true;                       // Target found in the matrix
            } else if (num < target) {
                left = mid + 1;                     // Search in the upper half of the range
            } else {
                right = mid - 1;                    // Search in the lower half of the range
            }
        }

        return false;                               // Target not found in the matrix
    }
};
