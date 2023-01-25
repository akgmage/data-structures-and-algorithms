function palindrome(i, n, str) {
    if(i >= n / 2) return true;
    
    if(str[i] !== str[n - i - 1]) return false;

    return palindrome(i + 1, n, str);
}

const str = 'maadam';
console.log(palindrome(0, str.length, str));