package main

// This is an input class. Do not edit.
type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

// Approach 1: Recursive Approach
// SymmetricalTree checks if a binary tree is symmetrical.
func SymmetricalTreerecursive(tree *BinaryTree) bool {
	// Call the helper function to check if the left and right subtrees are mirrored.
	return treesAreMirrored(tree.Left, tree.Right)
}

// treesAreMirrored checks if two binary trees are mirrored.
func treesAreMirrored(left, right *BinaryTree) bool {
	// Base case: If both left and right trees are non-nil and have the same value,
	// recursively check if their subtrees are mirrored.
	if left != nil && right != nil && left.Value == right.Value {
		return treesAreMirrored(left.Left, right.Right) && treesAreMirrored(left.Right, right.Left)
	}

	// If either left or right tree is nil or their values are not equal, they are not mirrored.
	// Also, if both left and right trees are nil, they are considered mirrored.
	return left == right
}

// Approach 2: Iterative Approach using Stack
func SymmetricalTreeIterative(tree *BinaryTree) bool {
	stackLeft := []*BinaryTree{tree.Left}   // Initialize stackLeft with the left child of the root node
	stackRight := []*BinaryTree{tree.Right} // Initialize stackRight with the right child of the root node

	// Perform mirror traversal of the left and right subtrees
	for len(stackLeft) > 0 {
		var left, right *BinaryTree
		left, stackLeft = stackLeft[len(stackLeft)-1], stackLeft[:len(stackLeft)-1]       // Pop the top node from stackLeft
		right, stackRight = stackRight[len(stackRight)-1], stackRight[:len(stackRight)-1] // Pop the top node from stackRight

		if left == nil && right == nil {
			continue // Both left and right subtrees are symmetric, continue to the next iteration
		}

		if left == nil || right == nil || left.Value != right.Value {
			return false // Asymmetry detected, tree is not symmetric
		}

		// Push the children of left and right onto the respective stacks in reverse order
		stackLeft = append(stackLeft, left.Left, left.Right)
		stackRight = append(stackRight, right.Right, right.Left)
	}

	return true // Tree is symmetric
}