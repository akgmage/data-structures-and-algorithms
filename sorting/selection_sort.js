/* 
Selection sort is a sorting algorithm that selects the smallest element from an unsorted list in each iteration
 and places that element at the beginning of the unsorted list.
*/

const inputArr = [4,5,67,56,3,35,45];

const selectionSort= (inputArr)  => { 
    let n = inputArr.length;
    
    //loop to access each array element 
    for(let i = 0; i < n; i++) {

        //assuming first array element as current minimum
        let min= i;

        //loop to compare current minimum element to other array element
        for(let j= i+1; j< n; j++){

            //comparing and updating cureent minimum element
            if(inputArr[j] < inputArr[min]) {
                min=j; 
            }
         }

         //swapping array elements if current minimum changes
         if (min!= i) {
             let temp= inputArr[i]; 
             inputArr[i] = inputArr[min];
             inputArr[min] = temp;      
        }
    }
    return inputArr;
}

console.log(selectionSort(inputArr));