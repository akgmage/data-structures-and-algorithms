/* 
Merge sort is a sorting algorithm that takes a list and divides the list into two smaller lists recursively until we are down to the pairs of arrays containing individual elements. 

At that point, the pairs are compared and are *merged* back together to form a sorted list, recursively popping off the stack until we're back to our final sorted array. 
*/

const inputArr = [4, 5, 67, 56, 3, 35, 45];

function mergeSort(arr) {

  if (arr.length > 1) {

    // splitting the list into two smaller lists
    const mid = Math.floor(arr.length / 2);
    const left = arr.slice(0, mid);
    const right = arr.slice(mid);

    // recurses over the two smaller lists
    mergeSort(left);
    mergeSort(right);

    // define counters for our left, right and arr arrays
    let i = 0;
    let j = 0;
    let k = 0;

    // compares elements in left and right arrays
    // and places them back in arr from least to greatest
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i = i + 1;
      } else {
        arr[k] = right[j];
        j = j + 1;
      }
      k = k + 1;
    }

    // if there are any elements remaining in our left array, put them in our arr array
    while (i < left.length) {
      arr[k] = left[i];
      i = i + 1;
      k = k + 1;
    }

    // if there are any elements remaining in our right array, put them in our arr array
    while (j < right.length) {
      arr[k] = right[j];
      j = j + 1;
      k = k + 1;
    }
  }

  return arr;
}

mergeSort(inputArr);
console.log(inputArr);