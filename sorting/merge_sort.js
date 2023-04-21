// Merge Sort
/*
	Here's how the merge sort algorithm works:

	1. It divides the input array into two halves, recursively sorts them, and then merges the sorted halves.
	2. To merge two sorted sub-arrays, we need to create a temporary array and then compare the elements of the two sub-arrays, 
	   one by one, and add the smaller element to the temporary array.
	3. After we have exhausted one of the sub-arrays, we simply copy the remaining elements of the other sub-array to the temporary array.
	4. Finally, we copy the elements of the temporary array back to the original array.

	The time complexity of merge sort is O(n log n), where n is the number of elements in the array. 
	The space complexity is O(n), because we create a temporary array of size n during the merging process.
*/

/**
 * Merge sort algorithm to sort an array of integers in ascending order.
 * @param {Array} arr - The array of integers to be sorted
 * @return {Array} - The sorted array
 */
function mergeSort(arr) {
  if (arr.length <= 1) {
    return arr;
  }

  // Split the array into two halves
  const middleIndex = Math.floor(arr.length / 2);
  const leftArr = arr.slice(0, middleIndex);
  const rightArr = arr.slice(middleIndex);

  // Recursively call mergeSort on each half
  const sortedLeftArr = mergeSort(leftArr);
  const sortedRightArr = mergeSort(rightArr);

  // Merge the two sorted halves into a single sorted array
  return merge(sortedLeftArr, sortedRightArr);
}

/**
 * Merge two sorted arrays into a single sorted array
 * @param {Array} leftArr - The first sorted array
 * @param {Array} rightArr - The second sorted array
 * @return {Array} - The merged sorted array
 */
function merge(leftArr, rightArr) {
  let i = 0;
  let j = 0;
  const mergedArr = [];

  // Compare the elements of the two arrays and add the smallest to the merged array
  while (i < leftArr.length && j < rightArr.length) {
    if (leftArr[i] <= rightArr[j]) {
      mergedArr.push(leftArr[i]);
      i++;
    } else {
      mergedArr.push(rightArr[j]);
      j++;
    }
  }

  // Add any remaining elements from the left or right array to the merged array
  while (i < leftArr.length) {
    mergedArr.push(leftArr[i]);
    i++;
  }

  while (j < rightArr.length) {
    mergedArr.push(rightArr[j]);
    j++;
  }

  return mergedArr;
}

const unsortedArr = [5, 2, 9, 1, 5, 6];
const sortedArr = mergeSort(unsortedArr);

console.log(sortedArr); // Output: [1, 2, 5, 5, 6, 9]
