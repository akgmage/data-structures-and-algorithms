//! https://leetcode.com/problems/maximum-subarray/submissions/
//! https://www.algoexpert.io/questions/kadane's-algorithm

console.time("runTime");
function kadanesAlgorithm(array) {
    let maxEndingHere = array[0];
    let maxSoFar = array[0];

    for(let i = 1; i < array.length; i++) {
        const num = array[i];
        maxEndingHere = Math.max(maxEndingHere + num, num);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
}

const array = [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4];

console.log(kadanesAlgorithm(array));

console.timeEnd("runTime");