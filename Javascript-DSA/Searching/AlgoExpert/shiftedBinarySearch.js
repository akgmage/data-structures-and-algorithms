function shiftedBinarySearch(array, target) {
    return shiftedBinarySearchHelper(array, target, 0, array.length - 1);
}

//! O(logn) time | O(1) space
function shiftedBinarySearchHelper(array, target, left, right) {

    while(left <= right) {
        const middle = Math.floor((left + right) / 2);
        const potentialMatch = array[middle];
        const leftNum = array[left];
        const rightNum = array[right];
        
        if(target == potentialMatch) return middle;
        else if(leftNum <= potentialMatch) {
            if(target < potentialMatch && target >= leftNum) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        } else {
            if(target > potentialMatch && target <= rightNum) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
    } return -1;
}

//! O(logn) time | O(logn) space
function shiftedBinarySearchHelper(array, target, left, right) {
    if(left > right) return -1;

    const middle = Math.floor((left + right) / 2);
    const potentialMatch = array[middle];
    const leftNum = array[left];
    const rightNum = array[right];

    if(target == potentialMatch) return middle;
    else if(leftNum <= potentialMatch) {
        if(target < potentialMatch && target >= leftNum) {
            return shiftedBinarySearchHelper(array, target, left, middle - 1);
        } return shiftedBinarySearchHelper(array, target, middle + 1, right);
    } else {
        if(target > potentialMatch && target <= rightNum) {
            return shiftedBinarySearchHelper(array, target, middle + 1, right);
        }
        return shiftedBinarySearchHelper(array, target, left, middle - 1);
    }
}

//! O(n) time | O(1) space

function shiftedBinarySearch(array, target) {
  
    let idx;
    for(let i = 0; i < array.length - 1; i++)  {
        if(array[i] > array[i + 1]) {
            idx = i;
            break;
        }
    }
    let isFound  = binarySearch(array, target, 0, idx);

    if(isFound != -1) {
        return isFound;
    }
     return binarySearch(array, target, idx + 1, array.length - 1);
  
}

function binarySearch(array, target, left, right) {

    while(left <= right) {
        const middle = Math.floor((left + right) / 2);
        const potentialMatch = array[middle];
        console.log(potentialMatch);
        if(target == potentialMatch) {
            return middle;
        } else if(target < potentialMatch) {
            right = middle - 1;
        } else if (target > potentialMatch) {
            left = middle + 1;
        }
    }
    return -1;
}

let array = [45, 61, 72, 72, 73, 0, 1, 21, 33, 37];
const target = 33;

console.log(shiftedBinarySearch(array, target));