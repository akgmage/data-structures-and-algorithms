// Check whether a string can be a valid palindrome by removing at most one character from it
/*
   Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.

   Constraints: string.length The string only consists of English letters

   Sample Input : "madame"
   Output : True

   Sample Input : "masdasd"
   Output : False
*/
package main

// isPalindromeWithRemoval checks if a string can be converted into a palindrome
// by removing at most one character
func isPalindromeWithRemoval(s string) bool {
  // Define two pointers to check the string from both ends
  i, j := 0, len(s)-1
  
  for i < j {
      // If characters at the pointers are not equal
      if s[i] != s[j] {
          // Check if removing a character from the left pointer makes it a palindrome
          leftStr := s[:i] + s[i+1:j+1]
          if isPalindrome(leftStr) {
              return true
          }
          // Check if removing a character from the right pointer makes it a palindrome
          rightStr := s[:i] + s[i:j]
          if isPalindrome(rightStr) {
              return true
          }
          // If neither option works, it cannot be converted into a palindrome by removing at most one character
          return false
      }
      // Move the pointers towards the middle of the string
      i++
      j--
  }
  return true
}

// isPalindrome checks if a string is a palindrome
func isPalindrome(s string) bool {
  // Define two pointers to check the string from both ends
  i, j := 0, len(s)-1
  
  for i < j {
      // If characters at the pointers are not equal, it is not a palindrome
      if s[i] != s[j] {
          return false
      }
      // Move the pointers towards the middle of the string
      i++
      j--
  }
  return true
}
