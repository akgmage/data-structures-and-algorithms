const inputArr = [4,5,67,56,3,35,45];

const bubbleSort = (arr) => {
    let len = arr.length;
    for(let i = 0; i < len-1; i++)
      for(let j = i+1; j < len; j++)
        if(arr[i] > arr[j])
        {
          let temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp

        }
    return arr;
}
bubbleSort(inputArr);
console.log(inputArr);