/*
	Write a function that takes in a potentially invalid Binary Search Tree (BST) and returns a boolean representing
	whether the BST is valid.

	Explanation:

	This code defines a Binary Search Tree (BST) struct with an integer value and left and right nodes that can point to other
	BST nodes. The struct also has a method called ValidateBst() that returns a boolean indicating whether the tree is a valid
	BST or not.

	The BST struct has another method called validateBST() that is used by ValidateBst() to check whether the tree is a valid
	BST or not. The validateBST() method takes in two arguments, min and max, which represent the minimum and maximum values
	that the current node's value can take in order to be a valid BST.

	The validateBST() method first checks whether the current node's value is within the valid range determined by the min and
	max arguments. If not, the method returns false, indicating that the tree is not a valid BST.

	If the current node's value is within the valid range, the method then recursively calls itself on the left and right
	child nodes to check whether their values are within their valid ranges. The valid range for the left child node is defined by the minimum value and the parent node's value, while the valid range for the right child node is defined by the parent node's value and the maximum value.

	If all of the nodes in the tree satisfy the BST property, the method returns true, indicating that the tree is a valid BST.

	O(n) time | O(d) space - where n is the number of nodes in the BST and d is the depth (height) of the BST
*/
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
