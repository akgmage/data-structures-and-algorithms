package main

import (
	"fmt"
	"sort"
)

func groupAnagrams(strs []string) [][]string {
	// Create a map to store anagrams and their grouped strings
	anagramMap := make(map[string][]string)

	// Loop through each string in the input array
	for _, str := range strs {
		// Sort the string to create a unique key for each anagram
		sortedStr := sortString(str)
		// Add the string to its corresponding group in the anagramMap
		anagramMap[sortedStr] = append(anagramMap[sortedStr], str)
	}

	// Create a 2D slice to store the grouped anagrams
	groups := make([][]string, 0, len(anagramMap))

	// Loop through the anagramMap and append each group of anagrams to the groups slice
	for _, group := range anagramMap {
		groups = append(groups, group)
	}

	return groups
}

// Helper function to sort a string alphabetically
func sortString(s string) string {
	sBytes := []byte(s)
	sort.Slice(sBytes, func(i, j int) bool { return sBytes[i] < sBytes[j] })
	return string(sBytes)
}
