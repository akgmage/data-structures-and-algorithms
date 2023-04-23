/**
 * Checks if a given string is a palindrome.
 * @param {string} str - The input string to check.
 * @returns {boolean} True if the string is a palindrome, false otherwise.
 */
function isPalindrome(str) {
  // Convert the input string to lowercase and remove any non-alphanumeric characters
  str = str.toLowerCase().replace(/[^a-z0-9]/g, "");

  // Use two pointers to compare characters from the start and end of the string
  let left = 0;
  let right = str.length - 1;
  while (left < right) {
    if (str[left] !== str[right]) {
      return false;
    }
    left++;
    right--;
  }
  return true;
}
