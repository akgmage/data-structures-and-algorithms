/*
	An array is said to be monotonic in nature if it is either continuously increasing or continuously decreasing.
	Mathematically, An array A is continuously increasing if for all i <= j, A[i] <= A[j].
*/
package main

import "fmt"

func IsMonotonic(Arr []int) bool {
	if len(Arr) < 2 {
		return true
	}

	isIncreasing := 0

	for i := 1; i < len(Arr); i++ {
		if isIncreasing == 0 {
			if Arr[i - 1] > Arr[i] {
				isIncreasing = -1 // means we will check for decreasing
			} else if Arr[i - 1] < Arr[i] {
				isIncreasing = 1 // means we will check for increasing	
			}
		}
		if isIncreasing == 1 && Arr[i - 1] > Arr[i] {
			return false // in increasing array element before other element cannot be less so return false
		}
		if isIncreasing == -1 && Arr[i - 1] < Arr[i] {
			return false // in decreasing array element after other element cannot be greater so return false
		}
	}
	return true
}

func main() {
	Arr := []int{1, 2, 3, 4, 5}
	Arr2 := []int{5, 4, 3, 2, 1}
	fmt.Println(IsMonotonic(Arr))
	fmt.Println(IsMonotonic(Arr2))
}