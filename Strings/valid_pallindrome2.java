// Check whether a string can be a valid palindrome by removing at most one character from it
/*
   The given Go program takes a string as input and checks if it can be a valid palindrome by removing at most one
   character from it. The program starts by defining two pointers, left and right, that move towards each other from
   opposite ends of the input string. At each step, if the characters at the left and right pointers are equal,
   then they move towards the center of the string. If the characters are not equal, then we check whether removing
   the character at the left or right pointer would make the rest of the string a palindrome. If both removals fail,
   then the string cannot be a valid palindrome by removing at most one character. The program returns true
   if the string can be made a valid palindrome by removing at most one character, false otherwise.

  The time complexity of this algorithm is O(n), where n is the length of the input string.
  The space complexity is O(1), as we only use constant extra space to store a few variables.

*/
public static boolean isPalindromeWithRemoval(String s) {
  // Define two pointers to check the string from both ends
  int i = 0, j = s.length() - 1;

  while (i < j) {
    // If characters at the pointers are not equal
    if (s.charAt(i) != s.charAt(j)) {
      // Check if removing a character from the left pointer makes it a palindrome
      String leftStr = s.substring(0, i) + s.substring(i + 1);
      if (isPalindrome(leftStr)) {
        return true;
      }
      // Check if removing a character from the right pointer makes it a palindrome
      String rightStr = s.substring(0, j) + s.substring(j + 1);
      if (isPalindrome(rightStr)) {
        return true;
      }
      // If neither option works, it cannot be converted into a palindrome by removing at most one character
      return false;
    }
    // Move the pointers towards the middle of the string
    i++;
    j--;
  }
  return true;
}

public static boolean isPalindrome(String s) {
  // Define two pointers to check the string from both ends
  int i = 0, j = s.length() - 1;

  while (i < j) {
    // If characters at the pointers are not equal, it is not a palindrome
    if (s.charAt(i) != s.charAt(j)) {
      return false;
    }
    // Move the pointers towards the middle of the string
    i++;
    j--;
  }
  return true;
}
