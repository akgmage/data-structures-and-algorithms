package main

func NumberOfWaysToTraverseGraph(width int, height int) int {
	// Initialize the numberOfWays matrix with dimensions (height+1) x (width+1)
	// The extra "+1" is to account for the boundary cases when traversing the graph
	numberOfWays := make([][]int, height+1)
	for i := range numberOfWays {
		numberOfWays[i] = make([]int, width+1)
	}

	// Iterate over the graph cells
	for widthIdx := 1; widthIdx < width+1; widthIdx++ {
		for heightIdx := 1; heightIdx < height+1; heightIdx++ {
			// Check if the current cell is on the top row or the leftmost column
			if widthIdx == 1 || heightIdx == 1 {
				// If so, there is only one way to reach this cell (moving right or moving down)
				numberOfWays[heightIdx][widthIdx] = 1
			} else {
				// If the cell is not on the top row or the leftmost column,
				// calculate the number of ways to reach this cell based on the
				// number of ways to reach the cell above (up) and the cell to the left (left)
				waysLeft := numberOfWays[heightIdx][widthIdx-1]
				waysUp := numberOfWays[heightIdx-1][widthIdx]
				numberOfWays[heightIdx][widthIdx] = waysLeft + waysUp
			}
		}
	}

	// Return the number of ways to reach the bottom-right corner of the graph
	return numberOfWays[height][width]
}
