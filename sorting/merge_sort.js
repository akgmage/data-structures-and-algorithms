// In computer science, merge sort (also commonly spelled as mergesort) is an efficient, general-purpose,
// and comparison-based sorting algorithm. Most implementations produce a stable sort,
// which means that the order of equal elements is the same in the input and output.
// Merge sort is a divide-and-conquer algorithm that was invented by John von Neumann in 1945.
// A detailed description and analysis of bottom-up merge sort appeared in a report by Goldstine and von Neumann as early as 1948.
// Conceptually, a merge sort works as follows:

// Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
// Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list
// Source(https://en.wikipedia.org/wiki/Merge_sort)

// Approach: Divide by finding the number mid of the position midway between left and right. Do this step the same
// way we found the midpoint in binary search
// Conquer by recursively sorting the subarrays in each of the two subproblems created by the divide step.
// That is, recursively sort the subarray Arr[left. . mid] and recursively sort the subarray Arr[mid + 1. . right].
// Combine by merging the two sorted subarrays back into the single sorted subarray Arr[left. . right].

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
