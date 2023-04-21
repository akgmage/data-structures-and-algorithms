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
