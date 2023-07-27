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


func MinNumberOfJumpsOptimal(array []int) int {
	// If the array has only one element, no jumps are needed.
	if len(array) == 1 {
		return 0
	}

	// Initialize variables to keep track of jumps, maximum reachable position, and remaining steps in a jump.
	jumps := 0
	maxreach, steps := array[0], array[0]

	// Iterate through the array to calculate the minimum number of jumps.
	// We stop at the second-to-last element as we don't need an additional jump from there.
	for i := 1; i < len(array)-1; i++ {
		// Update the maximum reachable position if the current position plus the value at that index is greater.
		if i+array[i] > maxreach {
			maxreach = i + array[i]
		}

		// Decrement the remaining steps in the current jump.
		steps--

		// If the current jump is completed (steps becomes 0), calculate the new jump.
		if steps == 0 {
			// Increment jumps to count the completed jump.
			jumps++

			// Update steps to the number of steps required to reach the farthest position.
			steps = maxreach - i
		}
	}

	// The minimum number of jumps to reach the last element is the total number of jumps taken plus one
	// because the loop doesn't consider the last element (as we don't need an additional jump from there).
	return jumps + 1
}
