/*
	Write a function that takes in a non-empty array of integers that are sorted
	in ascending order and returns a new array of the same length with the squares
	of the original integers also sorted in ascending order.

	Sample Input: [-6, 1, 2, 3, 4]
	Output: [1, 4, 6, 16, 36]

	Explanation:

	The `SortedSquaredArray` function takes an integer array as input and returns a new array where each element is the square of the corresponding element in the input array. The new array is sorted in non-decreasing order.

	Here's a step-by-step explanation of the code:

	1. Initialize an empty result array of the same length as the original array: `result := make([]int, len(array))`.
	2. Initialize variables to mark the start and end positions of the array, as well as the end_pos, which is the 
	   index of the last element in the result array: `end_pos := len(array) - 1`, `start := 0`, `end := len(array) - 1`.
	3. Inside the loop, calculate the square of the absolute value for the elements at the current start and 
	   end positions: `sq1 = array[start] * array[start]`, `sq2 = array[end] * array[end]`.
	4. Compare `sq1` and `sq2` to determine which one is greater. If `sq1` is greater, assign it to the `end_pos` 
	   index of the result array and increment the start position by 1: `result[end_pos] = sq1`, `start++`. 
	   This ensures that the greater squared value is placed at the end of the result array.
	5. If `sq2` is greater, assign it to the `end_pos` index of the result array and decrement the end position 
	   by 1: `result[end_pos] = sq2`, `end--`. This ensures that the greater squared value is still placed at the 
	   end of the result array.
	6. Decrement the `end_pos` variable to move to the previous index in the result array: `end_pos--`.
	7. Repeat the process until the start and end positions cross each other.
	8. Finally, return the result array, which contains the squared values of the input array elements 
	   in non-decreasing order.

	The code effectively uses a two-pointer approach to compare the squared values of the elements at the start and end positions and places the greater squared value at the end of the result array. This ensures that the result array is sorted in non-decreasing order.

	The time complexity of the `SortedSquaredArray` function is O(n), where n is the length of the input array. This is because the function performs a single pass through the array to calculate the squares and populate the result array.

	The space complexity of the function is O(n) as well. This is because it creates a new result array of the same length as the input array to store the squared values. Therefore, the space required is proportional to the size of the input array.

	Overall, the function has a linear time complexity and linear space complexity.
*/
package main

import "fmt"

func SortedSquaredArray(array []int) []int {
	// initialize empty result array of same length as original array
	result := make([]int, len(array))
	// mark start and end, and end_pos
	end_pos := len(array) - 1
	start := 0
	sq1 := 0
	sq2 := 0
	end := len(array) - 1
	// using two pointer appraoch take the  absolute value's square 
	// add the greatest at end of output array
	for start <= end {
		sq1 = array[start] * array[start]
		sq2 = array[end] * array[end]
		if sq1 > sq2 {
			result[end_pos] = sq1
			start++ // square of start pointer is greater so increment start by 1 
		} else {
			result[end_pos] = sq2
			end-- // // square of end pointer is greater so decrement end by 1 
		}
		end_pos--
	}
	return result
}

func main() {
	arr := []int{-6, 1, 2, 3, 4, 5}
	msg := SortedSquaredArray(arr)
	fmt.Println(msg)
}