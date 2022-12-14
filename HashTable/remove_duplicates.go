// Given an array of integers, give an algorithm for removing the duplicates.
package main

import "fmt"

// RemoveDuplicates: returns new string without duplicate characters
// Approach: use hash table to see if value already exists or not, if it does the skip the value
// else append it to the result string
func RemoveDuplicates(word string) string {
	result := ""
	mp := map[byte]bool{}
	for i:= 0; i < len(word); i++ {
		if mp[word[i]] == true {
		} else {
			mp[word[i]] = true
			result = result + string(word[i])
		}
	}
	return result
}

func main() {
	fmt.Println(RemoveDuplicates("aabbcaaacdd"));
}