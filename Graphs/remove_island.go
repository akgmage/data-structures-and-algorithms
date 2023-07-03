package main

// Function to remove islands in a binary matrix
func RemoveIslands(matrix [][]int) [][]int {
	// Create a boolean matrix to track if each cell is connected to the border
	onesConnectedToBorder := make([][]bool, len(matrix))
	for i := range matrix {
		onesConnectedToBorder[i] = make([]bool, len(matrix[0]))
	}

	// Mark 1s connected to the border
	for row := 0; row < len(matrix); row++ {
		for col := 0; col < len(matrix[row]); col++ {
			rowIsBorder := row == 0 || row == len(matrix)-1
			colIsBorder := col == 0 || col == len(matrix[row])-1
			isBorder := rowIsBorder || colIsBorder

			if !isBorder {
				continue // Skip if not a border cell
			}

			if matrix[row][col] != 1 {
				continue // Skip if not a 1
			}

			findOnesConnectedToBorder(matrix, row, col, onesConnectedToBorder)
		}
	}

	// Remove non-border islands
	for row := 0; row < len(matrix)-1; row++ {
		for col := 0; col < len(matrix[row])-1; col++ {
			if onesConnectedToBorder[row][col] {
				continue // Skip if connected to the border
			}

			matrix[row][col] = 0 // Set non-border island to 0
		}
	}

	return matrix
}

// Function to perform DFS and mark 1s connected to the border
func findOnesConnectedToBorder(matrix [][]int, startRow, startCol int, onesConnectedToBorder [][]bool) {
	stack := [][]int{{startRow, startCol}}
	var currentPosition []int

	for len(stack) > 0 {
		currentPosition, stack = stack[len(stack)-1], stack[:len(stack)-1]
		currentRow, currentCol := currentPosition[0], currentPosition[1]
		alreadyVisited := onesConnectedToBorder[currentRow][currentCol]

		if alreadyVisited {
			continue // Skip if already visited
		}

		onesConnectedToBorder[currentRow][currentCol] = true // Mark cell as connected to the border

		neighbors := getNeighbors(matrix, currentRow, currentCol)
		for _, neighbor := range neighbors {
			row, col := neighbor[0], neighbor[1]
			if matrix[row][col] != 1 {
				continue // Skip if not a 1
			}
			stack = append(stack, neighbor) // Add neighbor to the stack
		}
	}
}

// Function to get valid neighboring cells
func getNeighbors(matrix [][]int, row, col int) [][]int {
	neighbors := make([][]int, 0)
	numRows := len(matrix)
	numCols := len(matrix[row])

	if row-1 >= 0 {
		neighbors = append(neighbors, []int{row - 1, col}) // Top neighbor
	}
	if row+1 < numRows {
		neighbors = append(neighbors, []int{row + 1, col}) // Bottom neighbor
	}
	if col-1 >= 0 {
		neighbors = append(neighbors, []int{row, col - 1}) // Left neighbor
	}
	if col+1 < numCols {
		neighbors = append(neighbors, []int{row, col + 1}) // Right neighbor
	}

	return neighbors
}
