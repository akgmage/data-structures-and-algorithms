/**
 * This function implements the quicksort algorithm to sort an array in place.
 * @param {Array} arr - The array to be sorted.
 * @param {number} low - The lower index of the subarray to be sorted.
 * @param {number} high - The higher index of the subarray to be sorted.
 * @returns {void}
 */
function quickSort(arr, low, high) {
  if (low < high) {
    // Partition the array around the pivot element and get the index of the pivot.
    const pivotIndex = partition(arr, low, high);

    // Recursively sort the subarrays on either side of the pivot.
    quickSort(arr, low, pivotIndex - 1);
    quickSort(arr, pivotIndex + 1, high);
  }
}

/**
 * This function partitions an array around a pivot element and returns the index of the pivot.
 * @param {Array} arr - The array to be partitioned.
 * @param {number} low - The lower index of the subarray to be partitioned.
 * @param {number} high - The higher index of the subarray to be partitioned.
 * @returns {number} - The index of the pivot element.
 */
function partition(arr, low, high) {
  // Choose the rightmost element as the pivot.
  const pivot = arr[high];

  // Initialize the index of the smaller element.
  let i = low - 1;

  // Iterate over the subarray and partition it.
  for (let j = low; j < high; j++) {
    if (arr[j] < pivot) {
      i++;

      // Swap arr[i] and arr[j].
      const temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  // Swap arr[i+1] and arr[high] (or the pivot).
  const temp = arr[i + 1];
  arr[i + 1] = arr[high];
  arr[high] = temp;

  // Return the index of the pivot.
  return i + 1;
}
