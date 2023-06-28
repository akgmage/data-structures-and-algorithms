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
The searchMatrix function takes two parameters: matrix (a 2D array) and target (the value to be searched).
It initializes the variable m to store the length of the matrix (number of rows).
It then iterates through each row of the matrix using a for loop.
Inside the outer loop, there's another nested loop that iterates through each element of the current row.
It checks if the current element is equal to the target value. 
If a match is found, it immediately returns True, indicating that the target is present in the matrix.
Else the function returns False, indicating that the target is not present in the matrix.
In the main section, an instance of the Solution class is created.
A sample matrix is defined with some values.
The target value is set to 5.
The searchMatrix function is called with the matrix and target as arguments, and the result is stored in the variable found.
Finally, it prints whether the target was found or not.

'''
class Solution:
    def searchMatrix(self, matrix, target):
        m = len(matrix)
        for i in range(m):
            for j in range(len(matrix[i])):
                if matrix[i][j] == target:
                    return True
        return False

if __name__ == "__main__":
    solution = Solution()
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    target = 5

    found = solution.searchMatrix(matrix, target)
    print("Target found:", found)



 

