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

func validate(s string, left int, right int) bool {
  for left < right {
	// doesn't match then return false
    if s[left] != s[right] {
      return false
    } else {
      left += 1
      right -= 1
    }
  }
  return true
}

func validPalindrome(s string) bool {
	// initialize two pointers at opposite end of string
    left := 0
    right := len(s) - 1
    for left < right {
	  // if value at left and right index match then move them closer
      if s[left] == s[right] {
        left += 1
        right -= 1
      } else { // if mismatch occurs then skip one and check rest
        skipLeft := validate(s, left + 1, right) // skip one from left and check remaining
        skipRight := validate(s, left, right - 1) // skip one from right and check remaining
        return skipLeft || skipRight // if either is true return true
      }
    }
    return true
}