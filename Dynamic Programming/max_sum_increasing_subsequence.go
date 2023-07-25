/*
	Write a function that takes in a non-empty array of integers and returns the greatest sum  that can be generated
	from a strictly-increasing subsequence in the array as well as an array of the numbers in that subsequence.

	Sample Input:  = [10, 70, 20, 30, 50, 11, 30]
	Output : [110, [10, 20, 30, 50]]
	
	Explanation:
	The given code snippet implements a function called `MaxSumIncreasingSubsequence`, which finds the maximum sum increasing subsequence in a given array of integers. An increasing subsequence is a sequence of array elements where each element is strictly greater than the previous element.

	Here's a step-by-step explanation of the code:

	1. The function `MaxSumIncreasingSubsequence` takes an input array of integers called `array`.

	2. Two arrays `sums` and `sequences` are initialized with the same length as the input array. The `sums` array stores the maximum sum of increasing subsequences ending at the corresponding index, and the `sequences` array stores the previous index that contributes to the maximum sum at the current index.

	3. The `maxSumIndex` variable is used to keep track of the index with the maximum sum of an increasing subsequence.

	4. The code uses a dynamic programming approach to calculate the maximum sum of increasing subsequences. It iterates through the input array from left to right and, for each element, checks all the previous elements to find the ones that are less than the current element and can form an increasing subsequence with it. If a better sum is found for the current element, it updates the `sums` and `sequences` arrays.

	5. After iterating through the entire array, the `maxSumIndex` stores the index with the maximum sum of an increasing subsequence.

	6. The function `buildSequence` is used to reconstruct the actual increasing subsequence from the `sequences` array, starting from the `maxSumIndex` and going backward until it reaches an element with a value of `math.MinInt32`, which is used as a sentinel value to indicate the end of the sequence.

	7. The `reverse` function is a helper function used to reverse the elements in the `sequence` array since the subsequence was built backward.

	8. The function returns the maximum sum of the increasing subsequence (`sum`) and the subsequence itself (`sequence`).

	O(n^2) time | O(n) space - where n is the length of the input array
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
