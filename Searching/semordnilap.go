/*
	Write a function that takes in a list of unique strings and returns a list of
	semordnilap pairs.

	A semordnilap pair is defined as a set of different strings where the reverse
	of one word is the same as the forward version of the other. For example the
	words "diaper" and "repaid" are a semordnilap pair, as are the words
	"palindromes" and "semordnilap".
*/
package main

func Semordnilap(words []string) [][]string {
	result := [][]string{}
    wordSet := make(map[string]bool)
    for _, word := range words {
        wordSet[word] = true
    }
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
