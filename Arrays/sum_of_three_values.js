/*
Given an array of integers, nums, and an integer value, target,
determine if there are any three integers in nums whose sum equals the target.
Return TRUE if three such integers are found in the array. Otherwise, return FALSE.

Sample Input : 3, 7, 1, 2, 8, 4, 5 Target : 18
Output : True
Sample Input : 0 -1 1 Target : 2
Output : False

APPROACH:

1) We need to sort the array for our strategy to work.
2) Iterating from index 0, we check three numbers:
  - value at index i (starting at 0)
  - low: value at index i + 1
  - high: value at index nums.length - 1 (the last value, also the highest)
3) Take the sum of these three values.
  - If sum equals target, return true
  - If sum is less than the target, increment "low" and run this step again
  - If sum is higher than the target, decrement "high" and run this step again
4) If low meets high, we ran out of numbers to try. Back to step 2.
5) Return false at the end of everything because we found no matching sums

For a similar problem:
https://leetcode.com/problems/3sum/

*/


const sumOfThree = (nums, target) => {
  // function only applies to arrays with at least 3 values
  if (nums.length < 3) return false

  // Sort the array
  nums.sort()

  let low, high

  // Iterate through each value (up to 3rd from last)
  for (let i = 0; i < nums.length - 2; i++) {

    //Assign pointers and check the sum
    low = i + 1
    high = nums.length - 1

    while (low < high) {

      let sum = nums[i] + nums[low] + nums[high]

      // match found, return true
      if (sum === target) {
        return true

        // sum is too low, increase low pointer
      } else if (sum < target) {
        low++

        // sum is too high, decrease high pointer
      } else {
        high--
      }
    }
  }

  return false
}

console.log(sumOfThree([3, 7, 1, 2, 8, 4, 5], 18)) // true
console.log(sumOfThree([3, 7, 1, 2, 8, 4, 5], 50)) // false
console.log(sumOfThree([0, -1, 1], 2)) // false
console.log(sumOfThree([0, -1, 1], 0)) // true

