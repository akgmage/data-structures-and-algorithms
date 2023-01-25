//! Reddy sir approach

// function binarySearch(array, i, j, x) {
//         if(i == j) {
//             if(array[i] == x) return i;
//             else return -1;
//         }
//         else {
//             let mid = Math.floor((i + j) / 2);
//             if(x == array[mid]) return mid;
//             else if(x < array[mid]) 
//             return binarySearch(array, i, mid - 1, x);
//             else return binarySearch(array, mid + 1, j, x); 
//         }     
// }

function binarySearch(array, i, j, x) {
    while(i <= j) {
        if(i == j) {
            if(x == array[i]) return i;
            else return -1;
        }
        else {
            let mid = Math.floor((i + j) / 2);
            if(x == array[mid]) return mid;
            else if(x < array[mid]) j = mid - 1;
            else i = mid + 1;
        }
    }
}

// let array = [1, 2, 5, 7, 13, 15, 16, 18, 24, 28, 29];
let array = [2, 3, 3, 4, 4, 4, 5, 6, 8];
let target = 8;

console.log(binarySearch(array, 0, array.length - 1, target));


/**
 * ! modified mid formula
 *! (low + high + low - low) / 2
 *? (2low + high - low) / 2
 *? (low + ((high - low) / 2))
 */