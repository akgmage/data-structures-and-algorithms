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

*/

function findSearchPosition(nums, target) {
    let startIndex = 0;
    let endIndex = nums.length - 1;

    while (startIndex <= endIndex) {
        const midIndex = startIndex + Math.floor((endIndex - startIndex) / 2);

        console.log(startIndex, endIndex, midIndex);

        if (nums[midIndex] === target) {
            return midIndex;
        }

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
