/*
   This implementation represents a graph as a collection of nodes, where each node has a value and a list of
   neighboring nodes. The DFS algorithm is implemented recursively by starting from the given node, marking
   it as visited, and printing its value. Then, the algorithm recursively visits each of the neighboring
   nodes that have not been visited yet. The time complexity of DFS is O(V + E), where V is the number of
   vertices (nodes) in the graph and E is the number of edges between the vertices.

   Sample Input : graph = {
   'A': ['B', 'C'],
   'B': ['D', 'E'],
   'C': ['F'],
   'D': [],
   'E': ['F'],
   'F': []
   }
   Output : DFS Traversal: A B D E F C
   Here, we have a graph represented as an adjacency list, with nodes A, B, C, D, E, and F and their respective neighbors.
   The DFS traversal starts at node A and visits each node in the graph, outputting the final order in which the nodes were visited.

   The time complexity of the DFS algorithm is O(V + E), where V is the number of vertices (nodes) and E is the number of
   edges in the graph. This is because the algorithm visits every vertex and every edge once.

   The space complexity of DFS depends on the maximum depth of the recursion stack. In the worst case, where the tree or
   graph is completely unbalanced, the recursion stack can reach a depth of O(n), where n is the number of nodes in the graph.
   Therefore, the space complexity of DFS is O(n).

*/
package main

import "fmt"

// Node represents a single node in the graph
type Node struct {
    value int
    visited bool
    neighbors []*Node
}

// DFS traverses the graph starting from the given node using Depth First Search
func DFS(node *Node) {
    // Mark the current node as visited
    node.visited = true

    // Print the value of the current node
    fmt.Printf("%d ", node.value)

    // Visit each of the neighboring nodes
    for _, neighbor := range node.neighbors {
        // If the neighbor has not been visited yet, visit it recursively
        if !neighbor.visited {
            DFS(neighbor)
        }
    }
}

func main() {
    // Create the nodes of the graph
    node1 := &Node{value: 1}
    node2 := &Node{value: 2}
    node3 := &Node{value: 3}
    node4 := &Node{value: 4}
    node5 := &Node{value: 5}

    // Add the neighbors for each node
    node1.neighbors = []*Node{node2, node3}
    node2.neighbors = []*Node{node1, node4, node5}
    node3.neighbors = []*Node{node1, node5}
    node4.neighbors = []*Node{node2}
    node5.neighbors = []*Node{node2, node3}

    // Start the DFS traversal from node1
    DFS(node1)
}
