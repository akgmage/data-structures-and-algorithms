package main

import "fmt"

// Define a Graph struct to represent a graph
type Graph struct {
	vertices int        // Number of vertices in the graph
	edges    [][]int    // Adjacency list to store edges
	visited  []bool     // Track if a vertex is visited or not
}

// Function to add an edge to the graph
func (g *Graph) addEdge(u, v int) {
	// Add edge from u to v
	g.edges[u] = append(g.edges[u], v)
	// Add edge from v to u
	g.edges[v] = append(g.edges[v], u)
}

// Function to perform Breadth First Search
func BFS(g *Graph, start int) {
	// Create a queue for BFS
	queue := []int{}
	// Mark the start node as visited and enqueue it
	g.visited[start] = true
	queue = append(queue, start)

	for len(queue) != 0 {
		// Dequeue a vertex from the queue
		currVertex := queue[0]
		queue = queue[1:]
		fmt.Printf("%d ", currVertex)

		// Get all adjacent vertices of the dequeued vertex currVertex
		// If an adjacent vertex has not been visited, mark it as visited and enqueue it
		for _, adjVertex := range g.edges[currVertex] {
			if !g.visited[adjVertex] {
				g.visited[adjVertex] = true
				queue = append(queue, adjVertex)
			}
		}
	}
}

func main() {
	// Create a new graph with 5 vertices
	g := Graph{
		vertices: 5,
		edges:    make([][]int, 5),
		 // Initially all vertices are unvisited
		visited:  make([]bool, 5),
	}

	// Add edges to the graph
	g.addEdge(0, 1)
	g.addEdge(0, 2)
	g.addEdge(1, 2)
	g.addEdge(2, 0)
	g.addEdge(2, 3)
	g.addEdge(3, 3)

	// Perform BFS starting from vertex 2
	fmt.Println("BFS starting from vertex 2:")
	BFS(&g, 2)
}

