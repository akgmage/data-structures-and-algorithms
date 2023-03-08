/*
    You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.

    You must write a solution in O(log(m * n)) time complexity.


    1.Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    Output: true

    2.Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
    Output: false
*/

class Solution {
public:
    bool searchMatrix(vector<vector<int>> &matrix,int target) {
        int i = 0;
        int j = matrix[0].size() - 1; 
        
        while(i < matrix.size() && j >= 0)
        {
            if(target == matrix[i][j])
                return true;         
            else if(target < matrix[i][j])
                j--;
            else 
                i++;
        }
        return false;
    }
};
