/*
    Write a function that takes in a non-empty string and that returns a boolean
    representing whether the string is a palindrome.
    Sample Input: abba
    Output: True
    Sample Input: aberba
    Output: False
    
    Explanation : 
    The function takes in a non-empty string as input and returns a boolean value indicating whether the string 
    is a palindrome or not. It first converts the input string to lowercase and removes any non-alphanumeric 
    characters using a regular expression. It then uses two pointers (one starting from the beginning of the 
    string and the other starting from the end) to compare characters from opposite ends of the string. 
    If any mismatch is found, the function returns false immediately. If the entire string is traversed 
    without finding any mismatches, the function returns true, indicating that the string is a palindrome.

    Note that this implementation treats uppercase and lowercase letters as equivalent (i.e., "A" is the same as "a") 
    and ignores any non-alphanumeric characters (such as spaces or punctuation marks) when checking for palindromicity.
*/
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
