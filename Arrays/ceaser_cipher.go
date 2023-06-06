/*
  Given a non-empty string of lowercase letters and a non-negative integer
  representing a key, write a function that returns a new string obtained by
  shifting every letter in the input string by k positions in the alphabet,
  where k is the key.

  Note that letters should "wrap" around the alphabet; in other words, the
  letter z shifted by one returns the letter a

  Sample Input : abz key: 3
  Output: dec
*/
package main

// CaesarCipherEncryptor takes a string and a key (integer) as input and returns
// a new string obtained by shifting each character of the input string by the
// key number of positions to the right in the alphabet, wrapping around if necessary.
func CaesarCipherEncryptor(str string, key int) string {
	// Calculate the shift amount and offset value
	shift, offset := rune(key % 26), rune(26)
	
	// Convert the input string to a rune slice (for ease of manipulation)
    runes := []rune(str)
    
    // Iterate over each character in the rune slice
    for i, char := range runes {
    	// If the character is a lowercase letter and shifting it will still be within the lowercase range
        if char >= 'a' && char + shift <= 'z' {
            char += shift
        } else {
        	// If the character is outside of the lowercase range after shifting, wrap it around
            char += shift - offset
        }
        // Update the character in the rune slice
        runes[i] = char
    }
    
    // Convert the resulting rune slice back to a string and return it
    return string(runes)
}
