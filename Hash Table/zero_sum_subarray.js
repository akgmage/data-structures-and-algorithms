/*
	You're given a list of integers nums. Write a function that returns a boolean representing
	whether there exists a zero-sum subarray of nums

	Sample Input :  = [-5, -5, 2, 3, -2]
	Output : True
	The subarray [-5, 2, 3] has a sum of 0

    Time and Space complexity : O(n) time | O(n) space - where n is the length of nums

    Approach:
    The function takes in an array of integers nums. It initializes a set sums to keep track of the subarray sums we've seen so far, 
    and a variable currentSum to keep track of the current sum as we loop through the array.

    We then loop through each number in the array, adding the current number to the current sum. 
    We check if the current sum is zero or if we've seen it before (i.e. if it's already in the sums set). 
    If so, we've found a zero-sum subarray, so we return true.

    If we loop through the entire array without finding a zero-sum subarray, we return false.
*/
function hasZeroSumSubarray(nums) {
  const sums = new Set(); // Initialize a set to keep track of the subarray sums
  let currentSum = 0; // Initialize a variable to keep track of the current sum

  for (const num of nums) {
    // Loop through each number in the array
    currentSum += num; // Add the current number to the current sum
    if (currentSum === 0 || sums.has(currentSum)) {
      // Check if the current sum is zero or if we've seen it before
      return true; // If so, we've found a zero-sum subarray, so return true
    }
    sums.add(currentSum); // Add the current sum to the set of subarray sums
  }
  return false; // If we loop through the entire array without finding a zero-sum subarray, return false
}
