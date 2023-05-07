/*
    Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array)
	whose absolute difference is closest to zero, and returns an array containing these two numbers, with the number from
	the first array in the first position.

	Note that the absolute difference of two integers is the distance between them on the real number line.
	For example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.

  	You can assume that there will only be one pair of numbers with the smallest difference.

	Sample Input Array1 = [-1, 5, 10, 20, 28, 3]
	Sample Input Array2 = [26, 134, 135, 15, 17]

	Sample Output = [28, 26]
    The smallestDifference function takes in two arrays of integers and finds the pair of values (one from each array) 
    that have the smallest difference. It does this by sorting the two arrays in ascending order, and then iterating 
    through both arrays using two index variables. At each step, the function calculates the difference between the 
    values pointed to by the index variables, updates the current difference, and moves the index of the array with 
    the smaller value to the right. If the values are equal, the function returns the pair as an array. 
    The function keeps track of the smallest difference seen so far, and updates the result array accordingly. 
    Finally, the function returns the result array containing the pair with the smallest difference.

    O(nlog(n) + mlog(m)) time | O(1) space - where n is the length of the first input array and m is the length of the second input array
*/
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
