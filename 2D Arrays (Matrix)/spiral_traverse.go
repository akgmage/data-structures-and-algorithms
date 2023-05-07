/*
	Write a function that takes in an n x m two-dimensional array (that can be square-shaped when n == m) and
	returns a one-dimensional array of all the array's elements in spiral order.

	Spiral order starts at the top left corner of the two-dimensional array, goes to the right, and proceeds
	in a spiral pattern all the way until every element has been visited.

	Explanation:

	The SpiralTraverse function takes a 2D integer array array and returns a 1D integer slice that contains the
	elements of array traversed in a spiral order, starting from the top-left corner and moving clockwise.

	The function first initializes an empty slice result to hold the elements of the spiral traversal.
	If the input array is empty, the function immediately returns the empty result.

	Next, the function initializes variables startRow, endRow, startCol, and endCol to keep track of the
	boundaries of the matrix. These variables will be updated as the function traverses the matrix.

	The function then enters a loop that traverses the matrix in a spiral order. The loop continues
	as long as startRow <= endRow and startCol <= endCol, which means that there are still elements
	in the matrix to be traversed.

	The first step in the loop is to traverse the top row of the matrix from left to right, and append
	each element to the result slice. The next step is to traverse the rightmost column of the matrix from top to bottom,
	and append each element to the result slice. If there is more than one row in the matrix, the function then traverses
	the bottom row of the matrix from right to left, and appends each element to the result slice. If there is only one row left,
	the loop is broken to avoid duplicating the elements. Finally, if there is more than one column in the matrix,
	the function traverses the left

	O(n) time | O(n) space - where n is the total number of elements in the array
*/
package main

import "fmt"

func SpiralTraverse(array [][]int) []int {
	// Initialize an empty slice to hold the result
	result := []int{}
	// If the input array is empty, return the empty result
	if len(array) == 0 {
		return result
	}
	// Initialize variables to keep track of the boundaries of the matrix
	startRow, endRow := 0, len(array)-1
	startCol, endCol := 0, len(array[0])-1

	// Traverse the matrix in a spiral order
	for startRow <= endRow && startCol <= endCol {
		// Traverse the top row from left to right
		for col := startCol; col <= endCol; col++ {
			result = append(result, array[startRow][col])
		}
		// Traverse the rightmost column from top to bottom
		for row := startRow + 1; row <= endRow; row++ {
			result = append(result, array[row][endCol])
		}
		// Traverse the bottom row from right to left, if there is more than one row
		for col := endCol - 1; col >= startCol; col-- {
			// If there is only one row left, break the loop to avoid duplicating the elements
			if startRow == endRow {
				break
			}
			result = append(result, array[endRow][col])
		}
		// Traverse the leftmost column from bottom to top, if there is more than one column
		for row := endRow - 1; row > startRow; row-- {
			// If there is only one column left, break the loop to avoid duplicating the elements
			if startCol == endCol {
				break
			}
			result = append(result, array[row][startCol])
		}
		// Update the boundaries of the matrix
		startRow++
		endRow--
		startCol++
		endCol--
	}
	// Return the result slice
	return result
}

func main() {
	// Example 2D array
	array := [][]int{
		{1, 2, 3, 4},
		{10, 11, 12, 5},
		{9, 8, 7, 6},
	}

	// Call SpiralTraverse function on array
	result := SpiralTraverse(array)

	// Print the result to console
	fmt.Println(result)
}