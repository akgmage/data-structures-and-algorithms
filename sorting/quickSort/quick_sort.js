
//! best/avg case O(nlogn) time | O(logn) space
//! worst case O(n^2) time | O(n) space

function quickSort(array) {
    quickSortHelper(array, 0, array.length - 1);
    return array;
}

function quickSortHelper(array, startIdx, endIdx) {
    if(startIdx >= endIdx) return;
    else {
        let m = partition(array, startIdx, endIdx);
        quickSortHelper(array, startIdx, m - 1);
        quickSortHelper(array, m + 1, endIdx);
    }
}

function partition(array, leftIdx, rightIdx) {
    let i = leftIdx;
    let pivot = array[i];
    for(let j = i + 1; j <= rightIdx; j++) {
        if(array[j] < pivot) {
            i++;
            swap(i, j, array);
        }
    }
    swap(leftIdx, i, array);
    return i;
}

function swap(i, j, array) {
    [array[i], array[j]] = [array[j], array[i]];
}

const array = [8, 5, 2, 9, 5, 6, 3];

console.log(quickSort(array));