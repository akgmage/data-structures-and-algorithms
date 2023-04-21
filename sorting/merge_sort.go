// In computer science, merge sort (also commonly spelled as mergesort) is an efficient, general-purpose,
// and comparison-based sorting algorithm. Most implementations produce a stable sort,
// which means that the order of equal elements is the same in the input and output.
// Merge sort is a divide-and-conquer algorithm that was invented by John von Neumann in 1945.
// A detailed description and analysis of bottom-up merge sort appeared in a report by Goldstine and von Neumann as early as 1948.
// Conceptually, a merge sort works as follows:

// Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
// Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list
// Source(https://en.wikipedia.org/wiki/Merge_sort)
package main

// MergeSort is the main function that takes an integer array as input
// and sorts it using the Merge Sort algorithm.
func MergeSort(arr []int) []int {
	// If the array has only one element, return it.
	if len(arr) == 1 {
		return arr
	}

	// Find the middle point to divide the array into two halves.
	mid := len(arr) / 2

	// Split the array into two halves.
	left := arr[:mid]
	right := arr[mid:]

	// Recursively sort the left half of the array.
	left = MergeSort(left)

	// Recursively sort the right half of the array.
	right = MergeSort(right)

	// Merge the two sorted halves.
	return merge(left, right)
}

// Merge is a helper function that takes two sorted arrays and merges them into one sorted array.
func merge(left, right []int) []int {
	// Initialize a new array to hold the merged result.
	result := make([]int, len(left)+len(right))

	// Initialize the index variables for the left, right, and result arrays.
	i := 0 // Index for left array
	j := 0 // Index for right array
	k := 0 // Index for result array

	// Iterate over the left and right arrays and compare their elements.
	// Add the smaller element to the result array and move the corresponding index variable.
	for i < len(left) && j < len(right) {
		if left[i] < right[j] {
			result[k] = left[i]
			i++
		} else {
			result[k] = right[j]
			j++
		}
		k++
	}

	// Append the remaining elements of the left or right array to the result array.
	for i < len(left) {
		result[k] = left[i]
		i++
		k++
	}

	for j < len(right) {
		result[k] = right[j]
		j++
		k++
	}

	// Return the merged and sorted result array.
	return result
}