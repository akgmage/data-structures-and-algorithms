package main

func RiverSizes(matrix [][]int) []int {
	// Slice to store the sizes of rivers
	sizes := []int{}

	// Create a visited matrix to keep track of visited nodes
	visited := make([][]bool, len(matrix))
	for i := range visited {
		visited[i] = make([]bool, len(matrix[i]))
	}

	// Iterate over each cell in the matrix
	for i := range matrix {
		for j := range matrix[i] {
			// If the cell has already been visited, continue to the next iteration
			if visited[i][j] {
				continue
			}

			// Explore the river connected to the current cell and update sizes
			sizes = traverseNode(i, j, matrix, visited, sizes)
		}
	}

	return sizes
}

func traverseNode(i, j int, matrix [][]int, visited [][]bool, sizes []int) []int {
	// Variable to track the size of the current river
	currentRiverSize := 0

	// Queue to store nodes that need to be visited
	nodesToExplore := [][]int{{i, j}}

	// Loop until there are no more nodes to explore
	for len(nodesToExplore) > 0 {
		// Dequeue the first node from the queue and update the current position (i, j)
		currentNode := nodesToExplore[0]
		nodesToExplore = nodesToExplore[1:]
		i, j := currentNode[0], currentNode[1]

		// If the current node has already been visited, continue to the next iteration
		if visited[i][j] {
			continue
		}

		// Mark the current node as visited
		visited[i][j] = true

		// If the current node is land (0), continue to the next iteration
		if matrix[i][j] == 0 {
			continue
		}

		// Increment the size of the current river
		currentRiverSize++

		// Get the unvisited neighboring nodes of the current node
		unvisitedNeighbors := getUnvisitedNeighbors(i, j, matrix, visited)

		// Add the unvisited neighbors to the nodesToExplore queue
		for _, neighbor := range unvisitedNeighbors {
			nodesToExplore = append(nodesToExplore, neighbor)
		}
	}

	// If the current river size is greater than 0, append it to the sizes slice
	if currentRiverSize > 0 {
		sizes = append(sizes, currentRiverSize)
	}

	return sizes
}

func getUnvisitedNeighbors(i, j int, matrix [][]int, visited [][]bool) [][]int {
	// Slice to store unvisited neighboring nodes
	unvisitedNeighbors := [][]int{}

	// Check the four neighboring cells (up, down, left, right) of the current cell
	// and add unvisited neighbors to the unvisitedNeighbors slice

	// Up neighbor
	if i > 0 && !visited[i-1][j] {
		unvisitedNeighbors = append(unvisitedNeighbors, []int{i - 1, j})
	}

	// Down neighbor
	if i < len(matrix)-1 && !visited[i+1][j] {
		unvisitedNeighbors = append(unvisitedNeighbors, []int{i + 1, j})
	}

	// Left neighbor
	if j > 0 && !visited[i][j-1] {
		unvisitedNeighbors = append(unvisitedNeighbors, []int{i, j - 1})
	}

	// Right neighbor
	if j < len(matrix[0])-1 && !visited[i][j+1] {
		unvisitedNeighbors = append(unvisitedNeighbors, []int{i, j + 1})
	}

	return unvisitedNeighbors
}
