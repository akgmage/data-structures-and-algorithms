//! worst-case: O(n^2) time | O(1) space
//! avg-case: O(n^2) time | O(1) space
//! best-case: O(n^2) time | O(1) space

function selectionSort(array) {
    let startIdx = 0;
    while(startIdx < array.length - 1) {
        let smallestIdx = startIdx;
        for(let i = startIdx + 1; i < array.length; i++) {
            if(array[smallestIdx] > array[i]) smallestIdx = i;
        }
        swap(startIdx, smallestIdx, array);
        startIdx++;
    }
    return array;
}

function swap(i, j, array) {
    [array[i], array[j]] = [array[j], array[i]];
}

let array =  [8, -6, 7, 10, 8, -1, 6, 2, 4, -5, 1, 10, 8, -10, -9, -10, 8, 9, -2, 7, -2, 4];
console.log(selectionSort(array));