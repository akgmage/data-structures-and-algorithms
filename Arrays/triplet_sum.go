/*
Given an array of integers, nums, and an integer value, target,
determine if there are any three integers in nums whose sum equals the target.
Return TRUE if three such integers are found in the array. Otherwise, return FALSE.
*/

package main

import (
	"fmt"
	"sort"
	"strings"
)

// Time complexity : Sorting the array O(n log(n)) and Nested loop to find triplet O(n^{2}) which can be simplified to O(n^{2})
// Space complexity is O(1) since we use a fixed amount of extra space in memory.
// FindSumOfThree is our challenge function
func findSumOfThree(nums []int, target int) bool {
	// Sorting the input vector
	sort.Sort(sort.IntSlice(nums))

	// We create two pointers to track our indices and, variable to store our triple sum
	low, high, triple := 0, 0, 0

	// Fix one element at a time and find the other two
	for i := 0; i < len(nums) - 2; i++ {
		// Set the indices of the two pointers
		// Index of the first of the remaining elements
		low = i + 1

		// Last index
		high = len(nums) - 1

		for low < high {
			// Check if the sum of the triple is equal to the sum
			triple = nums[i] + nums[low] + nums[high]

			// Found a triple whose sum equals the target
			if triple == target {
				return true

			// Move low pointer forward if the triple sum is less than the required sum
			} else if triple < target {
				low += 1
			} else {
				// Move the high pointer backwards if the triple sum is greater than the required sum
				high -= 1
			}
		}
	}
	return false
}

// Driver code
func main() {
	numsLists := [][]int {
		{3, 7, 1, 2, 8, 4, 5},
		{-1, 2, 1, -4, 5, -3},
		{2, 3, 4, 1, 7, 9},
		{1, -1, 0},
		{2, 4, 2, 7, 6, 3, 1},
	}
	testLists := [][]int {
		{10, 20, 21},
		{-8, 0, 7},
		{8, 10, 20},
		{1, -1, 0},
		{8, 11, 15},
	}
	for i, nList := range numsLists {
		fmt.Printf("%d. Input array: %s\n", i + 1, strings.Replace(fmt.Sprint(nList), " ", ", ", -1))
		for _, tList := range testLists[i] {
			if findSumOfThree(nList, tList) {
				fmt.Printf("   Sum for %d exists\n", tList)
			} else {
				fmt.Printf("   Sum for %d does not exist\n", tList)
			}
		}
		fmt.Printf("%s\n", strings.Repeat("-", 100))
	}
}