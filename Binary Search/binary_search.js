/**
 * Finds the first and last occurrence of a target value in a sorted array.
 *
 * @param {number[]} N - The sorted array of numbers.
 * @param {number} T - The target value to search for.
 * @returns {number[]} An array containing the first and last index of the target value, or [-1,-1] if not found.
 */
const searchRange = function(N, T) {
    // Helper function to perform binary search on the array
    const find = (target, arr, left=0, right=arr.length) => {
      while (left <= right) {
        // Calculate the middle index
        let mid = left + right >> 1;
        // If the middle element is less than the target, move the left pointer to mid + 1
        if (arr[mid] < target) left = mid + 1;
        // If the middle element is greater than or equal to the target, move the right pointer to mid - 1
        else right = mid - 1;
      }
      // Return the left pointer, which will be the index of the target or the insertion point if not found
      return left;
    }; 
  
    // Find the leftmost index of the target value
    let Tleft = find(T, N);
    // If the target value is not found in the array, return [-1,-1]
    if (N[Tleft] !== T) return [-1,-1];
    // Find the rightmost index of the target value
    return [Tleft, find(T+1, N, Tleft) - 1];
  };
  