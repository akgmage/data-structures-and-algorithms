// Implementation of selection sort.
// Selection sort is an in-place comparison sorting algorithm.
// It has an O(n^{2}) time complexity which makes it inefficient on large lists,
// and generally performs worse than the similar insertion sort.
// Selection sort is noted for its simplicity and has performance advantages
// over more complicated algorithms in certain situations,
// particularly where auxiliary memory is limited. (Source wiki) https://en.wikipedia.org/wiki/Selection_sort

// Sample Input : [2, 1, 9, 3, 5, 4, 0]
// Output : [0 1 2 3 4 5 9]
package main

import "fmt"

func SelectionSort(arr []int, length int) []int {
	for i := 0; i < length-1; i++ {
		imin := i
		for j := i + 1; j < length; j++ {
			// find minumim element's index
			if arr[j] < arr[imin] {
				imin = j
			}
		}
		// bring min element to front
		arr[i], arr[imin] = arr[imin], arr[i]
	}
	return arr
}

func main() {
	arr := []int{2, 1, 9, 3, 5, 4, 0}
	msg := SelectionSort(arr, 7)
	fmt.Println(msg)
}