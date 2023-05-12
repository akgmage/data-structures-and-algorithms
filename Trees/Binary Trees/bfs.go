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

	Explanation:
	This code defines a struct `Node` with two properties: `Name`, a string representing the name of the node,
	and `Children`, a slice of pointers to other `Node` objects representing the children of the node.

	The method `BreadthFirstSearch` is defined on `Node`. This method takes an empty string slice `array` as
	an argument and performs a breadth-first search traversal of the tree rooted at the current node.

	It returns a slice of strings representing the names of the nodes visited in breadth-first order.

	The breadth-first search algorithm starts with a queue containing only the current node. The algorithm then proceeds as follows:

	1. Dequeue the first node from the queue.
	2. Add the name of the dequeued node to the `array`.
	3. Enqueue all the children of the dequeued node to the end of the queue.
	4. Repeat steps 1-3 until the queue is empty.

	At the end of the algorithm, the `array` contains the names of all the nodes visited in breadth-first order. The method returns this `array`.

	Time complexity: O(v + e)
	Space complexity: O(v)
	where v is the number of vertices of the input graph and e is the number of edges of the input graph
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
