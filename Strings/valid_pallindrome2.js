/**
 * Checks whether a string can be a valid palindrome by removing at most one character.
 * @param {string} s - The input string to check.
 * @return {boolean} - Returns true if the string can be a valid palindrome, false otherwise.
 */
function validPalindrome(s) {
  let left = 0; // Pointer to the left end of the string.
  let right = s.length - 1; // Pointer to the right end of the string.

  while (left < right) {
    if (s[left] !== s[right]) {
      // If characters at left and right indices are not equal.
      // Check if string without left index is a palindrome.
      let str1 = s.slice(0, left) + s.slice(left + 1);
      if (isPalindrome(str1)) {
        return true;
      }
      // Check if string without right index is a palindrome.
      let str2 = s.slice(0, right) + s.slice(right + 1);
      if (isPalindrome(str2)) {
        return true;
      }
      // If string without left or right index is not a palindrome, return false.
      return false;
    }
    // Move pointers inward if characters at left and right indices are equal.
    left++;
    right--;
  }

  // If we get here, the string is already a palindrome, or it can be made into one
  // by removing at most one character, so return true.
  return true;
}

/**
 * Checks whether a string is a palindrome.
 * @param {string} s - The input string to check.
 * @return {boolean} - Returns true if the string is a palindrome, false otherwise.
 */
function isPalindrome(s) {
  let left = 0; // Pointer to the left end of the string.
  let right = s.length - 1; // Pointer to the right end of the string.

  while (left < right) {
    if (s[left] !== s[right]) {
      // If characters at left and right indices are not equal, return false.
      return false;
    }
    // Move pointers inward if characters at left and right indices are equal.
    left++;
    right--;
  }

  // If we get here, the string is a palindrome, so return true.
  return true;
}
