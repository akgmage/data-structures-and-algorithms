
'''

   Write a function that computes the lengths of the shortest paths between start and all of the other vertices in the graph using Dijkstra's algorithm and returns them in an array.

   Sample Input:
   Start: 0
   Edges :  = [
        [[1, 7]],
        [[2, 6], [3, 20], [4, 3]],
        [[3, 14]],
        [[4, 2]],
        [],
        [],
    ]
    Output: [0, 7, 13, 27, 10, -1]

   Dijkstras Algorithm

   Explanation:

   The code snippet is an implementation of Dijkstra's algorithm for finding the shortest path from a given starting vertex to all other vertices in a graph. Here's a breakdown of the code:

   1. The `DijkstrasAlgorithm` function takes the starting vertex (`start`) and the graph represented by the adjacency list (`edges`) as input and returns a list of minimum distances from the starting vertex to all other vertices.

   2. It initializes `numberOfVertices` as the total number of vertices in the graph.

   3. The `minDistances` slice is initialized with maximum integer values to represent infinity distance for all vertices. The length of `minDistances` is set to the number of vertices.

   4. The minimum distance from the starting vertex to itself is set to 0.

   5. The `visited` map is used to keep track of visited vertices. Initially, it is empty.

   6. The algorithm iterates until all vertices have been visited. In each iteration, it selects the vertex with the minimum distance from the `minDistances` slice using the `getVertexWithMinDistance` function.

   7. If the current minimum distance is infinity (i.e., no more vertices to visit), the loop breaks.

   8. The selected vertex is marked as visited by adding it to the `visited` map.

   9. For each neighboring vertex of the selected vertex, it calculates the new path distance and updates the `minDistances` if the new distance is smaller.

   10. After all iterations, the `finalDistances` slice is created to convert the `minDistances` into a format where unreachable vertices are represented as -1.

   11. The `getVertexWithMinDistance` function returns the vertex with the minimum distance from the `distances` slice and the current minimum distance.

   Overall, the code implements Dijkstra's algorithm to find the shortest path from a starting vertex to all other vertices in a graph, using an adjacency list representation. It keeps track of minimum distances, visited vertices, and updates the distances based on the neighboring vertices.

   Time Complexity: O(V^2 + e)
   Space complexity: O(V)

'''

import "math"

# DijkstrasAlgorithm finds the shortest path from a starting vertex to all other vertices in a graph.
func DijkstrasAlgorithm(start int, edges [][][]int) []int {
	numberOfVertices := len(edges)
	minDistances := make([]int, 0, len(edges))

	# Initialize the minDistances slice with maximum integer values
	for range edges {
		minDistances = append(minDistances, math.MaxInt32)
	}

	# Set the distance of the starting vertex to 0
	minDistances[start] = 0
	visited := map[int]bool{}

	# Iterate until all vertices have been visited
	for len(visited) != numberOfVertices {
		# Get the vertex with the minimum distance
		vertex, currentMinDistance := getVertexWithMinDistance(minDistances, visited)

		# If the current minimum distance is infinity, break the loop
		if currentMinDistance == math.MaxInt32 {
			break
		}

		# Mark the vertex as visited
		visited[vertex] = true

		# Explore neighboring vertices
		for _, edge := range edges[vertex] {
			destination, distanceToDestination := edge[0], edge[1]

			# Skip if the destination vertex is already visited
			if visited[destination] {
				continue
			}

			# Calculate the new path distance to the destination
			newPathDistance := currentMinDistance + distanceToDestination
			currentDestinationDistance := minDistances[destination]

			# Update the minimum distance if the new distance is smaller
			if newPathDistance < currentDestinationDistance {
				minDistances[destination] = newPathDistance
			}
		}
	}

	# Convert the minDistances slice to finalDistances, representing unreachable vertices as -1
	finalDistances := make([]int, 0, len(minDistances))
	for _, distance := range minDistances {
		if distance == math.MaxInt32 {
			finalDistances = append(finalDistances, -1)
		} else {
			finalDistances = append(finalDistances, distance)
		}
	}

	return finalDistances
}

# getVertexWithMinDistance returns the vertex with the minimum distance from the distances slice.
func getVertexWithMinDistance(distances []int, visited map[int]bool) (int, int) {
	currentMinDistance := math.MaxInt32
	vertex := -1

	# Find the vertex with the minimum distance among unvisited vertices
	for vertexIdx, distance := range distances {
		if visited[vertexIdx] {
			continue
		}

		if distance <= currentMinDistance {
			vertex = vertexIdx
			currentMinDistance = distance
		}
	}

	return vertex, currentMinDistance
}
