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
