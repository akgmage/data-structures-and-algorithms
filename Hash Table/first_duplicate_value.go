/*

  	Given an array of integers between  1 and n, inclusive, where n is the length of the array, write a function
	that returns the first integer that appears more than once (when the array is read from left to right).

	Sample Input = [2, 1, 5, 2, 3, 3, 4]
	Output : 2

	The time complexity of the `FirstDuplicateValue` function is O(n), where n is the length of the
	input `array`. This is because the function iterates through the array once, performing constant
	time operations (checking if a value exists in a hash map and inserting values into the hash map).
	The worst case scenario is that the function iterates through the entire array without finding a
	duplicate, resulting in O(n) time complexity.

	The space complexity of the given implementation is O(n), where n is the length of the input array.
	This is because we are using a hash table (implemented as a map in Go) to store the elements we have
	seen so far. In the worst case, where there are no duplicates in the array, we will end up storing
	all n elements in the hash table, which would require O(n) space.
*/
package main

import "fmt"

/*
	This function takes an array of integers as input and returns the first duplicate value found in
	the array. It uses a hash table, implemented as a Go map, to keep track of the numbers seen so far.
	For each number in the input array, the function checks if it has already been seen before by
	checking if it exists as a key in the map. If it has been seen before, the function returns
	the number as it is the first duplicate value found. Otherwise, the function adds the number
	to the map with a value of true to indicate that it has been seen.
*/
func FirstDuplicateValue(array []int) int {
	seenSoFar := make(map[int]bool)
	for _, num := range array {
		if _, valueExists := seenSoFar[num]; valueExists {
			return num
		}
		seenSoFar[num] = true
	}
	return -1
}

func main() {
	array := []int{2, 1, 5, 2, 3, 3, 4}
	firstDuplicate := FirstDuplicateValue(array)
	fmt.Println(firstDuplicate)
}
