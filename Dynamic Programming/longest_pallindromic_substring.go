/*
	Given a string s, return the longest palindromic substring in s.

	Example 1:
	Input: s = "babad"
	Output: "bab"
	Explanation: "aba" is also a valid answer.

	Example 2:
	Input: s = "cbbd"
	Output: "bb"


	Constraints:
	1 <= s.length <= 1000
	s consist of only digits and English letters.
*/
package main

import (
	"fmt"
)

// LongestPalindromicSubstring finds the length of the longest palindromic substring in a given string.
func LongestPalindromicSubstring(Array string) int {
	n := len(Array)

	// Create a 2D boolean array L to store whether substrings are palindromes.
	L := make([][]bool, n)
	for i := range L {
		L[i] = make([]bool, n) // Defaults to false
	}

	max := 1 // Initialize the maximum palindrome length to 1 (single characters are palindromes)

	// Initialize the base cases for substrings of length 1 and 2.
	for i := 0; i < n-1; i++ {
		L[i][i] = true // Single characters are palindromes
		if Array[i] == Array[i+1] {
			L[i][i+1] = true // Check for palindromes of length 2
			max = 2         // Update the maximum palindrome length
		}
	}

	// Check for palindromes of length 3 and greater.
	for k := 3; k <= n; k++ {
		for i := 0; i < n-k+1; i++ {
			j := i + k - 1

			// Check if the characters at the ends of the current substring match and if the substring inside is a palindrome.
			if Array[i] == Array[j] && L[i+1][j-1] {
				L[i][j] = true // Mark the current substring as a palindrome
				max = k        // Update the maximum palindrome length
			} else {
				L[i][j] = false // Mark the current substring as not a palindrome
			}
		}
	}

	return max // Return the length of the longest palindromic substring
}

func main() {
	// Example usage:
	fmt.Print(LongestPalindromicSubstring("babad"))
}
