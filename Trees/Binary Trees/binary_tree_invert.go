// Invert Binary tree
package main

type BinaryTreeNode struct {
	left  *BinaryTreeNode
	data  int
	right *BinaryTreeNode
}
// Time Complexity: O(n). Space Complexity: O(n).
// Approach: The inverse of an empty tree is an empty tree
// The inverse of a tree with root r, and subtrees right and left is a tree with
// root, whose right subtree is the inverse of left and whoose left subtree
// is the inverse of right
func InvertTree(root *BinaryTreeNode) *BinaryTreeNode {
	if root != nil {
		root.left, root.right = InvertTree(root.right), InvertTree(root.left)
	}
	return root
}

// Time Complexity: O(n). Space Complexity: O(n).
// Method2 : swap pointers
func InvertTree2(root *BinaryTreeNode) *BinaryTreeNode {
	if root == nil {
		return root
	}
	// swap the pointers in this node
	root.left, root.right = root.right, root.left
	InvertTree(root.left)
	InvertTree(root.right)
	return root
}
