//! https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//! FAANG

function searchForRange(array, target) {
    const finalRange = [-1, -1];
    alteredBinarySearch(array, target, 0, array.length - 1, finalRange, true);
    alteredBinarySearch(array, target, 0, array.length - 1, finalRange, false);
    return finalRange;
}

//! O(logn) time | O(1) space
function alteredBinarySearch(array, target, left, right, finalRange, goLeft) {

    while(left <= right) {

        const mid = Math.floor( (left + right) / 2);
    
        if(target < array[mid]) {
            right = mid - 1;
        } else if(target > array[mid]) {
            left = mid + 1;
        } else {
            if(goLeft) {
                if(mid == 0 || array[mid - 1] != target) {
                    finalRange[0] = mid;
                    return;
                } else {
                    right = mid -1;
                }
            } else {
                if(mid == array.length - 1 || array[mid + 1] != target) {
                    finalRange[1] = mid;
                    return;
                } else {
                    left = mid + 1;
                }
            }
        }
    }
}

//! O(logn) time | O(logn) space
function alteredBinarySearch(array, target, left, right, finalRange, goLeft) {
    if(left > right) return;

    const mid = Math.floor( (left + right) / 2);

    if(target < array[mid]) {
        alteredBinarySearch(array, target, left, mid - 1, finalRange, goLeft);
    } else if(target > array[mid]) {
        alteredBinarySearch(array, target, mid + 1, right, finalRange, goLeft);
    } else {
        if(goLeft) {
            if(mid == 0 || array[mid - 1] != target) {
                finalRange[0] = mid;
                return;
            } else {
                alteredBinarySearch(array, target, left, mid - 1, finalRange, goLeft);
            }
        } else {
            if(mid == array.length - 1 || array[mid + 1] != target) {
                finalRange[1] = mid;
                return;
            } else {
                alteredBinarySearch(array, target, mid + 1, right, finalRange, goLeft);
            }
        }
    }
}


function searchForRange(array, target) {
    return searchForRangeHelper(array, target, 0, array.length - 1);
}

function searchForRangeHelper(array, target, left, right) {

    while(left <= right) {
        const middle = Math.floor( (left + right) / 2);
        const potentialMatch = array[middle];
        
        if(target == potentialMatch) {
            const startIdx = linearSearch(array, target, 0, middle);
            const endIdx = findLastIdx(array, target, middle + 1, right);
            return [startIdx, endIdx];
        } else if(target < potentialMatch) {
            right = middle - 1;
        } else if(target > potentialMatch) {
            left = middle + 1;
        } 
    } return [-1, -1];
}

function linearSearch(array, target, left, right) {
    for(let i = 0; i <= right; i++) {
        if(array[i] == target) {
            return i;
        }
    }
}

function findLastIdx(array, target, left, right) {
    let idx;
    for(let i = left; i <= right; i++) {
        if(array[i] == target) {
            idx = i;
        }
    }
    return idx;
}

let array = [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73];
const target = 45;

console.log(searchForRange(array, target));