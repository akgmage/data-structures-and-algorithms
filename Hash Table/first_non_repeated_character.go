/*
	The FirstNonRepeatingCharacter function takes a string as input and returns the index of the
	first non-repeating character in the string. If all the characters are repeated, then it returns -1.

	The function works by first creating an empty map called charFreq to keep track of the frequency of
	each character in the string. Then, it iterates through each character in the string using a for loop.

	Inside the loop, it checks if the current character already exists in the charFreq map.

	If it does, then it increments its frequency by 1, and if it doesn't, it adds the character to the map
	with a frequency of 1.

	After the map is constructed, the function iterates through the string again using another for loop,
	this time tracking the index of each character using the idx variable.

	For each character, it checks its frequency in the charFreq map.

	If the frequency is 1, then the character is non-repeating and the function returns its index.

	If no non-repeating character is found, then the function returns -1.

	Overall, the function has a time complexity of O(n) since it loops through the string twice, and a space complexity of O(k), where k is the number of unique characters in the string, since the charFreq map stores the frequency of each unique character.
*/
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