//! O(m + n)

function longest_prefix_suffix(str) {
         let lps = [];
         lps[0] = 0;
         let len = 0;
         for(let i = 1; i < str.length;) {
             if(str[len] === str[i]) {
                len += 1;
                lps[i] = len;
                i+=1;
             } else {
                 if(len == 0) {
                     lps[i] = 0;
                     i += 1;
                 } else {
                     len = lps[len-1];
                 }
             }
         }
         return lps;
}
function knuth_morris_pratt(str, pattern) {
    let n = str.length;
    let m = pattern.length;
    let i = 0, j = 0;
    let lps = longest_prefix_suffix(pattern);
    while(i < n && j < m) {
        if(str[i] == pattern[j]) {
            i++;
            j++;
        } else {
            if(j == 0) i++;
            else j = lps[j - 1];
        }
    }
    if(j == m) return true;
    return false;
}
console.log(knuth_morris_pratt("aefoaefcdaefcdaed", "aefcdaed"));