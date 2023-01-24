//!25/02/2022

function minChForPalindrome(s) {
    let n = s.length;
    let p = 31;
    let m = 1000000007;
    let h1 = 0;
    let h2 = 0;
    let pow = 1;
    let ans = -1;
    for(let i = 0; i < n; i++, pow = pow*p%m) {
        h1 = (h1*p + s.charCodeAt(i))%m;
        // console.log(h1);
        h2 = (h2 + (s.charCodeAt(i))*pow)%m;
        // console.log(h2);
        if(h1 == h2) ans = i;
    }
    return n - ans - 1;
}

console.log(minChForPalindrome("abac"));

