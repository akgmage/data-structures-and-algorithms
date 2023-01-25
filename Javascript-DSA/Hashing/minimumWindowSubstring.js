//! https://leetcode.com/problems/minimum-window-substring/
//! https://www.algoexpert.io/questions/Smallest%20Substring%20Containing

function minWindow(s, t) {
    let freq = new Array(256).fill(0);
    let ans = Number.MAX_SAFE_INTEGER;
    for(let i = 0; i < t.length; i++) {
        freq[t[i].charCodeAt(0)]++;
    }
    let i = 0, j = 0;
    let t_length = t.length;
    while(j < s.length) {
        freq[s[j].charCodeAt(0)]--;
       
    }
}


