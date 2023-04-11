// Breadth First Search
/*
	In this implementation, we define a Graph struct that represents a graph with a given number of vertices,
	edges, and a visited array to keep track of visited vertices. We also define two methods - addEdge to
	add an edge to the graph and BFS to perform the BFS algorithm.

	In the BFS method, we start by creating a queue to store the vertices to visit. We mark the start node
	as visited and enqueue it. Then, while the queue is not empty, we dequeue a vertex from the queue,
	print it out, and get all its adjacent vertices. For each adjacent vertex, if it hasn't been visited,
	we mark it as visited and enqueue it. This continues until all reachable vertices have been visited.

	In the main function, we create a new Graph with 5 vertices and add edges to it. We then perform
	BFS starting from vertex 2, and print out the visited vertices. The output of this program will be:
	BFS starting from vertex 2:
	2 0 3 1

	The time complexity of BFS (Breadth-First Search) algorithm is O(V + E), where V is the number of
	vertices and E is the number of edges in the graph. This is because BFS traverses all the vertices
	and edges of the graph exactly once, and the time taken to visit each vertex and edge is constant.
	Therefore, the time complexity of BFS is proportional to the size of the graph.

	The space complexity of BFS is O(|V|), where |V| is the number of vertices in the graph.
	This is because in the worst case scenario, we would need to store all vertices in the queue
	before we finish traversing the graph.
*/
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

