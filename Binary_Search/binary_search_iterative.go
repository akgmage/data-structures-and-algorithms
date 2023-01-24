package main

import "fmt"

/*
   Intuition:
       If you have to guess a magic number from 1-100, the best first attempt would be to guess '50'
       or in other words, the middle. If I tell you that the magic number is higher,
       you now don't need to consider all numbers 1-50,
       and if it is lower you wouldn't need to consider numbers 50-100!!

       In Binary Search, we follow the same idea,
       1. Compar the target with the middle element.
       2. If the target is higher, then the target can only lie in the right (greater) subarray. We re-calculate mid and repeat step 1.
       3. If the target is lower, the target  can only lie in the left (lower) half. We re-calculate mid and repeat step 1.

       Binary search can only operate on a sorted array.
       Further reading: https://en.wikipedia.org/wiki/Binary_search_algorithm

*/
func BinarySearch(Arr []int, key int) bool {
	low := 0
	high := len(Arr) - 1
	for low <= high {
		mid := (high + low) / 2
		if Arr[mid] == key {
			return true
		} else if(Arr[mid] < key) {
			low = mid + 1
		} else if(Arr[mid] > key) {
			high = mid - 1
		}
	}
	return false
}

func main() {
	Arr := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	fmt.Println(BinarySearch(Arr, 5))
	fmt.Println(BinarySearch(Arr, 6))
	fmt.Println(BinarySearch(Arr, -1))
	fmt.Println(BinarySearch(Arr, -10))
	fmt.Println(BinarySearch(Arr, 7))
}