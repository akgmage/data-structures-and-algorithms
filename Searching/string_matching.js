//! brute force or Naive approach
//! time O((m - n + 1)*n) --> O(m*n) | space O(1)
function string_matching_naive(s, p) {
    let m = s.length;
    let n = p.length;
    for(let i = 0; i <= (m - n); i++) {
        let flag = true;
        for(let j = 0; j < n; j++) {
            if(s[i + j] != p[j]) {
                flag = false;
                break;
            }
        }
        if(flag) console.log(i);
    }
}

string_matching_naive("aabbabcbbaabcab", "abc");