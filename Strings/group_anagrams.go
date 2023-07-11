/*
	Group Anagrams

	Sample Input:  = ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]
	Output: [["yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"], ["foo"]]

	Explanation:

	The code snippet is a function that groups anagrams together. An anagram is a word or phrase formed by rearranging
	the letters of another word or phrase.

	The function first defines two functions: GroupAnagrams and sortWord. The GroupAnagrams function takes a list of words
	as input and returns a list of lists, where each inner list contains all the anagrams of a word in the original list.
	The sortWord function takes a word as input and returns a string that contains the word's letters in sorted order.

	The GroupAnagrams function works by first creating a map where the keys are sorted strings of words and the values are
	lists of words that have the same sorted string. Then, the function iterates through the list of words, calling the
	sortWord function to get the sorted string for each word. The function then adds the word to the list of words associated with the sorted string in the map. Finally, the function iterates through the map, adding each list of words to a list of lists.

	The sortWord function works by converting the word to a byte array and then calling the sort.Slice function to sort
	the byte array. The function then returns a string that contains the sorted byte array.

	O(w * n * log(n)) time | O(wn) space - where w is the number of words and n is the length of the longest word

*/
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
