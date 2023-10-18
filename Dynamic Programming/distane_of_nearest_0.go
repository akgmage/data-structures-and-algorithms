// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell in Java

// Solution
// // This solution uses a breadth-first search (BFS) approach to calculate the distance of the nearest 0 for each cell in the matrix.
// // The idea is to initialize a distances matrix with all values set to the maximum integer value, except for the cells that contain 0s,
// // which are set to 0 and added to a queue. We then perform a BFS on the queue, updating the distances of neighboring cells as we go.
// // Finally, we return the updated distances matrix.

// Time Complexity:

// We traverse the entire matrix in the worst case to fill the distances matrix with initial values, which takes O(m * n) time.
// We use Breadth-First Search (BFS) to update the distances matrix, which in the worst case can visit each cell once, taking O(m * n) time.
// Therefore, the total time complexity of this solution is O(m * n).

// Space Complexity:

// We store the distances matrix, which requires O(m * n) space.
// We use a queue to implement the BFS algorithm, which can store at most m * n cells in the worst case, taking O(m * n) space.
// Therefore, the total space complexity of this solution is O(m * n).

package main

import (
	"container/list"
	"math"
)

var directions = [][2]int{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}

func updateMatrix(mat [][]int) [][]int {
	m := len(mat)
	n := len(mat[0])
	distances := make([][]int, m) // Initialize a distances matrix

	// Initialize distances to math.MaxInt32 except for cells with 0
	for i := range distances {
		distances[i] = make([]int, n)
		for j := range distances[i] {
			distances[i][j] = math.MaxInt32
			if mat[i][j] == 0 {
				distances[i][j] = 0
			}
		}
	}

	queue := list.New() // Initialize a queue for BFS

	// Perform BFS
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if mat[i][j] == 0 {
				queue.PushBack([2]int{i, j}) // Add the cell to the queue
			}
		}
	}

	for queue.Len() > 0 {
		element := queue.Front()
		queue.Remove(element)
		cell := element.Value.([2]int)
		i, j := cell[0], cell[1]

		for _, direction := range directions {
			x, y := i+direction[0], j+direction[1]

			// Check if cell is out of bounds
			if x < 0 || x >= m || y < 0 || y >= n {
				continue
			}

			// Check if distance is already smaller
			if distances[x][y] <= distances[i][j]+1 {
				continue
			}

			distances[x][y] = distances[i][j] + 1 // Update the distance
			queue.PushBack([2]int{x, y})         // Add the cell to the queue
		}
	}

	return distances // Return the updated distances matrix
}
