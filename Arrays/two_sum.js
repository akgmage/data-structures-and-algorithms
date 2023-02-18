//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// https://leetcode.com/problems/two-sum/

function twoSum(nums, target) {
    for (i = 0; i < nums.length; i++) {
        for (j = 0; j < nums.length; j++) {
            if (i == j) {
                continue;
            }
            if (nums[i] + nums[j] == target) {
                return [i, j];
                break;
            }
        }
    }
}

// Driver code
console.log(twoSum([3, 2, 4], 6));
