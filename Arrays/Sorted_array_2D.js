/*Name : Abhinav kumar
Github username : Abhinavcode13
Repository name : data-structures-and-algorithms
Problem : Search in 2D sorted array in Javascript
Issue Number : #272
Problem statement : 

Explanation of the below Javascript code :

The function searchMatrix takes in a matrix (matrix) and a target integer (target) as parameters. It returns true if the target is found in the matrix and false otherwise.

The function first checks for edge cases where the matrix is empty or the rows are empty, and immediately returns false in such cases.

It then initializes variables for the number of rows (rows) and columns (cols) in the matrix, and sets the left and right indices for the binary search.

The binary search is performed using a while loop, with the left and right indices as the condition. Inside the loop, the middle index (mid) is calculated using Math.floor((left + right) / 2), and the corresponding row and column indices are derived from the mid index.

The element at the mid index is compared with the target, and based on the comparison, the search space is narrowed down by updating the left and right indices accordingly.

If the target is found, the function returns true. If the loop completes without finding the target, the function returns false.

The time complexity of this JavaScript solution is O(log(m * n)), as it performs a binary search on a list of size m * n.


*/

-------------------------------------------------------------------------//Javascript code begins here-----------------------------------------------------------------------


/**
 * Searches for a target integer in a matrix.
 * @param {number[][]} matrix - The matrix to search in.
 * @param {number} target - The target integer to search for.
 * @return {boolean} - True if the target is found, false otherwise.
 */
function searchMatrix(matrix, target) {
    // Check for empty matrix or empty rows
    if (!matrix || matrix.length === 0 || matrix[0].length === 0) {
        return false;
    }

    const rows = matrix.length;
    const cols = matrix[0].length;
    let left = 0;
    let right = rows * cols - 1;

    // Perform binary search on the matrix
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        const row = Math.floor(mid / cols);
        const col = mid % cols;

        if (matrix[row][col] === target) {
            // Target found
            return true;
        } else if (matrix[row][col] < target) {
            // Target is in the right half of the matrix
            left = mid + 1;
        } else {
            // Target is in the left half of the matrix
            right = mid - 1;
        }
    }

    // Target not found
    return false;
}
