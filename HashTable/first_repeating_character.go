// Give an algorithm for printing the first repeated character if there are duplicated elements in it

package main

import "fmt"

// FirstRepeatedCharacter: returns the first repeating character
// Approach: we know extended ascii has 256 values, so create an array with length 256
// initialize with all zeroes.
// Each of input character in word go to the corresponding position and increment its count
// while scanning the array if we see some value is already 1 then return the value
func FirstRepeatedCharacter(word string) byte {
	lengthOfString := len(word)
	// The maximum number of characters that can be represented in extended ASCII is 256
	asciiArr := [256]int{}
	for i := 0; i < 256; i++ {
		asciiArr[i] = 0
	}
	for i := 0; i < lengthOfString; i++ {
		if asciiArr[word[i]] == 1 {
			return word[i]
		}
		asciiArr[word[i]]++
	}
	return byte(0)
}

func main() {
	fmt.Printf("%c", FirstRepeatedCharacter("abcdefghe"));
}