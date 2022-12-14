package main

import "fmt"


func FirstRepeatedCharacter(word string) byte {
	lengthOfString := len(word)
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