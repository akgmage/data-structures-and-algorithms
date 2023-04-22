package main

import (
	"fmt"
	"math"
)

// This function returns the maximum subarray sum in a given slice of integers.
// It takes an integer slice as input and returns the maximum subarray sum as an integer.
func maxSubarraySum(arr []int) int {
	maxSoFar := math.MinInt32 // Initialize the maximum subarray sum to the smallest possible integer value
	maxEndingHere := 0        // Initialize the maximum ending here to 0

	for _, num := range arr {
		// Update the maximum ending here
		maxEndingHere += num

		// If the maximum ending here is negative, we reset it to 0
		if maxEndingHere < 0 {
			maxEndingHere = 0
		}

		// If the maximum ending here is greater than the maximum subarray sum so far,
		// we update the maximum subarray sum so far
		if maxEndingHere > maxSoFar {
			maxSoFar = maxEndingHere
		}
	}

	return maxSoFar
}

func main() {
	arr := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	maxSum := maxSubarraySum(arr)
	fmt.Println("Maximum subarray sum:", maxSum)
}
