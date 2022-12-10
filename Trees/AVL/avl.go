package main

/*
	A binary tree is said to be an AVL tree, if:
		1 It is a binary search tree, and
		2 For any node N, the height of left subtree of N and height of right subtree of N differ by at most 1.
*/
type AVLTreeNode struct {
	data   int
	left   *AVLTreeNode
	right  *AVLTreeNode
	height int
}

// Height: returns the height of AVL tree
// Time Complexity: O(1)
func Height(node *AVLTreeNode) int {
	if node == nil {
		return -1
	} else {
		return node.height
	}
}

func main() {

}