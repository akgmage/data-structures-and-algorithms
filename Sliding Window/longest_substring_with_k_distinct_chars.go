/*
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.

 */
package main

import (
	"fmt"
)

func longestSubstringWithKDistinctChars(s string, k int) int {
	// Check for edge cases where s is empty, or k is 0.
	if len(s) == 0 || k == 0 {
		return 0
	}

	startWindow := 0      // Initialize the start of the sliding window.
	maxLen := 0           // Initialize the maximum length of the substring.
	charCount := make(map[byte]int) // Create a map to store character frequencies.

	for endWindow := 0; endWindow < len(s); endWindow++ {
		right := s[endWindow] // Get the character at the end of the window.
		charCount[right]++   // Update the character count in the map.

		// While there are more than k distinct characters in the window.
		for len(charCount) > k {
			left := s[startWindow] // Get the character at the start of the window.
			charCount[left]--     // Decrease the count of the character.
			if charCount[left] == 0 {
				delete(charCount, left) // If the count becomes 0, remove the character from the map.
			}
			startWindow++ // Move the start of the window to the right.
		}

		maxLen = max(maxLen, endWindow-startWindow+1) // Update the maximum length.
	}
	return maxLen
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	fmt.Println(longestSubstringWithKDistinctChars("araaci", 2))
	fmt.Println(longestSubstringWithKDistinctChars("araaci", 1))
	fmt.Println(longestSubstringWithKDistinctChars("cbbebi", 3))
}
