package main

import "fmt"

// TreeNode definition
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	var result []int
	var stack []*TreeNode
	current := root

	for current != nil || len(stack) > 0 {
		// Traverse all the way to the leftmost node, pushing each node onto the stack
		for current != nil {
			stack = append(stack, current)
			current = current.Left
		}

		// Pop the top node from the stack (current leftmost node)
		current, stack = stack[len(stack)-1], stack[:len(stack)-1]

		// Add the value of the current node to the result slice
		result = append(result, current.Val)

		// Move to the right subtree of the current node
		current = current.Right
	}

	return result
}

func main() {
	// Create a sample binary tree
	root := &TreeNode{Val: 1, Right: &TreeNode{Val: 2, Left: &TreeNode{Val: 3}}}

	// Perform in-order traversal
	result := inorderTraversal(root)

	// Print the result
	fmt.Println(result) // Output: [1 3 2]
}
