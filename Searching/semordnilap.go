/*
	Write a function that takes in a list of unique strings and returns a list of
	semordnilap pairs.

	A semordnilap pair is defined as a set of different strings where the reverse
	of one word is the same as the forward version of the other. For example the
	words "diaper" and "repaid" are a semordnilap pair, as are the words
	"palindromes" and "semordnilap".
*/

// Sample Input :  = ["diaper", "abc", "test", "cba", "repaid"]
// Output : [["diaper", "repaid"], ["abc", "cba"]]
// Time and Space complexity : O(n * m) time | O(n * m) space - where n is the number of words and m is the length of the longest word
package main

func Semordnilap(words []string) [][]string {
	result := [][]string{}
	// crete word set
    wordSet := make(map[string]bool)
    for _, word := range words {
        wordSet[word] = true
    }
	
	// After creating the set of words, try iterating through the original array. For
	// each word, can you check if its semordnilap pair is in the word list
    for _, word := range words {
        reverse := reverse(word)
        if _, wordInSet := wordSet[reverse]; wordInSet && word != reverse {
            result = append(result, []string{word, reverse})
            delete(wordSet, word)
            delete(wordSet, reverse)
        } 
    }
	return result
}

func reverse(s string) string {
    x := []byte{}
    for i := len(s) - 1; i >= 0; i-- {
        x = append(x, s[i])
    }
    return string(x)
}
