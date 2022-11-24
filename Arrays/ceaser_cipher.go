/*
  Given a non-empty string of lowercase letters and a non-negative integer
  representing a key, write a function that returns a new string obtained by
  shifting every letter in the input string by k positions in the alphabet,
  where k is the key.

  Note that letters should "wrap" around the alphabet; in other words, the
  letter z shifted by one returns the letter a
*/
package main

import "fmt"

func CaesarCipherEncryptor(str string, key int) string {
	key = key % 26 // mod with 26 just in case the key is not bigger
	result := ""
	// find out ascii value if its greater than ascii value of 'z' then reduce 26 from value
	for i := 0; i < len(str); i++ {
		asciiValue := int(str[i]) + key
		if asciiValue > 122 {
			asciiValue -= 26
		}
		result += string(asciiValue)
	}
	return result
}

func main() {
	msg := CaesarCipherEncryptor("abcdzxc", 10)
	fmt.Println(msg)
}