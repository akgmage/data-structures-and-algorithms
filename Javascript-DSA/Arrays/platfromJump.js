//! 24/01/2022

function platformJump(n, k) {
    if(n == 0) return 0;
    if(n == 1) return Math.abs(arr[1] - arr[0]);

    let ans = Number.MAX_SAFE_INTEGER;
    for(var i = 1; i <= k; i++) {
        if((n - i) >= 0) {
        ans = Math.min(ans, platformJump(n-i, k) + Math.abs(arr[n] - arr[n - i]));
        }
    }
    return ans;
}


// let arr = [1, 3, 4, 5, 2];
let arr = [40, 10, 20, 70, 80, 10, 20, 70, 80, 60];
let k = 4;

console.log(platformJump(arr.length-1, k));
console.log(Number.MAX_SAFE_INTEGER);
