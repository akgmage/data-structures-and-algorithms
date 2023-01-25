//! Given a sorted Array and a element x, find the first element
//! element in the array that less than x.

function lowerBound(array, target) {
    let l = 0;
    let r = array.length - 1;
    let ans = -1;
    while(l <= r) {
        let mid = Math.floor( (l + r) / 2);
        if(array[mid] >= target) {
            ans = mid;
            r = mid - 1;
        } else l = mid + 1;
    }
    if(ans == -1) return NaN;   //! if every element < target
    return ans;
} 

let array = [1, 2, 2, 3, 3, 4, 6, 7];
let target = 6;


