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

// SingleLeftRotate: left rotate a root, and update node's height, return the new root
// Time Complexity: O(1). Space Complexity: O(1).
func SingleLeftRotate(X *AVLTreeNode) *AVLTreeNode {
	var W *AVLTreeNode
	if X != nil {
		W = X.left
		X.left = W.right
		W.right = X

		X.height = Max(Height(X.left), Height(X.right)) + 1
		W.height = Max(Height(W.left), Height(W.right)) + 1
		X = W
	}
	return X
}

// SingleRightRotate: right rotate a root, and update node's height, return the new root
// Time Complexity: O(1). Space Complexity: O(1).
func SingleRightRotate(X *AVLTreeNode) *AVLTreeNode {
	var W *AVLTreeNode
	if X != nil {
		W = X.right
		X.right = W.right
		W.left = X

		X.height = Max(Height(X.left), Height(X.right)) + 1
		W.height = Max(Height(W.left), Height(W.right)) + 1
		X = W
	}
	return X
}
// DoubleRotateRightLeft: left-right double rotation
func DoubleRotateRightLeft(Z *AVLTreeNode) *AVLTreeNode {
	Z.right = SingleLeftRotate(Z.right)
	return SingleRightRotate(Z)
}

// DoubleRotateLeftRight: right-left double rotation
func DoubleRotateLeftRight(Z *AVLTreeNode) *AVLTreeNode {
	Z.left = SingleRightRotate(Z.left)
	return SingleLeftRotate(Z)
}

func main() {

}