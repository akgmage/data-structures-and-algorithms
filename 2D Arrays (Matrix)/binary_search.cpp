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
    bool costumBinarySearch(const vector<vector<int>>& matrix, int target, int low, int high){
        int size = matrix[0].size();
        while(high - low > 1){
            int mid = (high + low) / 2;
            if(matrix[mid / size][mid % size] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if(matrix[low / size][low % size] == target || matrix[high / size][high % size] == target){
            return true;
        }
        return false;
    }
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        return costumBinarySearch(matrix, target, 0, matrix.size() * matrix[0].size() - 1);
    }
};