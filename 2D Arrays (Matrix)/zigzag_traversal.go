package main

// ZigzagTraverse traverses a 2D array in a zigzag pattern and returns the elements in a 1D array.
func ZigzagTraverse(array [][]int) []int {
	// Get the height and width of the 2D array.
	height := len(array) - 1
	width := len(array[0]) - 1

	// Initialize variables to keep track of the current position while traversing.
	row, col := 0, 0

	// Initialize a boolean variable to determine the direction of traversal.
	goingDown := true

	// Initialize an array to store the elements traversed in zigzag order.
	result := []int{}

	// The main loop runs until the current position is within bounds (not out of the 2D array).
	for !isOutOfBounds(row, col, height, width) {
		// Append the current element at position (row, col) to the result array.
		result = append(result, array[row][col])

		// Traversal logic: Decide the next position for traversal based on the current position and the goingDown flag.
		if goingDown {
			if col == 0 || row == height {
				// Change direction to upward if at the top-left or bottom-right corner.
				goingDown = false

				// Decide the next position based on whether we are at the bottom or right boundary.
				if row == height {
					col++
				} else {
					row++
				}
			} else {
				// Continue diagonally downward.
				row++
				col--
			}
		} else {
			if row == 0 || col == width {
				// Change direction to downward if at the top-right or bottom-left corner.
				goingDown = true

				// Decide the next position based on whether we are at the top or right boundary.
				if col == width {
					row++
				} else {
					col++
				}
			} else {
				// Continue diagonally upward.
				row--
				col++
			}
		}
	}

	// Return the final result, which contains the elements of the 2D array in zigzag order.
	return result
}

// isOutOfBounds checks if the current position (row, col) is out of bounds of the 2D array.
func isOutOfBounds(row, col, height, width int) bool {
	return row < 0 || col < 0 || row > height || col > width
}
