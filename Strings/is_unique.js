/*
    Implement an algorithm to determine if a string has all unique characters.
    what if you cannot use additional data structures?

    Explanation:
    
    1. The `isUniqueUsingBitVector` function takes a string `s` as input and returns a boolean value indicating whether the string has all unique characters.
    2. The variable `checker` is initialized as 0, representing the bit vector to keep track of character occurrences.
    3. The function iterates over each character in the string using a for loop.
    4. For each character, the variable `val` is computed by subtracting the ASCII value of `'a'` from the ASCII value of the character. This calculates the corresponding index (0-25) for lowercase alphabetic characters.
    5. The program checks if the bit at position `val` in the `checker` is already set. If it is, it means the character has occurred before, and the function returns `false`.
    6. If the character is unique, the bit at position `val` in the `checker` is set by performing a bitwise OR operation with `(1 << val)`. This marks the occurrence of the character in the bit vector.
    7. After iterating through all the characters, if no duplicate characters are found, the function returns `true`.
    8. In the test cases section, a few sample strings (`s`, `t`, `u`, and `"aa"`) are provided, and the result of calling `isUniqueUsingBitVector` with each test case is printed using `console.log()`.
*/

function isUniqueUsingBitVector(s) {
  let checker = 0; // Bit vector to keep track of character occurrences

  for (let i = 0; i < s.length; i++) {
    const val = s.charCodeAt(i) - "a".charCodeAt(0); // Convert character to corresponding index (0-25)

    if ((checker & (1 << val)) > 0) {
      // If the bit corresponding to the character is already set, it means the character has occurred before
      return false;
    }

    checker |= 1 << val; // Set the bit corresponding to the character to mark its occurrence
  }

  return true;
}

// Test cases
const s = "ABCDD";
const t = "ABCD";
const u = "AAAAAABCD";

console.log(isUniqueUsingBitVector(s)); // false, 'D' appears more than once
console.log(isUniqueUsingBitVector(t)); // true, all characters are unique
console.log(isUniqueUsingBitVector(u)); // false, 'A' appears more than once

console.log(isUniqueUsingBitVector("aa")); // false, 'a' appears more than once
