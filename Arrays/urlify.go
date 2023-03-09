// Implement an algorithm to replace all spaces with %20, assumew we have extra buffer at the end.
// Input : Mr Ashish Lala Output: Mr%20Ashish%20Lala
// Program Author : Abhisek Kumar Gupta
// Time complexity : O(n) Space complexity O(n)
package main

import "fmt"

func Urlify(s string, length int) string {
	spaceCount := 0
	r := []rune{}
	// compute spaces, 
	for i := 0; i < length; i++ {
		if s[i] == ' ' {
			spaceCount++
		}
	}
	// string to rune
	for _, v := range s {
		r = append(r, v)
	}
	// triple space count and find out how many extra characters will be there in final string 
	index := length + (spaceCount * 3) // actual length of final string
	for i := length - 1; i >= 0; i-- {
		// If u encounter space then replace with  %20
		if r[i] == ' ' {
			r[index - 1] = '0'
			r[index - 2] = '2'
			r[index - 3] = '%'
			index -= 3
		} else {
			// If there is no space then copy the original character
			r[index - 1] = r[i]
			index--
		}
	}
	return string(r[index:])
}


func main() {
	s := "Mr John Smith          ";
	length := 13
	msg := Urlify(s, length);
	fmt.Println(msg)
}