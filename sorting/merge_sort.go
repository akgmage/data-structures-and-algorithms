// Merge Sort
/*
	The MergeSort function is the main function that takes an integer array as input and sorts it using the Merge Sort algorithm.

	In the MergeSort function, if the length of the input array is only one element, it is already sorted, so we return it as is.
	Otherwise, we find the middle point of the array and split it into two halves. We then recursively call the MergeSort
	function on the left half and the right half of the array. Finally, we merge the two sorted halves using the merge function.

	The merge function takes two sorted arrays as input and merges them into one sorted array. We initialize a new array to hold
	the merged result and three index variables for the left, right, and result arrays. We then iterate over the left and right
	arrays and compare their elements. We add the smaller element to the result array and move the corresponding index variable.
	Finally, we append the remaining elements of the left or right array to the result array and return it.

	The time complexity of Merge Sort is O(n*log n), where n is the number of elements in the array,
	and the space complexity is O(n) due to the use of the temporary arrays during the merging phase.

*/
package main

import "fmt"

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

func main() {
	// Example usage
	arr := []int{3, 2, 1, 5, 4}
	fmt.Println("Unsorted array:", arr)
	arr = MergeSort(arr)
	fmt.Println("Sorted array:", arr)
}