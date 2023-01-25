function longest_palindrome_prefix(str) {
    str = str + "$" + str.split("").reverse().join("");
    console.log(str);
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
         return Math.max(...lps);
}
console.log(longest_palindrome_prefix("aabbc"));