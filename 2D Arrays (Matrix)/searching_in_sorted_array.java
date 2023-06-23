
/* Issue 271
Author:maneesha
Date:10/06/2023
##Assignee:Mani1881

//About:Search in 2D sorted array in Java
//Input:
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
//Time Complexity:O(log(m * n))
//Space Complexity:O(1)
//Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

//Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 
//Explanation:
>>In this code, we have the Solution class with the searchMatrix method that takes a 2D matrix and a target value as parameters. 
>>It iterates through each element in the matrix and checks if the current element is equal to the target value. 
>>If a match is found, it returns true. If no match is found after checking all elements, it returns false.
>>In the main function, we create an instance of the Solution class and define a sample matrix and target value.
>>We then call the searchMatrix method with the provided matrix and target, and store the result in the found variable. 
>>Finally, we print whether the target was found or not. 
>>In this example, the output will be "Target found: true" since the target value 5 exists in the matrix. 
*/

class Solution
{
public boolean searchMatrix(int[][] matrix, int target)
{
  int m = matrix.length;
  int i = 0;
  for (i = 0; i < m; i++) 
  {
  for (int j = 0; j < matrix[i].length; j++)
  {
     if (matrix[i][j] == target)
     return true;
  }
  }
return false;
}

public static void main(String[] args) 
{
    Solution solution = new Solution();
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int target = 5;

    boolean found = solution.searchMatrix(matrix, target);
    System.out.println("Target found: " + found);
}
}

