package main

import "sort"

// `GroupAnagrams` groups anagrams together.
func GroupAnagrams(words []string) [][]string {
    // Create a map where the keys are sorted strings of words and the values are lists of words
    // that have the same sorted string.
    anagrams := map[string][]string{}
    for _, word := range words {
        // Get the sorted string for the word.
        sortedWord := sortWord(word)

        // Add the word to the list of words associated with the sorted string in the map.
        anagrams[sortedWord] = append(anagrams[sortedWord], word)
    }

    // Create a list of lists, where each inner list contains all the anagrams of a word in the original list.
    result := [][]string{}
    for _, group := range anagrams {
        result = append(result, group)
    }

    // Return the list of lists.
    return result
}

// `sortWord` takes a word as input and returns a string that contains the word's letters in sorted order.
func sortWord(word string) string {
    // Convert the word to a byte array.
    wordBytes := []byte(word)

    // Sort the byte array.
    sort.Slice(wordBytes, func(i, j int) bool {
        return wordBytes[i] < wordBytes[j]
    })

    // Return a string that contains the sorted byte array.
    return string(wordBytes)
}
