const inputArr = [4,5,67,56,3,35,45];

const insertionSort= (arr) => {
    for (let i = 1; i < arr.length; i++) {
      let currentValue = arr[i];
      const j = 0;
      for (let j = i - 1; j >= 0 && arr[j] > currentValue; j--) {
        arr[j + 1] = arr[j];
      }
      arr[j + 1] = currentValue;
    }
    return arr;
  }
  console.log(insertionSort(inputArr));
  