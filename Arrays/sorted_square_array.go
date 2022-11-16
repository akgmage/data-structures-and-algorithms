/*
  Write a function that takes in a non-empty array of integers that are sorted
  in ascending order and returns a new array of the same length with the squares
  of the original integers also sorted in ascending order.

  Sample Input: [-6, 1, 2, 3, 4]
  Output: [1, 4, 6, 16, 36]
*/
package main

import "fmt"

func SortedSquaredArray(array []int) []int {
	// initialize empty result array of same length as original array
	result := make([]int, len(array))
	// mark start and end, and end_pos
	end_pos := len(array) - 1
	start := 0
	sq1 := 0
	sq2 := 0
	end := len(array) - 1
	for start <= end {
		sq1 = array[start] * array[start]
		sq2 = array[end] * array[end]
		if sq1 > sq2 {
			result[end_pos] = sq1
			start++
		} else {
			result[end_pos] = sq2
			end--
		}
		end_pos--
	}
	return result
}

func main() {
	arr := []int{-6, 1, 2, 3, 4, 5}
	msg := SortedSquaredArray(arr)
	fmt.Println(msg)
}