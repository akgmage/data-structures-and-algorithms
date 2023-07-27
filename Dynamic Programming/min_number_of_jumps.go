package main

import "math"

// MinNumberOfJumps calculates the minimum number of jumps required to reach the last element of the `array`.
func MinNumberOfJumps(array []int) int {
	// Create an array to store the minimum number of jumps required to reach each position in the `array`.
	ways := make([]int, len(array))
	
	// Initialize the `ways` array with maximum integer values representing an unreachable state.
	for i := range ways {
		ways[i] = math.MaxInt32
	}
	
	// Base case: The first element requires 0 jumps to reach itself.
	ways[0] = 0
	
	// Iterate through the array starting from the second element.
	for i := 1; i < len(array); i++ {
		// Check all previous elements to see if a jump from j to i is possible.
		for j := 0; j < i; j++ {
			// If it is possible to jump from j to i, update the `ways[i]` value.
			if array[j] + j >= i {
				ways[i] = min(ways[i], ways[j]+1)
			}
		}
	}
	
	// The value at `ways[len(ways) - 1]` will contain the minimum number of jumps required to reach the last element.
	return ways[len(ways)-1]
}

// min returns the minimum of two integers.
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
