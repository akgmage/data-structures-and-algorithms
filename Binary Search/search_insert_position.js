// https://leetcode.com/problems/search-insert-position/description/

/*

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

Explanation:
    In a given sorted array this code uses binary search where we divide the array into two parts and check if the number is present then we return the index of element otherwise we return what should be index of that target in the given array.
    The loops iterates until the start index and end index of array is same.
    We calculate the middle index on each iteration of loop as start index / end index might change on the basis of last iteration result.
    If the middle index element is the target element then we return middle index otherwise we loop through the entire array until last one or two elements left.
    On the basis of last one or two elements we decide what is going to be the index of target in the array.
*/

function findSearchPosition(nums, target) {
    let startIndex = 0;
    let endIndex = nums.length - 1;

    while (startIndex <= endIndex) {
        const midIndex = startIndex + Math.floor((endIndex - startIndex) / 2);

        // Base case if middle index element is our target then we will return the middle index
        if (nums[midIndex] === target) {
            return midIndex;
        }

        // In case if element is not present in the given array then in the final iteration when only last one or two elements are remaining we will check what should be our target number index in the given array
        if (startIndex === endIndex || startIndex + 1 === endIndex) {
            // If element at start index is greater then target then target then start index will be assigned to target
            if (nums[startIndex] > target) {
                return startIndex;
                // if target is greater then end index element then end index + 1 will be assigned to target
            } else if (nums[endIndex] < target) {
                return endIndex + 1;
            } else {
                return startIndex + 1;
            }
        }

        // if the target element is greater then the middle index element then we will change the start index next to middle index otherwise we will change last index to middle index - 1
        if (nums[midIndex] < target) {
            startIndex = midIndex + 1;
        } else {
            endIndex = midIndex - 1;
        }
    }
}

//driver code
var nums = [1, 3, 5, 6];
console.log(findSearchPosition(nums, 8));

//Input: nums = [1,3,5,6], target = 8
// Output: 4
