//selectionsort

const inputArr = [4,5,67,56,3,35,45];

const selectionSort= (inputArr)  =>{ 
    let n = inputArr.length;
        
    for(let i = 0; i < n; i++) {
        //finding smallest element in the array
        let min= i;
        for(let j= i+1; j< n; j++){
            if(inputArr[j] < inputArr[min]) {
                min=j; 
            }
         }
         if (min!= i) {
             // swaping elements
             let temp= inputArr[i]; 
             inputArr[i] = inputArr[min];
             inputArr[min] = temp;      
        }
    }
    return inputArr;
}

console.log(selectionSort(inputArr));