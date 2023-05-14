/**
Heap Sort is a sorting algorithm that works by building a binary heap out of the input array and then repeatedly extracting the maximum element and restoring the heap property. The time complexity of Heap Sort is O(n log n) in the worst, average, and best cases, making it an efficient algorithm for sorting large data sets. The space complexity of the implementation is O(1) because the algorithm sorts the input array in place and does not use any additional data structures other than a few variables used for index tracking and swapping. Therefore, the space used by the algorithm does not depend on the size of the input array.
*/

/**
 * The heapSort function takes an array as input and returns a sorted array using the Heap Sort algorithm. The function first builds a max heap from the input array using the buildMaxHeap function. It then repeatedly extracts the maximum element from the heap and restores the heap property using the siftDown function
 * @param {Array} array The array to be sorted.
 * @returns {Array} The sorted array.
 * time complexity is O(n log n) because it calls buildMaxHeap function once and then the siftDown function n times in the worst case, where n is the length of the input array.
 */
 function heapSort(array) {
    // Build a max heap from the input array
    buildMaxHeap(array);
  
    // Extract the max element from the heap and restore the heap property
    for (let i = array.length - 1; i > 0; i--) {
      // Move the root element to the end of the array
      swap(array, 0, i);
  
      // Restore the heap property by sifting down the root element
      siftDown(array, 0, i);
    }
  
    return array;
  }
  
  /**
   * The buildMaxHeap function takes an array as input and transforms it into a max heap by calling siftDown on each non-leaf node in the tree.
   * @param {Array} array The array to be transformed into a max heap.
   * time complexity is O(n) because it calls the siftDown function on each non-leaf node in the tree
   */
  function buildMaxHeap(array) {
    const startIndex = Math.floor((array.length - 1) / 2);
  
    for (let i = startIndex; i >= 0; i--) {
      siftDown(array, i, array.length);
    }
  }
  
  /**
   * The siftDown function takes an array, an index, and an endIndex as input. It sifts down the element at the given index in the heap until it reaches its correct position.
   * @param {Array} array The array representing the heap.
   * @param {number} index The index of the element to be sifted down.
   * @param {number} endIndex The index at which to stop sifting down.
   * time complexity is O(log n) because it repeatedly swaps the element at the given index with its child elements until it reaches its correct position in the heap.
   */
  function siftDown(array, index, endIndex) {
    let childIndex1 = index * 2 + 1;
    while (childIndex1 < endIndex) {
      const childIndex2 = index * 2 + 2 < endIndex ? index * 2 + 2 : null;
      const swapIndex =
        childIndex2 !== null && array[childIndex2] > array[childIndex1]
          ? childIndex2
          : childIndex1;
  
      if (array[swapIndex] > array[index]) {
        swap(array, index, swapIndex);
        index = swapIndex;
        childIndex1 = index * 2 + 1;
      } else {
        return;
      }
    }
  }
  
  /**
   * The swap function takes an array and two indices as input and swaps the elements at those indices. It is used in the heapSort function to move the root element of the heap to the end of the array during each iteration of the main loop. This function is also used within the siftDown function to swap the parent element with its child element when restoring the heap property.
   * @param {Array} array The array containing the elements to be swapped.
   * @param {number} i The index of the first element.
   * @param {number} j The index of the second element.
   */
  function swap(array, i, j) {
    const temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
  