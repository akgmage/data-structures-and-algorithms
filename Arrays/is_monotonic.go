/*
	An array is said to be monotonic in nature if it is either continuously increasing or continuously decreasing.
	Mathematically, An array A is continuously increasing if for all i <= j, A[i] <= A[j].
*/
package main

import "fmt"


func IsMonotonic(array []int) bool {
	// assume the array is non-decreasing until we find a decreasing element
	isNonDecreasing := true 
	// assume the array is non-increasing until we find an increasing element
	isNonIncreasing := true 
	for i := 1; i < len(array); i++ {
		if array[i] < array[i - 1] {
			// if the current element is less than the previous element, the array is not non-decreasing
			isNonDecreasing = false
		}
		if array[i] > array[i - 1] {
			// if the current element is greater than the previous element, the array is not non-increasing
			isNonIncreasing = false
		}
	}
	// return true if the array is either non-decreasing or non-increasing
	return isNonDecreasing || isNonIncreasing 
}

func main() {
	Arr := []int{1, 2, 3, 4, 5}
	Arr2 := []int{5, 4, 3, 2, 1}
	fmt.Println(IsMonotonic(Arr))
	fmt.Println(IsMonotonic(Arr2))
}