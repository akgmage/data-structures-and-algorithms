//? https://www.algoexpert.io/questions/Three%20Number%20Sum
//! O(n^2) | space O(n)
function threeNumberSum(array, targetSum) {
    array.sort( (a, b) => a - b);
    const triplets = [];

    for (let i = 0; i < array.length - 2; i++) {
        let left = i + 1;
        let right = array.length - 1;
        while (left < right) {
            const currentSum = array[i] + array[left] + array[right];

            if (currentSum === targetSum) {
                triplets.push([array[i], array[left], array[right]]);
                left++; right--;
            }
            else if (currentSum < targetSum) {
                    left++;
            }
            else if (currentSum > targetSum) {
                right--;
            }
        }
    }
    return triplets;
}

console.log(threeNumberSum(array, targetSum));

let array = [1, 4, 4, 5, 5, 5, 6, 6 ,11];
array.sort( (a, b) => a - b)
let targetSum = 10;
let result = [];


/** 
//! O(n^3) | space O(n)

for(let i = 0; i <= array.length - 1; i++) {
    let a = array[i];   
    for(let j = i + 1; j <= array.length - 2; j++) {
        let b = array[j];
        for(let k = j + 1; k <= array.length - 1; k++) {
            let c = array[k];
            let d = a + b + c;
            if(d === targetSum) {
                result.push([a, b, c]); 
            }
        }
    }
}

for(let i = 0; i < result.length; i++) {
    result[i].sort( (a, b) => a - b);
}

console.log(result);

*/