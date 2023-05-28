// Remove leaf nodes
package main

type BinaryTreeNode struct {
	left  *BinaryTreeNode
	data  int
	right *BinaryTreeNode
}

// Time Complexity: O(n). Space Complexity: O(n).
// Approach: recurse both left and right subtree and check if the node doesn't have
// left and right children
func RemoveLeafNodes(root *BinaryTreeNode) *BinaryTreeNode {
	if root == nil {
		return root
	}
	// if it doesnt have left and right children then delete it
	if root.left == nil && root.right == nil {
		root = nil
		return root
	} else { // recurse to left and right subtree
		root.left = RemoveLeafNodes(root.left)
		root.right = RemoveLeafNodes(root.right)
	}
	return root
}