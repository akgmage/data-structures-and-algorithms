// Approach: In case of symbols like IV, CM, XC, etc., the first value is less than the second value.
// So we have to subtract the first value from the second value to get the exact value.
// Example: CM --> C=100, M=1000, so CM=1000-100=900.
// Therefore, we can conclude that in such cases, we have to subtract the first value from the whole result.
// Time complexity O(1) and Space complexity O(1).
var romanToInt = function(s) {
    let map = new Map(); // Create a hashmap to store (symbol, value) pairs.
    map['I'] = 1;
    map['V'] = 5;
    map['X'] = 10;
    map['L'] = 50;
    map['C'] = 100;
    map['D'] = 500;
    map['M'] = 1000;

    let arr = [];
    for (let i = 0; i < s.length; i++) { // Store the value of each symbol in arr from left to right.
        arr[i] = map[s.charAt(i)];
    }
    
    let ans = 0;
    for (let i = 0; i < arr.length - 1; i++) { // Traverse from 0 to last-1.
        // If the i-th element is less than the i+1-th element, then subtract the i-th element.
        if (arr[i] < arr[i + 1]) {
            ans = ans - arr[i];
        }
        // Otherwise, add the i-th element.
        else {
            ans = ans + arr[i];
        }
    }
    // Add the last element because there is no further element to compare.
    ans = ans + arr[arr.length - 1];
    return ans;
};
