//! worst-case: O(n^2) time | O(1) space
//! avg-case: O(n^2) time | O(1) space
//! best-case: O(n) time | O(1) space

function insertionSort(array) {
    for(let i = 1; i < array.length; i++) {
        let j = i;
        while( j > 0 && array[j] < array[j - 1] ) {
            swap(j, j - 1, array);
            j -= 1;
        }
    }
    return array;
}

function swap(i, j, array) {
    [array[i], array[j]] = [array[j], array[i]];
}

let array =  [8, -6, 7, 10, 8, -1, 6, 2, 4, -5, 1, 10, 8, -10, -9, -10, 8, 9, -2, 7, -2, 4];

console.log(insertionSort(array));
 