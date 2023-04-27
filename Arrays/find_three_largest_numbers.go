/*
  Write a function that takes in an array of at least three integers and,
  without sorting the input array, returns a sorted array of the three largest
  integers in the input array.
*/
package main

import "math"

// FindThreeLargestNumbers returns the three largest integers in the input array in descending order.
func FindThreeLargestNumbers(array []int) []int {
	// Initialize a slice to hold the three largest integers, starting with negative infinity.
	triplets := []int{math.MinInt32, math.MinInt32, math.MinInt32}
	for _, num := range array {
		// For each number in the array, call the updateLargest function to determine if it should be included in the triplet.
		updateLargest(triplets, num)
	}
	return triplets
}

// updateLargest updates the triplet if the input number is larger than any of its elements.
func updateLargest(triplets []int, num int) {
	// If the number is larger than the third-largest element in the triplet, shift the other elements to make room and add the number.
	if num > triplets[2] {
		shiftAndUpdate(triplets, num, 2)
	// Otherwise, if the number is larger than the second-largest element, shift and update the triplet accordingly.
	} else if num > triplets[1] {
		shiftAndUpdate(triplets, num, 1)
	// Otherwise, if the number is larger than the first-largest element, shift and update the triplet accordingly.
	} else if num > triplets[0] {
		shiftAndUpdate(triplets, num, 0)
	}
}

// shiftAndUpdate shifts the elements of the triplet to make room for a new number and adds the number to the specified index.
func shiftAndUpdate(triplets []int, num int, idx int) {
	for i := 0; i < idx+1; i++ {
		// If the loop reaches the specified index, add the new number to the triplet.
		if i == idx {
			triplets[i] = num
		// Otherwise, shift the elements to the right.
		} else {
			triplets[i] = triplets[i+1]
		}
	}
}
