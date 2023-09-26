package main

import "math"

type BST struct {
	Value int

	Left  *BST
	Right *BST
}

// ValidateBst is a method of BST that checks if the binary search tree is valid
func (tree *BST) ValidateBst() bool {
	return tree.validateBST(math.MinInt32, math.MaxInt32)
}

// validateBST is a recursive helper function that checks if the binary search tree is valid
// min is the minimum value that a node in the subtree rooted at this node can have
// max is the maximum value that a node in the subtree rooted at this node can have
func (tree *BST) validateBST(min, max int) bool {
	// if the current node's value is outside the allowed range, then the tree is invalid
	if tree.Value < min || tree.Value >= max {
		return false
	}
	// recursively check the left subtree, making sure all values are less than the current node's value
	if tree.Left != nil && !tree.Left.validateBST(min, tree.Value) {
		return false
	}
	// recursively check the right subtree, making sure all values are greater than or equal to the current node's value
	if tree.Right != nil && !tree.Right.validateBST(tree.Value, max) {
		return false
	}
	// if we reach this point, then the tree is valid
	return true
}
