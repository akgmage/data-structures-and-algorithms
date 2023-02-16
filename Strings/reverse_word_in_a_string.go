/*
	Given a sentence, reverse the order of its words without affecting the order of letters within a given word.
*/
// Time Complexity : O(n) n is length of string
// Space complexity : O(n) as we used additional space to store the list of characters as strings are immutable in go
package main

import (
	"fmt"
	"strings"
)

// reverseWords is our challenge function
func reverseWords(sentence string) string {
	// We need to convert the input strings to lists of characters as strings are immutable in Go
	sentenceBytes := []byte(sentence)

	// To reverse all words in the string, we will first reverse the entire string.
	strLen := len(sentenceBytes)
	sentenceBytes = strRev(sentenceBytes, 0, strLen-1)
	strLen = len(sentenceBytes)
	// Now all the words are in the desired location, but
	// in reverse order: "Hello World" -> "dlroW olleH".

	// Now, let's iterate the sentence and reverse each word in place.
	// "dlroW olleH" -> "World Hello"
	start, end := 0, 0

	for {
		// find the start index of each word by detecting spaces.
		for start < len(sentenceBytes) && sentenceBytes[start] == ' ' {
			start += 1
		}
		if start == strLen {
			break
		}

		// Find the end index of the word.
		end = start + 1
		for end < strLen && sentenceBytes[end] != ' ' {
			end += 1
		}
		
		// Let's call our helper function to reverse the word in-place.
		sentenceBytes = strRev(sentenceBytes, start, end-1)
		start = end
	}
	return string(sentenceBytes)
}

// strRev function that reverses a whole sentence character by character
func strRev(str []byte, startRev int, endRev int) []byte {
	// Starting from the two ends of the list, and moving
	// in towards the centre of the string, swap the characters
	for startRev < endRev {
		temp := str[startRev] // temp store for swapping
		str[startRev] = str[endRev] // swap step 1
		str[endRev] = temp        // swap step 2

		startRev += 1 // move forwards towards the middle
		endRev -= 1   // move backwards towards the middle
	}

	// Removing multiple spaces
	// Removing multiple spaces
	i := 0
    j := len(str) - 1
    strRes := make([]byte, 0)
    for {
        if str[i] != ' ' {
            break
        }
		i++
    }
    for {
        if str[j] != ' ' {
            break
        }
		j--
    }
    for i <= j {
        if str[i] == ' ' && strRes[len(strRes)-1] != ' ' {
            strRes = append(strRes, str[i])
        } else if str[i] != ' ' {
            strRes = append(strRes, str[i])
        }
        i++
    }

	// Returning the reversed sentence
	return strRes
}

// Driver code
func main() {
	stringToReverse := []string{"Hello World!", "We love Python.", "The quick brown fox jumped over the lazy dog.", "Hey!", "To be, or not to be", "AAAAA", "Hello     World"}

	for i, str := range stringToReverse {
		fmt.Printf("%d.\tActual string:      \"%s\"\n", i+1, str)
		fmt.Printf("\tReversed string:    \"%s\"\n", reverseWords(str))
		fmt.Printf("%s\n", strings.Repeat("-", 100))
	}
}