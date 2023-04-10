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
