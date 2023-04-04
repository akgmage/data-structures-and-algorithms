/*
  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. If any two numbers in the input array sum
  up to the target sum, the function should return them in an array, in any
  order. If no two numbers sum up to the target sum, the function should return
  an empty array.
  Sample Input: [2, 1, 3, -1, 11, 5, 4, 0] Target: 10
  Output: [-1 11]
*/
function twoNumberSum(nums, target) {
  // Create a new Map object to store the indices of the elements in the array
  const map = new Map();

  // Loop through the array
  for (let i = 0; i < nums.length; i++) {
    // Calculate the complement of the current element with respect to the target sum
    const complement = target - nums[i];

    // Check if the complement is already in the map
    if (map.has(complement)) {
      // If the complement is in the map, return the indices of the two elements that sum up to the target
      return [map.get(complement), i];
    }

    // If the complement is not in the map, add the current element and its index to the map
    map.set(nums[i], i);
  }

  // If no two elements sum up to the target, return an empty array
  return [];
}

// Example usage
const nums = [2, 7, 11, 15];
const target = 9;
const result = twoNumberSum(nums, target);

if (result.length > 0) {
  console.log(`Indices of the two numbers that sum up to ${target}: ${result}`);
} else {
  console.log(`No two numbers found that sum up to ${target}.`);
}
