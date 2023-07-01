/*
    Given an unsorted integer array nums, return the smallest missing positive integer.
    You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
    Sample Input: [3, 4, -1, 1]
    Sample Output: 2
    Explanation:
    This code implements a solution to find the first missing positive integer from an unsorted array. The function first separates positive and negative numbers.
    It then considers the array with only positive numbers, and marks the index corresponding to every positive number in this array.
    The first index which is unmarked corresponds to the first missing positive number.
    This solution uses the array itself as a pseudo-hash table where the keys are the array indices, and the values are whether or not a positive integer is present in the array.
    By using the array in this way, we are able to find the solution in O(1) auxiliary space.
    Time complexity: O(n)
    Space complexity: O(1)
*/

#include <iostream>
#include <vector>
#include <cmath>

int firstMissingPositive(std::vector<int>& nums) {
    int n = nums.size();

    // Mark numbers that are out of range as 0
    for (int i = 0; i < n; i++) {
        if (nums[i] <= 0 || nums[i] > n) {
            nums[i] = 0;
        }
    }

    // Mark the index corresponding to the value of each number
    for (int i = 0; i < n; i++) {
        int num = std::abs(nums[i]);

        if (num > 0) {
            num--; // subtract 1 because of 0-based indexing

            // Mark as negative
            if (nums[num] > 0) {
                nums[num] = -nums[num];
            }
        }
    }

    // Find the first number greater than 0
    for (int i = 0; i < n; i++) {
        if (nums[i] >= 0) {
            return i + 1; // add 1 because of 0-based indexing
        }
    }

    // If no number is missing
    return n + 1;
}

int main() {
    std::vector<int> nums = {3, 4, -1, 1};
    int result = firstMissingPositive(nums);
    std::cout << "Smallest missing positive integer: " << result << std::endl;
    return 0;
}
