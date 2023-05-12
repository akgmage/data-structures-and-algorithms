/*
	Breadth First Search:
	Sample Input:
		A
     /  |  \
    B   C   D
   / \     / \
  E   F   G   H
     / \   \
    I   J   K
	Output: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"]
*/
package main

// Define a Node struct that has a name and a slice of child nodes.
type Node struct {
	Name     string
	Children []*Node
}

// Define a method BreadthFirstSearch on the Node struct that takes an array of strings as an argument.
// This method performs a breadth-first search on the tree starting from the node the method is called on.
// It appends the names of all nodes visited to the input array and returns the modified array.
func (n *Node) BreadthFirstSearch(array []string) []string {
	// Create a queue of nodes starting with the current node.
	queue := []*Node{n}
	
	// While there are still nodes in the queue to be visited:
	for len(queue) > 0 {
		// Dequeue the first node in the queue and add its name to the array.
		current := queue[0]
		queue = queue[1:]
		array = append(array, current.Name)

		// Add all of the node's children to the end of the queue.
		for _, child := range current.Children {
			queue = append(queue, child)
		}
	}

	// Return the modified array.
	return array
}
