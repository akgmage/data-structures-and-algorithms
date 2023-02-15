// Valid Palindrome
package main

import (
	"fmt"
	"strings"
)

// The two pointers approach would allow us to solve this problem in linear time and without any extra space complexity or built-in functions because we’ll be simply traverse the array from the start and the end at the same time to reach the middle of the string.
// Time complexity
// The time complexity is O(n) where n is the number of characters present in the string.
// Space complexity O(1) because we use constant space to store two indices.
// Sample Input : RACEACAR
// Output: False

func isPalindrome(inputString string) bool {
	left := 0
	right := len(inputString) - 1
	fmt.Printf("\tThe current element being pointed by the left index is %c\n", inputString[left])
	fmt.Printf("\tThe current element being pointed by the right index is %c\n", inputString[right])
	for left < right {
		fmt.Printf("\tWe check if the two elements are indeed the same, in this case...\n")
		
		// If the elements at index left and index right are not equal
		if inputString[left] != inputString[right] {
			fmt.Printf("\tThe elements are not the same, hence we return false\n")

			// then the symmetry is broken, the string is not a palindrome
			return false
		}

		fmt.Printf("\tThey are the same, thus we move the two pointers toward the middle to continue the\n\tverfification process\n\n")
		
		// Heading towards the right
		left++

		// Heading towards the middle
		right--

		fmt.Printf("\tThe new element at the left pointer is %c\n", inputString[left])
		fmt.Printf("\tThe new element at the right pointer is %c\n", inputString[right])
	}

	// We reached the middle of the string without finding a mismatch, so it is a palindrome
	return true
}

// Driver code
func main() {
	str := []string {"RACEACAR", "A", "ABCDEFGFEDCBA", "ABC", "ABCBA", "ABBA", "RACEACAR"}
	for i, s := range str {
		fmt.Printf("Test Case # %d\n", i + 1)
		fmt.Printf("%s\n", strings.Repeat("-", 100))
		fmt.Printf("\tThe input string is '%s' and the length of the string is %d.\n", s, len(s))
		fmt.Printf("\nIs it a palindrome?.....%v\n", isPalindrome(s))
		fmt.Printf("%s\n", strings.Repeat("-", 100))
	}
}