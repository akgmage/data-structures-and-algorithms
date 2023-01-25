//! https://www.algoexpert.io/questions/Same%20BSTs
//! O(n^2) time | O(n^2) space

function sameBsts(arrayOne, arrayTwo) {

    if(arrayOne.length != arrayTwo.length) return false;

    if(arrayOne.length == 0 && arrayTwo.length == 0) return true;

    if(arrayOne[0] != arrayTwo[0]) return false;

    const leftOne = getSmaller(arrayOne);
    const leftTwo = getSmaller(arrayTwo);

    const rightOne = getBigger(arrayOne);
    const rightTwo = getBigger(arrayTwo);

    return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);

    
}

function getSmaller(array) {
    const smaller = [];
    
    for(let i = 1; i < array.length; i++) {
        if(array[i] < array[0]) smaller.push(array[i]);
    }
    return smaller;
}

function getBigger(array) {
    const bigger = []; 

    for(let i = 1; i < array.length; i++) {
        if(array[i] >= array[0]) bigger.push(array[i]);
    }
    return bigger;
}