/*
	The code snippet represents a function `SearchInSortedMatrix` that searches for a target value in a sorted matrix and returns the position (row and column) of the target if found, or [-1, -1] if not found.

	Here's how the code works:

	1. Initialize the starting position at the top-right corner of the matrix, i.e., `row = 0` and `col = len(matrix[0]) - 1`.

	2. Enter a loop that continues as long as the current position is within the matrix bounds, i.e., `row < len(matrix)` and `col >= 0`.

	3. Inside the loop, compare the value at the current position (`matrix[row][col]`) with the target value:
	- If the value is greater than the target, it means the target value must be in a lower column, so decrement the column
	   index (`col--`).
	- If the value is less than the target, it means the target value must be in a higher row, so increment the row index
	  (`row++`).
	- If the value is equal to the target, it means the target value is found. Return the position as [row, col].

	4. If the loop completes without finding the target value, it means the target is not present in the matrix. Return [-1, -1]
	   to indicate that the target was not found.

	The code takes advantage of the sorted nature of the matrix to perform an efficient search. By starting at the top-right
	corner and comparing the current value with the target, it eliminates rows and columns in each iteration, narrowing down the search space until the target is found or the entire matrix is traversed.

	Overall, the code has a time complexity of O(N + M), where N is the number of rows in the matrix and M is the number of
	columns, as it performs a linear search through the matrix.

	Time complexity: O(n + m) time where n is the length of the matrix's rows and m is the length of the matrix's columns
	Space complexity: O(1)
*/
package main

import "fmt"

func SearchInSortedMatrix(matrix [][]int, target int) []int {
	// Initialize the starting position at the top-right corner of the matrix
	row, col := 0, len(matrix[0])-1

	// Continue the loop as long as the current position is within the matrix bounds
	for row < len(matrix) && col >= 0 {
		// Compare the value at the current position with the target value
		if matrix[row][col] > target {
			// If the value is greater than the target, move to the left column
			col--
		} else if matrix[row][col] < target {
			// If the value is less than the target, move to the next row
			row++
		} else {
			// If the value is equal to the target, return the position [row, col]
			return []int{row, col}
		}
	}

	// If the loop completes without finding the target, return [-1, -1]
	return []int{-1, -1}
}


func main() {
	matrix := [][]int{
		{1, 4, 7, 12, 15, 1000},
		{2, 5, 19, 31, 32, 1001},
		{3, 8, 24, 33, 35, 1002},
		{40, 41, 42, 44, 45, 1003},
		{99, 100, 103, 106, 128, 1004},
	}

	target := 33

	result := SearchInSortedMatrix(matrix, target)
	if result[0] == -1 && result[1] == -1 {
		fmt.Println("Target not found in the matrix")
	} else {
		fmt.Println("Target found at position:", result)
	}
}