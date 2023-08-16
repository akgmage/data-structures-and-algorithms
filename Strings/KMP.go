package main

import (
	"fmt"
)

// computeLPSArray computes the Longest Prefix Suffix (LPS) array for the given pattern.
func computeLPSArray(pattern string) []int {
	length := len(pattern)
	lps := make([]int, length)
	lps[0] = 0
	j := 0

	for i := 1; i < length; {
		if pattern[i] == pattern[j] {
			j++
			lps[i] = j
			i++
		} else {
			if j != 0 {
				j = lps[j-1]
			} else {
				lps[i] = 0
				i++
			}
		}
	}

	return lps
}

// KMPSearch searches for occurrences of the pattern within the given text using the KMP algorithm.
func KMPSearch(text, pattern string) []int {
	n := len(text)
	m := len(pattern)
	lps := computeLPSArray(pattern)

	i := 0 // Index for text
	j := 0 // Index for pattern

	positions := make([]int, 0)

	for i < n {
		if pattern[j] == text[i] {
			i++
			j++
		}

		if j == m {
			positions = append(positions, i-j)
			j = lps[j-1]
		} else if i < n && pattern[j] != text[i] {
			if j != 0 {
				j = lps[j-1]
			} else {
				i++
			}
		}
	}

	return positions
}

func main() {
	text := "ABABDABACDABABCABAB"
	pattern := "ABABCABAB"
	positions := KMPSearch(text, pattern)

	if len(positions) == 0 {
		fmt.Println("Pattern not found in the text.")
	} else {
		fmt.Printf("Pattern found at positions: %v\n", positions)
	}
}
