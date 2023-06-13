/*
    Dutch National Flag Problem

    Given an array containing only 0s, 1s, and 2s, sort the array in a single traversal.

    Sample Input: [0, 2, 1, 2, 0]
    Sample Output: [0, 0, 1, 2, 2]

    Approach:
    - We can use three pointers, low, mid, and high, to divide the array into three regions:
      1. 0s region: elements before the low pointer (excluding low) are 0s
      2. 1s region: elements between the low and mid pointers (excluding mid) are 1s
      3. 2s region: elements after the high pointer (excluding high) are 2s
    - Initialize low and mid pointers to the start of the array (0 index) and high pointer to the end of the array (array.length - 1).
    - Iterate while the mid pointer is less than or equal to the high pointer:
      - If the current element at mid is 0, swap it with the element at low and increment both low and mid pointers.
      - If the current element at mid is 1, it is already in the correct region, so we just increment the mid pointer.
      - If the current element at mid is 2, swap it with the element at high and decrement the high pointer.
    - Repeat the above steps until the mid pointer crosses the high pointer.
    - At the end, the array will be sorted in place.

    Time Complexity: O(n), where n is the length of the array.
    Space Complexity: O(1), no additional space is used.

    Further Reading: https://en.wikipedia.org/wiki/Dutch_national_flag_problem
*/

function dutchNationalFlagProblem(arr) {
  let low = 0;
  let mid = 0;
  let high = arr.length - 1;

  while (mid <= high) {
    if (arr[mid] === 0) {
      // Swap current element at mid with element at low
      [arr[mid], arr[low]] = [arr[low], arr[mid]];
      // Increment both low and mid pointers
      low++;
      mid++;
    } else if (arr[mid] === 1) {
      // Move to the next element in the 1s region
      mid++;
    } else {
      // Swap current element at mid with element at high
      [arr[mid], arr[high]] = [arr[high], arr[mid]];
      // Decrement the high pointer
      high--;
    }
  }

  return arr;
}

// Test the function
const input = [0, 2, 1, 2, 0];
const output = dutchNationalFlagProblem(input);
console.log(output);
