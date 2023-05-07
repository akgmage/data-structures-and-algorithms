// Maximum Subarray
/*
	The maxSubarraySum function takes an integer slice arr as input and returns the maximum subarray
	sum as an integer.

	The maxSoFar variable is initialized to the smallest possible integer value, since any valid subarray
	sum must be greater than or equal to this value. The maxEndingHere variable is initialized to 0,
	since an empty subarray has a sum of 0.

	The function then iterates through the elements of arr, updating maxEndingHere and maxSoFar as necessary.
	At each iteration, the maximum ending here is updated by adding the current element to it.
	If the maximum ending here becomes negative, it is reset to 0, since any subarray that includes a negative
	sum will not be the maximum subarray. If the maximum ending here is greater than the maximum subarray
	sum so far, maxSoFar is updated to the new maximum.

	Finally, the function returns maxSoFar.

	In the main function, an example input array is defined and passed to maxSubarraySum.
	The resulting maximum subarray sum is printed to the console.

	The time complexity of the above implementation of Kadane's algorithm for finding the maximum subarray sum is O(n),
	where n is the length of the input array. This is because we are iterating over each element of the array only once.

	The space complexity of the implementation is O(1), as we are only using a constant amount of extra space for
	storing the maximum subarray sum and the current subarray sum.

	Example Input: arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    Example Output: 6
    Explanation: The maximum subarray sum is [4, -1, 2, 1] which adds up to 6.

*/
package main

import (
	"fmt"
	"math"
)

// Kadanes algorithm
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

// Brute Force Solution
func maxSubarraySumBruteForce(nums []int) int {
    maxSum := math.MinInt32 // Initialize the maximum sum to the smallest possible integer
    n := len(nums)

    // Consider all possible subarrays and keep track of the maximum sum
    for i := 0; i < n; i++ {
        currSum := 0 // Initialize the current sum to 0

        // Consider all subarrays starting from i and ending at j
        for j := i; j < n; j++ {
            currSum += nums[j] // Add the jth element to the current sum

            // Update the maximum sum if the current sum is greater
            if currSum > maxSum {
                maxSum = currSum
            }
        }
    }

    return maxSum
}


func main() {
	arr := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	maxSum := maxSubarraySum(arr)
	fmt.Println("Maximum subarray sum:", maxSum)
	maxSum = maxSubarraySumBruteForce(arr)
	fmt.Println("Maximum subarray sum using brute force:", maxSum)
}
