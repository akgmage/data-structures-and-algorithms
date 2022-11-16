package main

import "fmt"

func SortedSquaredArray(array []int) []int {
	// Write your code here.
	result := make([]int, len(array))
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