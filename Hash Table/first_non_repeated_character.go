package main

import "fmt"

// This function takes a string as input and returns the index of the first non-repeating character in the string.
func FirstNonRepeatingCharacter(str string) int {
	// Create a map to store the frequency of each character in the string.
	// The key of the map is a rune, which is an integer representation of a Unicode character.
	// The value of the map is an integer representing the frequency of the corresponding character.
	charFreq := make(map[rune]int)
	// Loop through each character in the string and update its frequency in the map.
	for _, char := range str {
		charFreq[char] += 1
	}
	// Loop through each character in the string again.
	for idx, char := range str {
		// If the frequency of the current character is 1, it means it is the first non-repeating character in the string.
		if charFreq[char] == 1 {
			// Return the index of the non-repeating character.
			return idx
		}
	}
	// If no non-repeating character is found in the string, return -1.
	return -1
}

func main() {
	fmt.Println(FirstNonRepeatingCharacter("abcdcaf")); // b index 1
}