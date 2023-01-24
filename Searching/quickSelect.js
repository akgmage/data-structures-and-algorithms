//! https://leetcode.com/problems/kth-largest-element-in-an-array/

//! aka kth-largest-element-in-an-array

//! Best: O(n) time | O(1) space
//! Average: O(n) time | O(1) space
//! Worst: O(n^2) time | O(1) space

function quickSelect(array, k) {
    const position = k - 1;
    return quickSelectHelper(array, 0, array.length - 1, position);
}

function quickSelectHelper(array, startIdx, endIdx, position) {

    while (true) {
        if (startIdx > endIdx) {
            throw new Error('Algorithm should never arrive here!');
        }
        let i = startIdx;
        let pivot = array[i];
        for (let j = i + 1; j <= endIdx; j++) {
            if (array[j] < pivot) {
                i++;
                swap(i, j, array);
            }
        }
        swap(startIdx, i, array);
        if (i == position) {
            return array[position];
        } else if (i < position) {
            startIdx = i + 1;
        } else {
            endIdx = i - 1;
        }
    }
}
function swap(i, j, array) {
    [array[i], array[j]] = [array[j], array[i]];
}

const array = [8, 5, 2, 9, 7, 6, 3];
const k = 3

console.log(quickSelect(array, k));