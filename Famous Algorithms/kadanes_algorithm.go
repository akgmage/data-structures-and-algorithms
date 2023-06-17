/*
	Write a function that takes in a non-empty array of integers and returns the
	maximum sum that can be obtained by summing up all of the integers in a
	non-empty subarray of the input array. A subarray must only contain adjacent
	numbers (numbers next to each other in the input array).

	Sample Input: [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
	Output: 19

	Explanation:

	The function takes an array of integers as input, and initializes two variables: `maxEndingHere` and `maxSoFar`. 
	`maxEndingHere` keeps track of the maximum subarray sum that ends at the current element, and `maxSoFar` keeps track 
	of the maximum subarray sum seen so far.

	The function then iterates through the array starting at the second element, and for each element, it calculates the 
	maximum subarray sum that ends at that element by adding the current element to the maximum subarray sum that ends at 
	the previous element (`maxEndingHere + num`). If this sum is greater than the current element itself (`num`), then `maxEndingHere` is updated to the sum. Otherwise, `maxEndingHere` is updated to `num`.

	After each iteration, `maxSoFar` is updated to the maximum value seen so far, which is either `maxEndingHere` or `maxSoFar`.

	The function finally returns `maxSoFar`, which represents the maximum subarray sum of the input array. The `max` function 
	is a helper function used to compare two integers and return the maximum of the two.

	O(n) time | O(1) space - where n is the length of the input array

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