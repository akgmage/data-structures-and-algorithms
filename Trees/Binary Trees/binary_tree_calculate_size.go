// Size of binary tree
package main

type BinaryTreeNode struct {
	left  *BinaryTreeNode
	data  int
	right *BinaryTreeNode
}
// Time Complexity: O(n). Space Complexity: O(n).
// Approach: calculate the size of left and right subtree recursively
// add 1 (curr node) and return to its parent
func Size(root *BinaryTreeNode) int {
	if root == nil {
		return 0
	} else {
		return Size(root.left) + 1 + Size(root.right)
	}
}

// Time Complexity: O(n). Space Complexity: O(n).
// Approach: use level order traversal and count nodes
func SizeWithoutUsingRecursion(root *BinaryTreeNode) int {
	if root == nil {
		return 0
	}
	var result int
	queue := []*BinaryTreeNode{root}
	for len(queue) > 0 {
		qlen := len(queue)
		//var level []int
		for i := 0; i < qlen; i++ {
			node := queue[0]
			result++
			//level = append(level, node.data)
			queue = queue[1:]
			if node.left != nil {
				queue = append(queue, node.left)
			}
			if node.right != nil {
				queue = append(queue, node.right)
			}
		}
	}
	return result
}