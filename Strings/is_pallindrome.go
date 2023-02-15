// Valid Palindrome
package main

import (
	"fmt"
	"strings"
)

// The two pointers approach would allow us to solve this problem in linear time and without any extra space complexity or built-in functions because we’ll be simply traverse the array from the start and the end at the same time to reach the middle of the string.

func isPalindrome(inputString string) {
	fmt.Printf("String to check: \"%s\". Length of string: %d\n", inputString, len(inputString))
	left := 0
	right := len(inputString) - 1
	i := 1

	// The terminating condition for the loop is when both the pointers reach the same element or when they cross each other
	for left < right {
		fmt.Printf("In iteration %d, left = %d, right = %d\n", i, left, right)
		fmt.Printf("The current element being pointed to by the left pointer is %c\n", inputString[left])
		fmt.Printf("The current element being pointed to by the right pointer is %c\n", inputString[right])
        fmt.Printf("%s\n", strings.Repeat("-", 100))
		// Heading towards the right
		left += 1

		// Heading towards left
		right -= 1
		i += 1
	}
	fmt.Printf("Loop terminated with left = %d, right = %d\n", left, right)
	fmt.Printf("The pointers have either reached the same index, or have crossed each other, hence we don't need to look further.\n")
	fmt.Printf("%s\n", strings.Repeat("-", 100))
}

// Driver code
func main() {
	inputList := []string {"RACECAR", "ABBA", "TART"}
	
	for i, value := range inputList {
		fmt.Printf("Test Case # %d\n", i + 1)
		isPalindrome(value)
		
	}
}