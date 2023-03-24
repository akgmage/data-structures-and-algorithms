// Implementation of Bubble sort.
// Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm
// that repeatedly steps through the input list element by element,
// comparing the current element with the one after it, swapping their values if needed.
//  These passes through the list are repeated until no swaps had to be performed during a pass,
// meaning that the list has become fully sorted. (Source wiki) https://en.wikipedia.org/wiki/Bubble_sort

// Time Complexity worst-case and average complexity O(n^{2})
// Bubble sort is O(n) on a list that is already sorted i.e. Best case

// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]

const inputArr = [4, 5, 67, 56, 3, 35, 45];

const bubbleSort = (arr) => {
  let len = arr.length;

  //loop to access each array element
  for (let i = 0; i < len - 1; i++)
    //loop to compare array elements
    for (let j = i + 1; j < len; j++)
      //compare two adjacent elements
      if (arr[i] > arr[j]) {
        //swapping elements if elements are not in the intended order
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
  return arr;
};
bubbleSort(inputArr);
console.log(inputArr);
