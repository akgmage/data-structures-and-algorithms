package main

import "fmt"

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