//! worst-case: O(n^2) time | O(1) space
//! avg-case: O(n^2) time | O(1) space
//! best-case: O(n) time | O(1) space

function bubbleSort(array) {
    let isSorted = false;
    let counter = 0;
    while(!isSorted) {
        isSorted = true;
        for(let i = 0; i < array.length - 1 - counter; i++) {
            if(array[i] > array[i + 1]) {
                swap(i, i + 1, array);
                isSorted = false;
            }
        }
        counter++;
    }
    return array;
}
function swap(i, j, array) {
    [array[i], array[j]] = [array[j], array[i]];
}


let array =  [8, -6, 7, 10, 8, -1, 6, 2, 4, -5, 1, 10, 8, -10, -9, -10, 8, 9, -2, 7, -2, 4];
console.log(bubbleSort(array));