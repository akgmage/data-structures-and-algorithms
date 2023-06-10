/* 
                                            -----------QUESTION--------------

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1]. Devise an algorithm with O(log n) runtime complexity.

Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

Example 3:
    Input: nums = [], target = 0
    Output: [-1,-1]


Constraints:
        0 <= nums.length <= 105
        -109 <= nums[i] <= 109
        nums is a non-decreasing array (increasing order)
        -109 <= target <= 109
*/


//                                       ------------SOLUTION-------------

/* 
An intuitive Binary Search algorithm is used to find target value indices of occurence since it is given an increasing array. We perform two searches one for first occurence and second for last occurence.

Two pointer start and end for 0th and (N-1)th index to iteratively find the mid of array.  

First follow the common left-based binary search to find the target value first occurence. 
If found we proceed further check in left subarray as target may still be presnt either to left or right of mid.

To find last occurence index we again iterate to right subarray from start as the current value but reset last to N-1.

(start does not require to begin again from 0th index as in first pass we have covered upto start index. This does not affect overall complexity but reduces number of comparisions.)
*/


/*

Time Complexity: 
    O(log N) - Each time the sub-array reduces to half as
    N/2 -> N/4 -> N/8 ... after k iterations this results to O(1)
    N/ 2^k = 1
    N = 2^k   (take a log) 
    k = log(N) (the complexity is defined by how many times the loop executes which is k times)

    T.C = O(log N)

Space Complexity: 
    O(1) - Constant space for storing variables
 
*/

var searchRange = function(nums, target) {
    
    let ans = [-1, -1];
    // array of resulting indices pre-initialised with -1 in case the target is not found

    let start = 0, end = nums.length - 1, mid;


    //First Occurence
    while (start <= end) {
        mid = Math.floor((start + end) / 2);

        if (nums[mid] === target) {
            ans[0] = mid;
            end = mid - 1;
            //we continue to search in left subarray to find the first occurence position of target value
        }
        else if (nums[mid] > target) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }
    }


    //Last Occurence
    end = nums.length - 1;
    while (start <= end) {
        mid = Math.floor((start + end) / 2);

        if (nums[mid] === target) {
            ans[1] = mid;
            start = mid + 1;
            //for last occurence we search the subarray right to the middle index 
        }
        else if (nums[mid] > target) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }
    }

    return ans;
};