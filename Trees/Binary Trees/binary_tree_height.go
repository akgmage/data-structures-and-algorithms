// Binary tree Find height
package main

type BinaryTreeNode struct {
	left  *BinaryTreeNode
	data  int
	right *BinaryTreeNode
}

// Time Complexity: O(n). Space Complexity: O(n).
// Approach: Recursively calculate height of left and right subtrees of a node 
// and assign height to the node as max of heights of two children + 1
func Height(root *BinaryTreeNode) int {
	if root == nil {
		return 0
	} else {
		// compute depth of each subtree
		leftHeight := Height(root.left)
		rightHeight := Height(root.right)
		if leftHeight > rightHeight {
			return leftHeight + 1
		} else {
			return rightHeight + 1
		}

	}
}