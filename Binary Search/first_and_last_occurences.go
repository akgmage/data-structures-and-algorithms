package main

import "fmt"

// If x is present in arr[], return the index of the first occurrence of x.
// Otherwise, return -1.
func first(arr []int, low, high, x int) int {
	if high >= low {
		mid := (low + high) / 2

		if (mid == 0 || x > arr[mid-1]) && arr[mid] == x {
			return mid
		} else if arr[mid] < x {
			return first(arr, mid+1, high, x)
		} else {
			return first(arr, low, mid-1, x)
		}
	}

	return -1
}

// If x is present in arr[], return the index of the last occurrence of x.
// Otherwise, return -1.
func last(arr []int, low, high, x int) int {
	if high >= low {
		mid := (low + high) / 2

		if (mid == len(arr)-1 || x < arr[mid+1]) && arr[mid] == x {
			return mid
		} else if arr[mid] > x {
			return last(arr, low, mid-1, x)
		} else {
			return last(arr, mid+1, high, x)
		}
	}

	return -1
}

func main() {
	var n, x int
	fmt.Scan(&n)
	fmt.Scan(&x)

	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&arr[i])
	}

	low, high := 0, n-1

	firstOccurrence := first(arr, low, high, x)
	lastOccurrence := last(arr, low, high, x)

	fmt.Println("First Occurrence:", firstOccurrence)
	fmt.Println("Last Occurrence:", lastOccurrence)
}
