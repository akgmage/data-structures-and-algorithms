/*
Bubble sort is a sorting algorithm that compares two adjacent elements 
and swaps them until they are in the intended order.
*/

const inputArr = [4,5,67,56,3,35,45];

const bubbleSort = (arr) => {
    let len = arr.length;

    //loop to access each array element
    for(let i = 0; i < len-1; i++)

      //loop to compare array elements
      for(let j = i+1; j < len; j++)

        //compare two adjacent elements
        if(arr[i] > arr[j])
        {
          //swapping elements if elements are not in the intended order
          let temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp

        }
    return arr;
}
bubbleSort(inputArr);
console.log(inputArr);