/*
  Write a function that takes in a non-empty string and that returns a boolean
  representing whether the string is a palindrome.
  Sample Input: abba
  Output: True
  Sample Input: aberba
  Output: False
*/
package main

import "fmt"

func IsPalindrome(str string) bool {
	start := 0
	end := len(str) - 1
	for start <= end {
		// if string doesn't match return false straight away
		if str[start] != str[end] {
			return false
		}
		// string matches so bring start and end inwards
		start++
		end--
	}
	return true
}

func main() {
	msg := IsPalindrome("HelleH")
	fmt.Println(msg)
	msg = IsPalindrome("Hello")
	fmt.Println(msg)
}