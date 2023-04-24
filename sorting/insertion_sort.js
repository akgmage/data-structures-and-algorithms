/*
	In this implementation, we define a function called InsertionSort that takes an array of integers and sorts
	it in ascending order using the Insertion Sort algorithm.

	The algorithm works by iterating over the array from the second element to the end.

	For each element, it compares it with the previous elements in the array and inserts it in the correct position.

	The current variable holds the value of the current element being compared.

	The j variable holds the index of the previous element being compared.

	The loop compares the current value with the previous values in the array and shifts the values to the right to make space for the current value.

	Once the correct position is found, the current value is inserted into the array.

	Finally, the sorted array is returned. In the main function, we define an array of integers, sort it using the InsertionSort function, and print the sorted array.

	Sample input: [0, 2, 1,-1, 10, 3, 4]
	Output: [-1 0 1 2 3 4 10]
*/

/**
 * Perform insertion sort on an array of integers in non-decreasing order.
 * @param {number[]} arr - The input array to sort.
 * @returns {number[]} The sorted array in non-decreasing order.
 */
function insertionSort(arr) {
  // Loop through each element of the array, starting with the second.
  for (let i = 1; i < arr.length; i++) {
    // Save the current element to be inserted later.
    let current = arr[i];
    // Loop through the sorted portion of the array backwards.
    for (let j = i - 1; j >= 0 && arr[j] > current; j--) {
      // Shift each element that is greater than the current element up one position.
      arr[j + 1] = arr[j];
    }
    // Insert the current element in its proper place.
    arr[j + 1] = current;
  }
  // Return the sorted array.
  return arr;
}

const inputArr = [4, 5, 67, 56, 3, 35, 45];
console.log(insertionSort(inputArr));
