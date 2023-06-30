/*
    -> The maximalSquare function takes a matrix as input and returns the area of the maximal square found in the matrix.
    -> The function first checks if the matrix is empty (no rows or columns). In such cases, there can't be any squares,
     so it returns 0.
    -> Next, it initializes some variables. rows stores the number of rows in the matrix, cols stores the number of
     columns, and maxSide keeps track of the maximum side length of the square encountered so far.
    -> It creates a new matrix called dp using the Array.from method. This matrix will store the side lengths of squares.
    -> The next step is to initialize the first row and the first column of dp with the values from the input matrix. It 
    iterates over each element in the first row and sets the corresponding element in dp to either 0 or 1, depending on 
    whether the element in the input matrix is '0' or '1'. It also updates maxSide accordingly.
    -> Similarly, it iterates over each element in the first column and sets the corresponding element in dp to either 
    0 or 1, based on the input matrix. Again, maxSide is updated.
    -> Now, the function enters a nested loop to iterate over the remaining elements of the matrix, starting from the
    second row and the second column. For each element at position (i, j), it checks if the corresponding element in the
    input matrix is '1'.
    -> If the element is '1', it calculates the value of dp[i][j] by taking the minimum of the three adjacent elements: 
    dp[i-1][j] (above), dp[i][j-1] (left), and dp[i-1][j-1] (diagonally above-left). It adds 1 to the minimum value and 
    assigns it to dp[i][j]. Additionally, it updates maxSide if the current dp[i][j] value is greater.
    -> After the nested loop completes, the function has calculated the side lengths of squares for all positions in the 
    matrix. It returns the area of the maximal square by squaring the value of maxSide.
    -> Finally, outside the function, an example usage is shown. The matrix variable represents a 2D array with 0s and 1s. 
    The maximalSquare function is called with this matrix, and the returned result is logged to the console. In this
    example, the maximal square in the matrix has a side length of 2, so the output is 4 (2 * 2).

The code utilizes dynamic programming to efficiently calculate the maximal square in the given matrix by storing the 
side lengths of squares in a separate matrix. By using previously calculated values, the algorithm avoids redundant 
calculations and improves performance.

//Time complexity

The time complexity of the provided maximal square algorithm is O(m * n), where m is the number of rows 
in the matrix and n is the number of columns. This is because we iterate over each element in the matrix 
once to calculate the side lengths of squares. The nested loops contribute to the linear time complexity.

The space complexity is O(m * n) as well. We create an additional matrix, dp, with the same dimensions as 
the input matrix to store the side lengths of squares. Hence, the space required is proportional to the 
number of elements in the matrix.

In summary, the time complexity and space complexity of the maximal square algorithm are both O(m * n), 
where m is the number of rows and n is the number of columns in the matrix.
*/


/*

Example 1:
Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4 
The maximal square in the matrix is a 2x2 square with the top-left corner at position (1, 2) and the bottom-right corner at position (2, 3). The area of this square is 4.

Example 2:
Input:
0 1 1 1 1
1 1 0 1 0
0 1 1 1 1
1 1 1 1 0


Output: 9
The maximal square in the matrix is a 3x3 square with the top-left corner at position (0, 1) and the bottom-right corner at position (2, 3). The area of this square is 9.

Example 3:
Input:

0 0 0
0 0 0
0 0 0

Output: 0
There are no squares with side length greater than 0 in the matrix. Therefore, the output is 0.

*/
#include <iostream>
#include <vector>
#include <algorithm>

int maximalSquare(std::vector<std::vector<char>>& matrix) {
    if (matrix.empty() || matrix[0].empty()) {
        return 0;
    }

    int rows = matrix.size();
    int cols = matrix[0].size();
    int maxSide = 0;

    // Create a new matrix to store the side lengths of squares
    std::vector<std::vector<int>> dp(rows, std::vector<int>(cols, 0));

    // Initialize the first row of the dp matrix
    for (int i = 0; i < rows; i++) {
        dp[i][0] = matrix[i][0] - '0';
        maxSide = std::max(maxSide, dp[i][0]);
    }

    // Initialize the first column of the dp matrix
    for (int j = 0; j < cols; j++) {
        dp[0][j] = matrix[0][j] - '0';
        maxSide = std::max(maxSide, dp[0][j]);
    }

    // Iterate over the remaining elements of the matrix
    for (int i = 1; i < rows; i++) {
        for (int j = 1; j < cols; j++) {
            if (matrix[i][j] == '1') {
                // Calculate the minimum of the three adjacent squares and add 1
                dp[i][j] = std::min({dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]}) + 1;
                maxSide = std::max(maxSide, dp[i][j]);
            }
        }
    }

    // Return the area of the maximal square
    return maxSide * maxSide;
}