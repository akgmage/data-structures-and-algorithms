/**
 * Given two arrays of integers, finds a pair of values (one value from each array)
 * that have the smallest difference. Returns the pair as an array.
 * @param {number[]} array1 - The first array of integers
 * @param {number[]} array2 - The second array of integers
 * @returns {number[]} - The pair of values that have the smallest difference
 */
function smallestDifference(array1, array2) {
  let currentDiff = Infinity; // initialize current difference to a large number
  let smallestDiff = Infinity; // initialize smallest difference to a large number
  let result = []; // initialize result array
  array1.sort((a, b) => a - b); // sort the first array in ascending order
  array2.sort((a, b) => a - b); // sort the second array in ascending order
  let idx1 = 0; // initialize index for first array
  let idx2 = 0; // initialize index for second array
  while (idx1 < array1.length && idx2 < array2.length) {
    const first = array1[idx1];
    const second = array2[idx2];
    if (first < second) {
      // if the value from first array is smaller
      currentDiff = second - first; // update the current difference
      idx1++; // move the index of first array to the right
    } else if (second < first) {
      // if the value from second array is smaller
      currentDiff = first - second; // update the current difference
      idx2++; // move the index of second array to the right
    } else {
      // if the values are equal, the smallest difference is 0
      return [first, second];
    }
    if (smallestDiff > currentDiff) {
      // if the current difference is smaller than the smallest difference so far
      smallestDiff = currentDiff; // update the smallest difference
      result = [first, second]; // update the result array
    }
  }
  return result;
}
