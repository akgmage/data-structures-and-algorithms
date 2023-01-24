/*
	Implelemtation of Recursive Binary Search

	In computer science, binary search, also known as half-interval search,
	logarithmic search, or binary chop, is a search algorithm that
	finds the position of a target value within a sorted array.
	Binary search compares the target value to the middle element of the array.
	If they are not equal, the half in which the target cannot lie is eliminated
	and the search continues on the remaining half,
	again taking the middle element to compare to the target value,
	and repeating this until the target value is found.
	If the search ends with the remaining half being empty, the target is not in the array.
	Source(https://en.wikipedia.org/wiki/Binary_search_algorithm)
*/
package main

import "fmt"

func BinarySearchRecursive(Arr []int, key int) bool {
	low := 0
	high := len(Arr) - 1
	if low <= high {
		mid := low + (high - low) / 2 // prevent overflow
		if Arr[mid] > key { // Element in mid is higher than target.
			return BinarySearchRecursive(Arr[:mid], key) // search from start to mid 
		} else if Arr[mid] < key { // Element in mid is lower than target.
			return BinarySearchRecursive(Arr[mid + 1:], key) // search from mid + 1 to last
		} else {
			return true
		}
	}
	return false
}

func main() {
	Arr := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	fmt.Println(BinarySearchRecursive(Arr, 5))
	fmt.Println(BinarySearchRecursive(Arr, 6))
	fmt.Println(BinarySearchRecursive(Arr, -1))
	fmt.Println(BinarySearchRecursive(Arr, -10))
	fmt.Println(BinarySearchRecursive(Arr, 70))
}