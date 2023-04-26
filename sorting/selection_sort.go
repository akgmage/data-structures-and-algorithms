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

// selectionSort sorts an array of integers in ascending order
// using the selection sort algorithm.
func selectionSort(arr []int) {
	// Loop over the array from start to end
	for i := 0; i < len(arr); i++ {
		// Assume the current index contains the minimum value
		minIdx := i
		// Loop over the rest of the array to find the minimum value
		for j := i + 1; j < len(arr); j++ {
			// If a value is found that is smaller than the current minimum,
			// update the minimum index
			if arr[j] < arr[minIdx] {
				minIdx = j
			}
		}
		// Swap the minimum value with the current index
		arr[i], arr[minIdx] = arr[minIdx], arr[i]
	}
}

func main() {
	// Example usage
	arr := []int{5, 3, 6, 2, 10}
	fmt.Println("Before sorting:", arr)
	selectionSort(arr)
	fmt.Println("After sorting:", arr)
}
