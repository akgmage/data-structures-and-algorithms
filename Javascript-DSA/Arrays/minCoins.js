//! 25/01/2022

let n = 3;
let x = 11;
let coins = [1, 5, 7];

function minCoins(n) {
    if(n == 0) return 0;

    let ans = Number.MAX_SAFE_INTEGER;
    
    for(let i = 0; i < coins.length; i++) {
        if( n < coins[i]) continue;
        ans = Math.min(ans, minCoins(n - coins[i]));
    }
    return 1 + ans;
}

console.log(minCoins(x));