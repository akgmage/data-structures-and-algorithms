//! 04/03/2022
//! O(n) time | O(1) space

function downheapify(arr, idx) {
    let largestIdx = idx;
        while(idx < arr.length) {
            let lc = 2 * idx + 1;
            let rc = 2 * idx + 2;
            if(lc < arr.length && arr[lc] > arr[largestIdx]){
            largestIdx = lc;
            }
            if(rc < arr.length && arr[rc] > arr[largestIdx]) {
                largestIdx = rc;
            }
            if(largestIdx == idx) break;
            let temp = arr[idx];
            arr[idx] = arr[largestIdx];
            arr[largestIdx] = temp;
            idx = largestIdx;
    }
}

function buildHeap(arr) {
    for(let i = arr.length - 1; i >= 0; i--) {
        downheapify(arr, i);
    }
    return arr;
}

let arr = [7, 9, 1, 3, 10, -2, 6, 5];
console.log(buildHeap(arr));