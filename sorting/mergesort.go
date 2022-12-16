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

// Approach: Divide by finding the number mid of the position midway between left and right. Do this step the same
// way we found the midpoint in binary search
// Conquer by recursively sorting the subarrays in each of the two subproblems created by the divide step.
// That is, recursively sort the subarray Arr[left. . mid] and recursively sort the subarray Arr[mid + 1. . right].
// Combine by merging the two sorted subarrays back into the single sorted subarray Arr[left. . right].
func MergeSort(Arr []int) []int {
	if len(Arr) <= 1 {
		return Arr
	}
	middle := len(Arr) / 2
	left := MergeSort(Arr[:middle])
	right := MergeSort(Arr[middle:])
	return Merge(left, right)
}

func Merge(left, right []int) []int {
	result := make([]int, len(left) + len(right))
	for i:=0; len(left) > 0 || len(right) > - 0; i++ {
		if len(left) > 0 && len(right) > 0 {
			if left[0] < right[0] {
				result[i] = left[0]
				left = left[1:]
			} else {
				result[i] = right[0]
				right = right[1:]
			}
		} else if len(left) > 0 {
			result[i] = left[0]
			left = left[1:]
		} else if len(right) > 0 {
			result[i] = right[0]
			right = right[1:]
		}
	}
	return result
}