// Group Anagrams
/*
	The program takes a slice of strings as input, where each string is an element in the slice.
	The goal is to group the strings into separate groups where each group contains only anagrams of each other.

	The first step in the program is to create a map where the keys are strings and the values are slices of strings.
	This map will be used to store the groups of anagrams.

	Next, the program loops through each string in the input slice. For each string, the program converts
	it to a slice of bytes, sorts the bytes in ascending order, and then converts the sorted slice of bytes back into a string.
	This sorted string is used as the key to the map.

	If the key already exists in the map, the string is added to the slice of values associated with that key.
	If the key doesn't exist, a new key-value pair is created with the key being the sorted string and the value
	being a new slice containing only the current string.

	Once all the strings have been processed, the program loops through the map and appends the slice of values
	associated with each key to the output slice. This output slice contains slices of strings, where each slice
	is a group of anagrams.

	Finally, the program returns the output slice.

	Overall, the program uses the fact that anagrams have the same set of characters (and thus, the same sorted order of characters) \
	to group the input strings efficiently.

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
