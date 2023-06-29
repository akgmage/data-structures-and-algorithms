// First Missing Positve
/*
    -> The firstMissingPositive function takes an array of integers called nums as input.

    -> The function first determines the length of the array nums and assigns it to the variable n.

    -> Step 1: Move positive numbers to their correct positions
          - The algorithm iterates through each element of the array using a for loop.
          - Inside the loop, it checks if the current number (nums[i]) is positive and within the range of 1 to n.
          - If the number is valid, it checks whether the number at its correct position (nums[nums[i] - 1]) is 
          different from the current number itself. This ensures that the number is not already in its correct place.
          - If the numbers are different, it swaps the current number with the number at its correct position using 
          array destructuring ([nums[nums[i] - 1], nums[i]] = [nums[i], nums[nums[i] - 1]]). This moves the current 
          number to its correct place in the array.
          - The swapping process continues until the number at index i is either non-positive or already in its correct 
          place. This step ensures that all positive numbers are placed in their respective positions.

    Step 2: Find the first missing positive
          - After completing the first pass through the array, the algorithm performs a second pass using another for loop.
          - Inside the loop, it checks if the number at index i is equal to i + 1. If not, it means that i + 1 is 
          missing from the array.
          - In this case, the algorithm returns i + 1 as the smallest missing positive integer.

    -> If all positive integers from 1 to n are present in the array, the function reaches the end without finding a 
    missing positive. In this case, it returns n + 1 as the smallest missing positive integer.



The algorithm meets the given time complexity requirement of O(n) because it performs two passes through the array, 
and each pass visits each element once. It also satisfies the space complexity requirement of O(1) since it modifies 
the input array in-place without using any additional data structures.
*/


/*
Examples-

Example 1:
Input: nums = [1, 2, 0]
Output: 3
Explanation: The smallest missing positive integer in the array is 3.

Example 2:
Input: nums = [3, 4, -1, 1]
Output: 2
Explanation: The smallest missing positive integer in the array is 2.

Example 3:
Input: nums = [7, 8, 9, 11, 12]
Output: 1
Explanation: The smallest missing positive integer in the array is 1.
*/


function firstMissingPositive(nums) {
  const n = nums.length;

  // Step 1: Move positive numbers to their correct positions
  for (let i = 0; i < n; i++) {
    while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] !== nums[i]) {
      [nums[nums[i] - 1], nums[i]] = [nums[i], nums[nums[i] - 1]];
    }
  }

  // Step 2: Find the first missing positive
  for (let i = 0; i < n; i++) {
    if (nums[i] !== i + 1) {
      return i + 1;
    }
  }

  // If all positive integers are present, return n + 1
  return n + 1;
}