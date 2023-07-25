/*
  Write a function that takes in a non-empty array of integers and returns the greatest sum  that can be generated 
  from a strictly-increasing subsequence in the array as well as an array of the numbers in that subsequence.
  
*/
package main

import "math"

// MaxSumIncreasingSubsequence finds the maximum sum increasing subsequence in the given array of integers.
func MaxSumIncreasingSubsequence(array []int) (int, []int) {
	// Initialize two arrays to store maximum sums and the previous elements contributing to the sums.
	sums := make([]int, len(array))
	sequences := make([]int, len(array))

	// Initialize each element in 'sums' array to its corresponding element in the input array.
	// Also, initialize each element in 'sequences' array to a sentinel value 'math.MinInt32'.
	for i := range sequences {
		sequences[i] = math.MinInt32
		sums[i] = array[i]
	}

	// Variable to keep track of the index with the maximum sum.
	maxSumIndex := 0

	// Iterate through the input array and calculate the maximum sum increasing subsequences.
	for i, currNum := range array {
		for j := 0; j < i; j++ {
			otherNum := array[j]
			if otherNum < currNum && currNum+sums[j] >= sums[i] {
				// If the current element can extend the increasing subsequence with a better sum,
				// update the 'sums' and 'sequences' arrays accordingly.
				sums[i] = currNum + sums[j]
				sequences[i] = j
			}
		}

		// Update the index with the maximum sum if the current sum is greater.
		if sums[i] > sums[maxSumIndex] {
			maxSumIndex = i
		}
	}

	// Get the maximum sum from the 'sums' array and the increasing subsequence from the 'sequences' array.
	sum := sums[maxSumIndex]
	sequence := buildSequence(array, sequences, maxSumIndex)
	return sum, sequence
}

// buildSequence reconstructs the increasing subsequence from the 'sequences' array.
func buildSequence(array []int, sequences []int, index int) []int {
	sequence := []int{}

	// Traverse the 'sequences' array starting from the 'index' until reaching the sentinel value 'math.MinInt32'.
	for index != math.MinInt32 {
		// Add the element at the current index to the 'sequence' array.
		sequence = append(sequence, array[index])

		// Move to the previous index using 'sequences' array.
		index = sequences[index]
	}

	// Reverse the 'sequence' array since it was built backward.
	reverse(sequence)
	return sequence
}

// reverse is a helper function used to reverse the elements in the 'sequence' array.
func reverse(numbers []int) {
	for i, j := 0, len(numbers)-1; i < j; i, j = i+1, j-1 {
		numbers[i], numbers[j] = numbers[j], numbers[i]
	}
}
