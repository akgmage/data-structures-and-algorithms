/*
Implementation of insertion sort in JS.
Insertion sort is a simple sorting algorith that iterates through
the list starting at the second element. We compare each element
to the preceding elements, slide over the preceding larger (or smaller)
elements, and insert the original element into the empty position.

Time Complexity worst-case and average complexity O(n^{2})

Insertion sort is inefficient for large arrays. However it is fast for
small arrays and typically more efficient than bubble sort and selection
sort due to not making as many comparisons on average.

Source: https://en.wikipedia.org/wiki/Insertion_sort

Sample input: [0, 2, 1,-1, 10, 3, 4]
Output: [-1 0 1 2 3 4 10]
*/

const inputArr = [4,5,67,56,3,35,45];

const insertionSort= (arr) => {

    //loop to access each array element
    for (let i = 1; i < arr.length; i++) {
      let currentValue = arr[i];
      const j = 0;
          
    // loop to Compare key with each element on the left of it until an element smaller than is found
    for (let j = i - 1; j >= 0 && arr[j] > currentValue; j--) {
        arr[j + 1] = arr[j];
      }
      // Place key at after the element just smaller than it.
      arr[j + 1] = currentValue;
    }
    return arr;
  }
  console.log(insertionSort(inputArr));
  