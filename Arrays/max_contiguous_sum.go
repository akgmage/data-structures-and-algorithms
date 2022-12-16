// Given an array of 􀝊 numbers, give an algorithm for finding
// a contiguous subsequence A(i). . . A(j) for which the sum of elements is maximum.
// Example: {-2, 11, -4, 13, -5, 2} → 20 and {1, -3, 4, -2, -1, 6} → 7
package main

import "fmt"

// MaxContiguousSum: give max contiguous sum in supplied array
// Approach: Bruteforce tru all possibilities and select maximum sum
// Time complexity O(n3)
func MaxContiguousSum(Arr []int) int {
	maxSum, n := 0, len(Arr)
	for i := 0; i < n; i++ {
		for j := i; j < n; j++ {
			currentSum := 0
			// range over i to j and calculate sum
			for k := i; k <= j; k++ {
				currentSum += Arr[k]
			}
			// if sum exceeds maxsum so far then set max sum as currsum
			if currentSum > maxSum {
				maxSum = currentSum
			}
		}
	}
	return maxSum
}

// Time complexity O(n2)
func MaxContiguousSum2(Arr []int) int {
	maxSum, n := 0, len(Arr)
	for i := 0; i < n ; i++ {
		currentSum := 0
		for j := i; j < n; j++ {
			currentSum += Arr[j]
			if currentSum > maxSum {
				maxSum = currentSum
			}
		} 
	} 
	return maxSum
}

func main() {
	Arr :=  []int{-2, 11, -4, 13, -5, 2}
	fmt.Println(MaxContiguousSum(Arr))
	Arr = []int{1, -3, 4, -2, -1, 6}
	fmt.Println(MaxContiguousSum(Arr))
	fmt.Println(MaxContiguousSum2(Arr))
}