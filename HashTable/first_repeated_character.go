// Program to find first repeating character in a word
// Sample Input : "DataStructures"
// Output: a

package main

import "fmt"

func FirstRepeatedCCharacter(word string) byte {
	length := len(word)

	hMap := [256]int{} // Extended Ascii can support 256 different characters
	
	// initialize hMap values to 0
	for i := 0; i < 256; i++ {
		hMap[i] = 0
	}

	// every time you see a character in a word increment its position in hMap
	for i := 0; i < length; i++ {
		// if character is already present incase "1" then return character
		if hMap[word[i]] == 1 {
			return word[i]
		}
		// increment value in position of character
		hMap[word[i]]++
	}
	return byte(0)
}

func main() {
	fmt.Printf("%c",FirstRepeatedCCharacter("DataStructures"))
}