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
