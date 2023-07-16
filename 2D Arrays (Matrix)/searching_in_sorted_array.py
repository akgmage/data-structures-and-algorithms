'''
Date:28/6/23
About:Search in 2D sorted array in Python

Input:
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

Time Complexity:
You must write a solution in O(log(m * n)) time complexity.
Space Complexity:O(1)

//Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
//Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

//Explanation
The method takes two parameters: matrix, which represents the sorted matrix, and target, which is the value we want to find in the matrix.

The code initializes variables nRows and nCols to store the number of rows and columns in the matrix, respectively.

The starting position for the search is set to the bottom-left corner of the matrix (row = nRows - 1, col = 0).

The code enters a while loop that continues as long as the current row index (row) is within the bounds of the matrix (0 to nRows - 1
and the current column index (col) is within the bounds of the matrix (0 to nCols - 1).

Inside the loop, the code retrieves the value at the current position in the matrix (val = matrix[row][col]).

If the current value (val) == value, the method returns True, indicating that the target is found in the matrix.

If the current value (val) < target value, it means the target can only be found in the rows above the current row. 
Therefore, the column index (col) is incremented to move to the next column.

If the current value (val) >target value, it means the target can only be found in the columns to the left of the current column. 
Therefore, the row index (row) is decremented to move to the previous row.

If the loop completes without finding the target value, the method returns False.

'''
class Solution(object):
    def searchMatrix(self, matrix, target):
        nRows = len(matrix)
        nCols = len(matrix[0])
        row = nRows - 1
        col = 0
        while 0 <= row < nRows and 0 <= col < nCols:
            val = matrix[row][col]
            if val == target:
                return True
            elif val < target:
                col += 1
            else:
                row -= 1
        return False


# Create an instance of the Solution class
solution = Solution()

# Define the matrix and target value
matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
target = 3

# Call the searchMatrix method and print the result
result = solution.searchMatrix(matrix, target)
print(result)




 

