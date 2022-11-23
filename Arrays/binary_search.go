/*
  Write a function that takes in a sorted array of integers as well as a target
  integer. The function should use the Binary Search algorithm to determine if
  the target integer is contained in the array and should return its index if it
  is, otherwise -1
  Sample Input : [0, 1, 44, 66, 77] target = 66
  Output : 3
  Sample Input : [0, 1, 44, 66, 77] target = 101
  Output : -1
*/
package main

import "fmt"

func BinarySearch(array []int, target int) int {

	start := 0
	end := len(array) - 1
	for start <= end {
		mid := start + (end-start)/2
		if array[mid] == target {
			return mid
		} else if array[mid] > target {
			end = mid - 1
		} else if array[mid] < target {
			start = mid + 1
		}
	}
	return -1
}

func main() {
	arr := []int{-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 33, 44, 55}
	target := 7
	msg := BinarySearch(arr, target)
	fmt.Println(msg)
}