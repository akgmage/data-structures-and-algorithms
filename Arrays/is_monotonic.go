/*
	An array is said to be monotonic in nature if it is either continuously increasing or continuously decreasing.
	Mathematically, An array A is continuously increasing if for all i <= j, A[i] <= A[j].

	The IsMonotonic function takes an array of integers and returns a boolean value indicating whether the array
	is monotonic or not. A monotonic array is one in which the elements are either non-increasing or non-decreasing.

	The function works by initializing two boolean variables, isNonDecreasing and isNonIncreasing, to true.
	It then iterates over the array from the first element to the second-to-last element, comparing each element to the next one.

	If the current element is less than the next element, it sets isNonDecreasing to false, indicating that the
	array is not non-decreasing. If the current element is greater than the next element, it sets isNonIncreasing to false,
	indicating that the array is not non-increasing.

	At the end of the loop, the function returns true if either isNonDecreasing or isNonIncreasing is still true,
	indicating that the array is monotonic. Otherwise, it returns false.

	O(n) time | O(1) space - where n is the length of the array
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