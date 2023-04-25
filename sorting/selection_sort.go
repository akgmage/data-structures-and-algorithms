/*
	Selection sort is a simple sorting algorithm that works by repeatedly finding the minimum element from an 
	unsorted part of the array and putting it at the beginning of the array. 
    
    In each iteration, the minimum element is found by comparing each element of the unsorted part of the array with the current minimum 
	element, and if a smaller element is found, it becomes the new minimum element. 
    
    Once the minimum element is found, it is swapped with the first element of the unsorted part of the array. 

	This process is repeated until the entire array is sorted. The main idea behind selection sort is to divide 
	the array into two parts: a sorted part and an unsorted part. 
    
    Initially, the sorted part is empty, and the unsorted part is the entire array. In each iteration, the minimum element is selected from 
	the unsorted part and added to the end of the sorted part.

	The time complexity of selection sort is O(n^2) in both the best and worst cases, where n is the number 
	of elements in the array. This is because for each element in the array, it needs to compare it with 
	every other element to find the smallest one, which takes O(n) time. Since this process needs to be 
	repeated for each element, the overall time complexity becomes O(n^2).

	The space complexity of selection sort is O(1) because it does not require any extra space other than 
	the input array itself. It performs the sorting in place by swapping the elements within the array.
*/
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