// Delete binary tree
package main

type BinaryTreeNode struct {
	left  *BinaryTreeNode
	data  int
	right *BinaryTreeNode
}

// Time Complexity: O(n). Space Complexity: O(n).
// Approach: before deleting parent node, delete all its children nodes
// using post order traversal we can solve this problem 
func DeleteTree(root *BinaryTreeNode) *BinaryTreeNode {
	if root == nil {
		return nil
	}
	// delete both subtrees
	root.left = DeleteTree(root.left)
	root.right = DeleteTree(root.right)
	// delete current node after deleting subtrees
	root = nil
	return root
}