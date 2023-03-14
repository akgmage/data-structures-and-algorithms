// Reverse a string
// Program Author : Abhisek Kumar Gupta

package main

import "fmt"

func reverse(s string) string {
	// since strings are immutable in go, we make array of runes
	chars := []rune(s)
	// swap start and end position characters
	for i, j := 0, len(chars)-1; i < j; i, j = i+1, j-1 {
		chars[i], chars[j] = chars[j], chars[i]
	}
	// cast chars to string
	return string(chars)
}

func main() {
	fmt.Printf("%v\n", reverse("abcdefg"))
}

