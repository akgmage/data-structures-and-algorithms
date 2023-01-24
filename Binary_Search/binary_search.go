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
	// mark start and end
	start := 0
	end := len(array) - 1
	// idea behind bs is, since array is already sorted we can use it to our advantage
	// 1 compute mid
	// 2 if mid value is less than target then we only need to search index less than mid 
	// 3 if mid value is greater than target then we only need to search index greater than mid 
	// and keep repeating from step 1
	// make sure start and end dont cross each other
	for start <= end {
		// compute mid, prevent overflow of integer
		mid := start + (end - start) / 2
		if array[mid] == target {
			return mid
		} else if array[mid] > target { // Element in mid is higher than target.
			end = mid - 1 // # Our (end) becomes the element before mid.
		} else if array[mid] < target { // Element in mid is lower than target.
			start = mid + 1 // # Our (start) becomes the element after mid.
		}
	}
	return -1
}

func main() {
	arr := []int{-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 33, 44, 55}
	target := 7
	msg := BinarySearch(arr, target)
	fmt.Println(msg)
	msg = BinarySearch(arr, 700)
	fmt.Println(msg)
}