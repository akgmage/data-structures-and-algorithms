/*
	Remoev island that are not connected to Border

	Sample Input:

	1 0 0 0 0 0
	0 1 0 1 0 1
	0 0 1 0 1 1
	1 1 0 0 1 0
	1 0 1 1 0 0

	Output:
	1 0 0 0 0 0
	0 0 0 0 0 1
	0 0 0 0 1 1
	1 1 0 0 1 0
	1 0 1 1 0 0

	Explanation:
	The provided code snippet is an implementation of the "Remove Islands" algorithm. This algorithm aims to identify and remove
	islands in a binary matrix. An island is a connected region of 1s surrounded by 0s. The algorithm marks islands connected
	to the border of the matrix as non-islands and returns the modified matrix.

		Let's break down the code snippet and explain each part:

		1. Initialization:

		onesConnectedToBorder := make([][]bool, len(matrix))
		for i := range matrix {
			onesConnectedToBorder[i] = make([]bool, len(matrix[0]))
		}

		This part initializes a 2D boolean array `onesConnectedToBorder`, which has the same dimensions as the input matrix. It is used to mark cells that are connected to the border.

		2. Marking Ones Connected to Border:

		for row := 0; row < len(matrix); row++ {
			for col := 0; col < len(matrix[row]); col++ {
				rowIsBorder := row == 0 || row == len(matrix)-1
				colIsBorder := col == 0 || col == len(matrix[row])-1
				isBorder := rowIsBorder || colIsBorder
				if !isBorder {
					continue
				}
				if matrix[row][col] != 1 {
					continue
				}
				findOnesConnectedToBorder(matrix, row, col, onesConnectedToBorder)
			}
		}

		This part iterates through the matrix and checks if each cell is on the border. If a cell is on the border and contains a 1, it calls the `findOnesConnectedToBorder` function to mark the connected 1s using a depth-first search approach. The connected 1s are marked in the `onesConnectedToBorder` array.

		3. Removing Non-Border Islands:

		for row := 0; row < len(matrix)-1; row++ {
			for col := 0; col < len(matrix[row])-1; col++ {
				if onesConnectedToBorder[row][col] {
					continue
				}
				matrix[row][col] = 0
			}
		}

		This part iterates through the matrix again, excluding the border cells. If a cell is not marked as connected to the border (an island cell), it is set to 0, effectively removing the island.

		4. Utility Functions:
		The code also includes two utility functions:
		- `findOnesConnectedToBorder`: This function performs a depth-first search (DFS) to mark all the 1s connected to a border cell. It uses a stack to keep track of the cells to visit next.
		- `getNeighbors`: This function returns the valid neighboring cells (up, down, left, right) for a given cell in the matrix.

		Finally, the modified matrix is returned as the result.

		O(wh) time | O(wh) space - where w and h are the width and height of the input matrix	

		Note: The code snippet provided assumes that the matrix is a 2D integer slice (`[][]int`) and uses Go syntax..
*/
package main

import "fmt"

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

func main() {
	// Example usage
	matrix := [][]int{
		{1, 0, 0, 0, 0, 0},
		{0, 1, 0, 1, 0, 1},
		{0, 0, 1, 0, 1, 1},
		{1, 1, 0, 0, 1, 0},
		{1, 0, 1, 1, 0, 0},
	}

	fmt.Println("Original Matrix:")
	printMatrix(matrix)

	updatedMatrix := RemoveIslands(matrix)

	fmt.Println("Updated Matrix:")
	printMatrix(updatedMatrix)
}

// Helper function to print the matrix
func printMatrix(matrix [][]int) {
	for _, row := range matrix {
		for _, val := range row {
			fmt.Printf("%d ", val)
		}
		fmt.Println()
	}
}





