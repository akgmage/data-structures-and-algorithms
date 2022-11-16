/*
  Given two non-empty arrays of integers, write a function that determines
  whether the second array is a subsequence of the first one.
*/
package main

import "fmt"


func IsValidSubsequence(array []int, sequence []int) bool {
	// Write your code here.
    index := 0
	for i := 0; i < len(array) && index < len(sequence); i++ {
		if array[i] == sequence[index] {
			index++
		}
	}
	return index == len(sequence)
}

func main() {
	arr := []int{1, 2, 3, 4, 5, 6}
	seq := []int{2, 4, 6}
	msg := IsValidSubsequence(arr, seq)
	fmt.Println(msg)
}