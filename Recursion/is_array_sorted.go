/*
	Given an array, check whether the array is in sorted order with recursion.
*/
// Time Complexity: O(n). Space Complexity: O(n) for recursive stack space.

package main

import "fmt"

// Time Complexity: O(n). Space Complexity: O(n) for recursive stack space.
func isSorted(A []int) bool {
	n := len(A)
	if n == 1 {
		return true
	}
	if A[n - 1] < A[n - 2] {
		return false
	}
	return isSorted(A[:n-1])
}

func main() {
	A := []int{10, 20, 23, 23, 45, 78, 88}
	fmt.Println(isSorted(A))
	A = []int{10, 20, 23, 7, 23, 45, 78, 88}
	fmt.Println(isSorted(A))
}