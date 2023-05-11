// File: tim_sort.go
//Implementation of Tim Sort
//Tim Sort makes use of insertionSort and Merge function of MergeSort
//The basic idea is to divide the input array into blocks called as runs
//The size of runs varies from 32 to 64, and perform insertion sort on the runs
//Then, The runs(blocks) are merged to form the final sorted array
//
//Time Complexity of this algorithm in Best case is O(n),Average case is O(n*log(n))
//Time Complexity in Worst case is O(n*log(n)).
//This is a stable sorting algorithm
//This algorithm uses Space of O(n)
//This algorithm is used in languages like Java and Python for sorting.

package main

import (
	"fmt"
	"math"
)

func	main() {

	arr := []int{43, 56, 2, 99, 1, 64, 23, 78, 34, 11, 90, 45, 32, 67, 88, 12, 9, 10, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}
	n := len(arr)
	fmt.Printf("Before Sorting\n")
	printArray(arr, n)
	timSort(arr, n)
	fmt.Printf("Sorted Array is\n")
	printArray(arr, n)
}

func	timSort(arr []int, n int) {

	run := 32
	// you can take any value between 32 to 64, it actually is some empirical result from insertion s 
	for i := 0; i < n; i += run {
		insertionSort(arr, i, int(math.Min(float64(i + 31), float64(n - 1))))
	}

	for size := run; size < n; size = 2 * size {
		for left := 0; left < n; left += 2 * size {
			mid := left + size - 1
			right := int(math.Min(float64(left + 2 * size - 1), float64(n - 1)))
			merge(arr, left, mid, right)
		}
	}
}

func	insertionSort(arr []int, left int, right int) {
	for i := left + 1; i <= right; i++ {
		j := i
		for j > left && arr[j] < arr[j - 1] {
			arr[j], arr[j - 1] = arr[j - 1], arr[j]
			j--
		}
	}
}

func	merge(arr []int, left int, mid int, right int) {

	// function to merge the two sorted arrays
	len1 := mid - left + 1
	len2 := right - mid
	leftArr := make([]int, len1)
	rightArr := make([]int, len2)

	for i := 0; i < len1; i++ {
		leftArr[i] = arr[left + i]
	}
	for j := 0; j < len2; j++ {
		rightArr[j] = arr[mid + 1 + j]
	}

	i := 0
	j := 0
	k := left

	for i < len1 && j < len2 {
		if leftArr[i] <= rightArr[j] {
			arr[k] = leftArr[i]
			i++
		} else {
			arr[k] = rightArr[j]
			j++
		}
		k++
	}

	for i < len1 {
		arr[k] = leftArr[i]
		i++
		k++
	}

	for j < len2 {
		arr[k] = rightArr[j]
		j++
		k++
	}
}


// Function to print the array
func	printArray(arr []int, n int) {
	for i := 0; i < n; i++ {
		fmt.Printf("%d ", arr[i])
	}
	fmt.Printf("\n")
}

// to run in terminal
// $ go run tim_sort.go

// Output
// Before Sorting
// 43 56 2 99 1 64 23 78 34 11 90 45 32 67 88 12 9 10 3 4 5 6 7 8 9 10 11 12 13 14 15
// Sorted Array is
// 1 2 3 4 5 6 7 8 9 9 10 10 11 11 12 12 13 14 15 23 32 34 43 45 56 64 67 78 88 90 99
