//! 24/01/2022

function checkPalindrome(str, i, j) {
     if(str[i] == str[j]) {
         console.log(str[i],'--', str[j]);
         if(i == j || i + 1 == j) return true;
         return checkPalindrome(str, i+1, j-1);
     }
         return false;
}

let str = 'ABBBBBBAABBBBBBA';
let i = 0;
let j = str.length - 1 ;

console.log(checkPalindrome(str, i, j));