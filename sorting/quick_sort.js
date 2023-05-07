/*
    The quickSort function implements the quicksort algorithm, which takes an array arr and the indices low and high 
    of the subarray to be sorted. If low is less than high, the array is partitioned around a pivot element using the 
    partition function, and the subarrays on either side of the pivot are recursively sorted using the quickSort function.

    The partition function takes an array arr and the indices low and high of the subarray to be partitioned. 
    It chooses the rightmost element as the pivot, initializes the index of the smaller element to low - 1, and 
    iterates over the subarray. If an element arr[j] is less than the pivot, it is swapped with the element arr[i+1] 
    and the index i is incremented. Finally, the pivot element is swapped with the element arr[i+1], 
    and the index i+1 is returned as the index of the pivot.

    The time complexity of quicksort is O(n log n) on average, and O(n^2) in the worst case. The space complexity 
    is O(log n) on average, and O(n) in the worst case.
*/
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
