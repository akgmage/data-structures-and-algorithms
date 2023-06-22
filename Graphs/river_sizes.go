/*

  	You're given a two-dimensional array (a matrix) of potentially unequal height and width containing only
	0's and 1's. Each 0 represent land and each 1 represent part of river. A river consists of any number of 1's
	that are either horizontally or vertically adjacent (but not diagonally adjacent).
	The number of adjacent 1's forming a river determine its size.

  	Note that a river can twist. In other words, it doesn't have to be a straight vertical line or a straight
	horizontal line; it can be L-shaped, for example.

  	Write a function that returns an array of the sizes of all rivers represented in the input matrix.
	The sizes don't need to be in any particular order.

	Sample Input:[
					[1, 0, 0, 1, 0],
					[1, 0, 1, 0, 0],
					[0, 0, 1, 0, 1],
					[1, 0, 1, 0, 1],
					[1, 0, 1, 1, 0],
				]
	Output: [1, 2, 2, 2, 5]

	Explanation:

	1. The function `RiverSizes` initializes an empty slice `sizes` to store the sizes of rivers found in the matrix. It also creates a 2D `visited` matrix of the same size as the input matrix to keep track of visited nodes.

	2. The function then iterates over each cell in the matrix using nested loops.

	3. If a cell has already been visited (marked as `true` in the `visited` matrix), the code continues to the next iteration to avoid processing it again.

	4. If a cell has not been visited, the code calls the `traverseNode` function to explore the river connected to that cell and updates the `sizes` slice with the size of the river.

	5. The `traverseNode` function takes the starting position (i, j) of a river, the matrix, the `visited` matrix, and the `sizes` slice as input.

	6. It initializes a variable `currentRiverSize` to 0 to keep track of the size of the river being explored.

	7. It maintains a queue (`nodesToExplore`) to store the nodes that need to be visited. It starts with the initial node (i, j).

	8. The function enters a loop that continues until there are no more nodes to explore in the queue.

	9. In each iteration, it dequeues the first node from the `nodesToExplore` queue and updates the current position (i, j) accordingly.

	10. If the current node has already been visited, the code continues to the next iteration.

	11. If the current node contains a value of 0 (indicating land), the code continues to the next iteration, as it's not part of the river.

	12. If the current node contains a value of 1 (indicating a river), it increments the `currentRiverSize` by 1.

	13. It then retrieves the unvisited neighboring nodes of the current node using the `getUnvisitedNeighbors` function and adds them to the `nodesToExplore` queue.

	14. Once the loop finishes, if the `currentRiverSize` is greater than 0, it appends it to the `sizes` slice.

	15. Finally, the `sizes` slice containing the sizes of all rivers is returned.

	16. The `getUnvisitedNeighbors` function takes the current position (i, j), the matrix, and the `visited` matrix as input.

	17. It checks the four neighboring cells (up, down, left, right) of the current cell and adds the unvisited neighbors to the `unvisitedNeighbors` slice.

	18. The function returns the `unvisitedNeighbors` slice.

	The code essentially performs a depth-first search (DFS) traversal on the matrix to find connected regions of 1s (rivers) and keeps track of their sizes. The `visited` matrix helps avoid revisiting nodes that have already been processed, ensuring each river is counted only once.
*/
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
