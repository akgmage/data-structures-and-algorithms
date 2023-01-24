// Given an array of integers, give an algorithm for removing the duplicates.
package main

import "fmt"

// RemoveDuplicates: returns new string without duplicate characters
// Approach: use hash table to see if value already exists or not, if it does the skip the value
// else append it to the result string
// Time Complexity: Θ(n) on average. Space Complexity: O(n).
func RemoveDuplicates(word string) string {
	result := ""
	mp := map[byte]bool{}
	for i:= 0; i < len(word); i++ {
		if mp[word[i]] == true {
			// current character exist in hash table so do nothing
		} else {
			// mark as true(insert into hashtable) and add to result string
			mp[word[i]] = true
			result = result + string(word[i])
		}
	}
	return result
}

func main() {
	fmt.Println(RemoveDuplicates("aabbcaaacdd"));
}