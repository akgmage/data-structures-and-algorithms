// Group Anagrams
/*
	The time complexity of this implementation is O(n * k log k), where n is the length of the input array and k is the length of the longest string in the array. This is due to the time complexity of sorting each string in the array.

	The space complexity of this implementation is O(n * k), as we need to store each string in the map along with its corresponding group of anagrams.
*/
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
func main() {
    strs := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
    groups := groupAnagrams(strs)
    for _, group := range groups {
        fmt.Println(group)
    }
}
