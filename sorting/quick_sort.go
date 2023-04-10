// Quicksort
/*
	In this implementation, we use the standard algorithm for quicksort:

	1. Choose a pivot element (we choose the middle element in this case)
	2. Partition the array into two subarrays: elements less than the pivot go to the left subarray,
	   and elements greater than the pivot go to the right subarray
	3. Recursively sort the left and right subarrays using the same algorithm

	The quicksort function takes three arguments: the array to be sorted, the left index of the subarray,
	and the right index of the subarray. We start by choosing the pivot element (in this case, the middle element),
	initializing two pointers to the left and right ends of the subarray, and then partitioning the array into two
	subarrays by moving elements less than the pivot to the left subarray and elements greater than the pivot to
	the right subarray. We repeat this process until the subarrays have length 0 or 1.

	Once the subarrays are partitioned, we recursively sort the left and right subarrays using the quicksort function.
	We use two conditional statements to check if the left or right subarray has length greater than 1 and call quicksort
	on that subarray if it does. Finally, the sorted array is returned.
*/
package main

import "fmt"

// Quicksort function to sort an array of integers in ascending order
func quicksort(arr []int, left, right int) {
	// Choose pivot element (middle element in this case)
	pivot := arr[(left+right)/2]

	// Initialize two pointers to left and right ends of subarray
	i := left
	j := right

	// Partition array into two subarrays: elements less than pivot
	// go to the left subarray and elements greater than pivot go to
	// the right subarray. Repeat until subarrays have length 0 or 1.
	for i <= j {
		// Find first element in left subarray greater than pivot
		for arr[i] < pivot {
			i++
		}
		// Find first element in right subarray less than pivot
		for arr[j] > pivot {
			j--
		}
		// Swap elements at i and j if they are in the wrong subarray
		if i <= j {
			arr[i], arr[j] = arr[j], arr[i]
			i++
			j--
		}
	}

	// Recursively sort left and right subarrays
	if left < j {
		quicksort(arr, left, j)
	}
	if i < right {
		quicksort(arr, i, right)
	}
}

func main() {
	// Example usage
	arr := []int{3, 7, 1, 8, 4, 2, 9, 5, 6}
	quicksort(arr, 0, len(arr)-1)
	fmt.Println(arr) // Output: [1 2 3 4 5 6 7 8 9]
}
