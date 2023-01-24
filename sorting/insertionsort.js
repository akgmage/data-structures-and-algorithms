/* 
Insertion sort is a sorting algorithm that places an unsorted element 
at its suitable place in each iteration.
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
  