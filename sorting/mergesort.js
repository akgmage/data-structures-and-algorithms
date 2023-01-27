/*
Merge Sort is  based on the principle of Divide and Conquer Algorithm.
Here, a problem is divided into multiple sub-problems. 
Each sub-problem is solved individually. Finally, sub-problems are combined to form the final solution.

 */
const inputArr=[56, 8, 9, 23 ,67, 98,1];

//merge helper function
const merge = (left,right) => {

    //A dummy array to store sorted values
    let tempArr = [];

    while( left.length && right.length ){
        //comparing values from both array and pusing the samller one into dummy array

        if(left[0] < right[0]) {
            tempArr.push(left.shift());
        }
        else{
            tempArr.push(right.shift());
        }

    }
    /*
    merge([2, 3, 4] , [4 , 5, 6 ]);
    =[ 2 ,3, 4 , 4, 5, 6]
     */
    return [...tempArr, ...left, ...right]; 

}

const  mergeSort = (inputArr) => {
    //base case if array lentgh is 1 return whole array
    if (inputArr.length <= 1){ 
        return inputArr;
    }
    //finding mid of array
    let mid = Math.floor(inputArr.length / 2);

    //diving array into two parts left and right
    let left = mergeSort(inputArr.slice(0, mid));
    let right = mergeSort(inputArr.slice(mid));
    return merge(left, right);

  }

console.log(mergeSort(inputArr));