/*
  Write a function that takes in a non-empty array of integers and returns the
  maximum sum that can be obtained by summing up all of the integers in a
  non-empty subarray of the input array. A subarray must only contain adjacent
  numbers (numbers next to each other in the input array).

*/
package main

// KadanesAlgorithm computes the maximum sum subarray using Kadane's algorithm
func KadanesAlgorithm(array []int) int {
	// Initialize maxEndingHere and maxSoFar to the first element of the array
	maxEndingHere, maxSoFar := array[0], array[0]

	// Loop through the array starting from the second element
	for _, num := range array[1:] {
		// Compute the maximum subarray sum ending at the current element
		maxEndingHere = max(maxEndingHere+num, num)

		// Update maxSoFar if the current maximum subarray sum is greater
		maxSoFar = max(maxEndingHere, maxSoFar)
	}

	// Return the maximum subarray sum
	return maxSoFar
}

// max returns the maximum of two integers
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
 q