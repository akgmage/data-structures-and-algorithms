package main

// This is an input class. Do not edit.
type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

// SymmetricalTree checks if a binary tree is symmetrical.
func SymmetricalTree(tree *BinaryTree) bool {
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
