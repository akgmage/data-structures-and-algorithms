// Implementation of selection sort.
// Selection sort is an in-place comparison sorting algorithm.
// It has an O(n^{2}) time complexity which makes it inefficient on large lists,
// and generally performs worse than the similar insertion sort.
// Selection sort is noted for its simplicity and has performance advantages
// over more complicated algorithms in certain situations,
// particularly where auxiliary memory is limited. (Source wiki) https://en.wikipedia.org/wiki/Selection_sort

// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]
const inputArr = [4, 5, 67, 56, 3, 35, 45];

const selectionSort = (inputArr) => {
  let n = inputArr.length;

  //loop to access each array element
  for (let i = 0; i < n; i++) {
    //assuming first array element as current minimum
    let min = i;

    //loop to compare current minimum element to other array element
    for (let j = i + 1; j < n; j++) {
      //comparing and updating cureent minimum element
      if (inputArr[j] < inputArr[min]) {
        min = j;
      }
    }

    //swapping array elements if current minimum changes
    if (min != i) {
      let temp = inputArr[i];
      inputArr[i] = inputArr[min];
      inputArr[min] = temp;
    }
  }
  return inputArr;
};

console.log(selectionSort(inputArr));
