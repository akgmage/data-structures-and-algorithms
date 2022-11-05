// Implement an algorithm to determine if a string has all unique characters.
// what if you cannot use additional data structures?
// Program Author : Abhisek Kumar Gupta
// Approach 1 : compare every character of string with other character TC O(n^2)
// Approach 2 : Sort the string and compare neighbouring character for dups TC O(n log(n))

package main

import "fmt"


func is_unique_normal(s string) bool {
	if len(s) > 128 {
		return false
	}
	var visited  [128]bool
	
	for i := 0; i < len(s); i++ {
		val := int(s[i]) // convert to ascii value
		if(visited[val]) { // if already seen then duplicate exists hence return false
			return false
		}
		visited[val] = true // mark seen as true so far
	}
	return true
}

func main() {
	s := "ABCDD"
    t := "ABCD"
    u := "AAAAAABCD"
    msg := is_unique_normal(s)
	fmt.Println(msg)
    msg = is_unique_normal(t)
	fmt.Println(msg)
    msg = is_unique_normal(u)
	fmt.Println(msg)
}