/*
    Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.

    Constraints: string.length The string only consists of English letters

    Sample Input : "madame"
    Output : True

    Sample Input : "masdasd"
    Output : False	
*/

// using two-pointer Technique
function validPalindrome(s) {
    let left = 0;
    let right = s.length - 1;

    while (left < right) {
        if (s[left] !== s[right]) {
        // to check if deleting  from either left or right char. would create a palindrome
        return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
        }
        left++;
        right--;
    }

    return true;
    }

function isPalindrome(s, left, right) {
    while (left < right) {
        if (s[left] !== s[right]) {
        return false;
        }
        left++;
        right--;
    }
    return true;
}

console.log(validPalindrome("aba")); // true
console.log(validPalindrome("abca")); // true
console.log(validPalindrome("abc")); // false