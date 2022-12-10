package main

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