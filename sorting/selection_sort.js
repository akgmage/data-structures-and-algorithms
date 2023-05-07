/*
	Selection sort is a simple sorting algorithm that works by repeatedly finding the minimum element from an 
	unsorted part of the array and putting it at the beginning of the array. 
    
  In each iteration, the minimum element is found by comparing each element of the unsorted part of the array with the current minimum 
	element, and if a smaller element is found, it becomes the new minimum element. 
    
  Once the minimum element is found, it is swapped with the first element of the unsorted part of the array. 

	This process is repeated until the entire array is sorted. The main idea behind selection sort is to divide 
	the array into two parts: a sorted part and an unsorted part. 
    
  Initially, the sorted part is empty, and the unsorted part is the entire array. In each iteration, the minimum element is selected from 
	the unsorted part and added to the end of the sorted part.

	The time complexity of selection sort is O(n^2) in both the best and worst cases, where n is the number 
	of elements in the array. This is because for each element in the array, it needs to compare it with 
	every other element to find the smallest one, which takes O(n) time. Since this process needs to be 
	repeated for each element, the overall time complexity becomes O(n^2).

	The space complexity of selection sort is O(1) because it does not require any extra space other than 
	the input array itself. It performs the sorting in place by swapping the elements within the array.
*/
// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]
const inputArr = [4, 5, 67, 56, 3, 35, 45];
/**
 * Sorts an array using selection sort algorithm.
 * @param {number[]} array - The array to be sorted.
 * @returns {number[]} - The sorted array.
 */
function selectionSort(array) {
  // Loop through the array from the start to the second last element
  for (let i = 0; i < array.length - 1; i++) {
    // Assume that the current element is the minimum
    let minIndex = i;
    // Loop through the rest of the array to find the minimum element
    for (let j = i + 1; j < array.length; j++) {
      if (array[j] < array[minIndex]) {
        // If we find a smaller element, update the minimum index
        minIndex = j;
      }
    }
    // Swap the current element with the minimum element
    let temp = array[i];
    array[i] = array[minIndex];
    array[minIndex] = temp;
  }
  // Return the sorted array
  return array;
}

console.log(selectionSort(inputArr));
