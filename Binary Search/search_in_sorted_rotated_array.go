
package main

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
